package example.gson.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import example.gson.properties.DemoGsonProperties;
import example.gson.serializers.time.DemoInstantDeserializer;
import example.gson.serializers.time.DemoInstantSerializer;
import example.gson.serializers.time.DemoLocalDateTimeDeserializer;
import example.gson.serializers.time.DemoLocalDateTimeSerializer;
import example.gson.serializers.time.DemoOffsetDateTimeDeserializer;
import example.gson.serializers.time.DemoOffsetDateTimeSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Configuration
@RequiredArgsConstructor
@ConfigurationPropertiesScan(basePackageClasses = DemoGsonProperties.class)
public class GsonWebConfig {
    @Bean
    public Gson gson(DemoGsonProperties gsonProperties) {
        // [1] Register serializers/deserializers
        GsonBuilder builder = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new DemoLocalDateTimeSerializer())
                .registerTypeAdapter(LocalDateTime.class, new DemoLocalDateTimeDeserializer())
                .registerTypeAdapter(
                        OffsetDateTime.class,
                        new DemoOffsetDateTimeSerializer()
                )
                .registerTypeAdapter(
                        OffsetDateTime.class,
                        new DemoOffsetDateTimeDeserializer(gsonProperties.timeZone())
                )
                .registerTypeAdapter(Instant.class, new DemoInstantSerializer())
                .registerTypeAdapter(Instant.class, new DemoInstantDeserializer());

        if (gsonProperties.pretty()) {
            builder.setPrettyPrinting();
        }

        // [2] create gson bean
        return builder.create();
    }
}