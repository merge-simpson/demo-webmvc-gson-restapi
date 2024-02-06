package example.gson.properties;

import jakarta.validation.ValidationException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

import java.util.TimeZone;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @param pretty JSON 직렬화 시 이쁘게 보여 줄 건지 ^^
 * @param timeZone 타임존은 예를 들어 "Asia/Seoul" 등에 해당함.
 */
@ConfigurationProperties("app.gson")
@ConfigurationPropertiesBinding
public record DemoGsonProperties(
        Boolean pretty,
        String timeZone
) {
    public DemoGsonProperties {
        if (pretty == null) {
            pretty = false;
        }

        if (timeZone == null || timeZone.isBlank()) {
            timeZone = "Asia/Seoul";
        } else {
            // stream을 두 차례 이상 사용하기 위해.
            Supplier<Stream<String>> allTimeZoneSupplier =
                    () -> Stream.of(TimeZone.getAvailableIDs());
            String tz = timeZone; // cuz' stream requires: (명시적인) local 변수 or final 변수
            if (allTimeZoneSupplier.get().noneMatch((item) -> item.equals(tz))) {
                String listString = allTimeZoneSupplier.get()
                        .reduce(
                                "",
                                (old, cur) ->
                                        STR."""
                                        \{old}
                                        ❣️\{cur}
                                        """
                        );

                String message = STR."""
                        Time zone of \{timeZone} is not valid time zone.

                        Choose one of them:
                        \{listString}
                        """;

                throw new ValidationException(message);
            }
        }
    }
}