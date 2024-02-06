package example.gson.serializers.time;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

public final class DemoOffsetDateTimeDeserializer implements JsonDeserializer<OffsetDateTime> {
    private final ZoneId zoneId;

    public DemoOffsetDateTimeDeserializer(String timeZone) {
        zoneId = ZoneId.of(timeZone);
    }

    @Override
    public OffsetDateTime deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context
    ) throws JsonParseException {
        String timeString = json.getAsString();
        try {
            return OffsetDateTime.parse(timeString); // FE 쪽에 이 양식을 권장
        } catch (DateTimeParseException e) {
            // 현 시점에서 오프셋 값을 얻습니다.
            ZoneOffset zoneOffset = OffsetDateTime.now(zoneId).getOffset();

            return OffsetDateTime.of(
                    LocalDateTime.parse(timeString),
                    zoneOffset
            );
        }
    }
}