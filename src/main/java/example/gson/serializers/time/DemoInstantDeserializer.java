package example.gson.serializers.time;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class DemoInstantDeserializer implements JsonDeserializer<Instant> {
    @Override
    public Instant deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context
    ) throws JsonParseException {
        String timeString = json.getAsString();

        try {
            return Instant.parse(timeString);
        } catch (DateTimeParseException e) {
            return Instant.from(LocalDateTime.parse(timeString));
        }
    }
}