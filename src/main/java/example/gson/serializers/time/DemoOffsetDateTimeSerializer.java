package example.gson.serializers.time;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public final class DemoOffsetDateTimeSerializer implements JsonSerializer<OffsetDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    @Override
    public JsonElement serialize(
            OffsetDateTime src,
            Type typeOfSrc,
            JsonSerializationContext context
    ) {
        return new JsonPrimitive(formatter.format(src));
    }
}