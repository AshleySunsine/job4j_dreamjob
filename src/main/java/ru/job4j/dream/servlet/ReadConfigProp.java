package ru.job4j.dream.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ReadConfigProp {
    private static String path = "./resources/dream.properties";
    private static final Map<String, String> VALUES = new HashMap<>();

    private static void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            String line = read.readLine();
            while (line != null) {
                if (line.equals("")) {
                    line = read.readLine();
                    continue;
                }
                if (!line.startsWith("#")) {
                    int inx = line.indexOf("=");
                    VALUES.put(line.substring(0, inx), line.substring(inx + 1));
                }
                    line = read.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Pairs key=value arn't in " + path);
        }
    }

    public static String value(String key) {
        ReadConfigProp.load();
        return VALUES.getOrDefault(key, null);
    }


}