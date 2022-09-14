package io.github.rawchickenneg.copperandcrystalreborn.util;

import com.google.gson.JsonElement;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

public class FileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
    
    public static String toResourcePath(String name) {
        return name.toLowerCase(Locale.ROOT).replace('$', '/');
    }
    
    @Nullable
    public static JsonElement loadJsonResource(String filepath) {
        InputStream resource = ClassLoader.getSystemResourceAsStream(filepath);
        return resource == null ? null : loadJson(resource);
    }
    
    @Nullable
    public static JsonElement loadJson(InputStream inputStream) {
        try {
            JsonReader reader = new JsonReader(new BufferedReader(new InputStreamReader(inputStream)));
            reader.setLenient(true);
            JsonElement element = Streams.parse(reader);
            reader.close();
            inputStream.close();
            return element;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
