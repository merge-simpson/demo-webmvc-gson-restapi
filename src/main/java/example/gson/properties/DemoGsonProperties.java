package example.gson.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

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
        }
    }
}