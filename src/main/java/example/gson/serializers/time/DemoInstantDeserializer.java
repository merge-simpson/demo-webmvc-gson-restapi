package example.gson.serializers.time;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public final class DemoInstantDeserializer implements JsonDeserializer<Instant> {
    // TODO Instant 파싱할 때 각각 어느 포맷에 관한 코드인지 확인해서 주석에 추가
    @Override
    public Instant deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context
    ) throws JsonParseException {
        String timeString = json.getAsString();

        try {
            // format: ""
            return Instant.parse(timeString);
        } catch (DateTimeParseException e) {
            // format: ""
            return Instant.from(LocalDateTime.parse(timeString));
        }
    }
}