package zafrani.com.pubgapp.utils;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import zafrani.com.pubgapp.models.ItemContainer;
import zafrani.com.pubgapp.models.ItemList;

public class UtilityFunctions {


    public static ItemList generateItemList(Context context) {
        final String TAG = "UtilityFunctions.class";
        try {


            Gson gson = new GsonBuilder().serializeNulls().create();

            File f = new File(context.getCacheDir() + "/item.json");


            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null) {
                    Log.e(TAG, line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            JsonReader reader = new JsonReader(new FileReader(f));

            handleObject(reader);

            ItemContainer items = gson.fromJson(reader, ItemContainer.class);

            if (items.getCategories() != null) {
                for (int i = 0; i < items.getCategories().size(); i++) {
                    Log.e(TAG, items.getCategories().get(i).toString());

                }

            } else {
                Log.e(TAG, "Item Container is empty.");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void handleObject(JsonReader reader) throws IOException
    {
        reader.beginObject();
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_ARRAY))
                handleArray(reader);
            else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else
                handleNonArrayToken(reader, token);
        }

    }

    /**
     * Handle a json array. The first token would be JsonToken.BEGIN_ARRAY.
     * Arrays may contain objects or primitives.
     *
     * @param reader
     * @throws IOException
     */
    public static void handleArray(JsonReader reader) throws IOException
    {
        reader.beginArray();
        while (true) {
            JsonToken token = reader.peek();
            if (token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                handleObject(reader);
            } else if (token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
            } else
                handleNonArrayToken(reader, token);
        }
    }

    /**
     * Handle non array non object tokens
     *
     * @param reader
     * @param token
     * @throws IOException
     */
    public static void handleNonArrayToken(JsonReader reader, JsonToken token) throws IOException
    {
        if (token.equals(JsonToken.NAME))
            System.out.println(reader.nextName());
        else if (token.equals(JsonToken.STRING))
            System.out.println(reader.nextString());
        else if (token.equals(JsonToken.NUMBER))
            System.out.println(reader.nextDouble());
        else
            reader.skipValue();
    }
}


}
