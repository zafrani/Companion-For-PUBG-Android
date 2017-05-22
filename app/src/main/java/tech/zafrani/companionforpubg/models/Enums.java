package tech.zafrani.companionforpubg.models;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class Enums {
    @NonNull
    public static <T extends Enum<T>> T fromString(@Nullable final String value,
                                                   @NonNull final T[] values) {
        if (!TextUtils.isEmpty(value)) {
            for (T possibleMatch : values) {
                if (possibleMatch.name().equalsIgnoreCase(value)) {
                    return possibleMatch;
                }
            }
        }
        throw new IllegalStateException("unknown enum value");
    }


    public interface FromString {
    }

    public static class Serialization implements JsonDeserializer<Object>, JsonSerializer<Object> {
        @Override
        public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            String string = json.getAsJsonPrimitive().getAsString();
            try {
                Class<?> enumClass = (Class<?>) typeOfT;
                Method fromString = enumClass.getDeclaredMethod("fromString", String.class);
                return fromString.invoke(null, string);
            } catch (NoSuchMethodException e) {
                throw new JsonParseException("Missing fromString method on enum implementing Enums.FromString", e);
            } catch (Exception e) {
                throw new JsonParseException(e);
            }
        }

        @Override
        public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }
    }
}