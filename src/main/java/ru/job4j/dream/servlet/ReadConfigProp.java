package ru.job4j.dream.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ReadConfigProp {
    private static final ReadConfigProp INST = new ReadConfigProp("./resources/.properties");
    private String path;
    private final Map<String, String> values = new HashMap<>();

    public ReadConfigProp(final String path) {
        this.path = path;
        this.load();
    }

    private void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            String line = read.readLine();
            while (line != null) {
                if (line.equals("")) {
                    line = read.readLine();
                    continue;
                }
                if (!line.startsWith("#")) {
                    int inx = line.indexOf("=");
                    values.put(line.substring(0, inx), line.substring(inx + 1));
                }
                    line = read.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Pairs key=value arn't in " + path);
        }
    }

    public String value(String key) {
        return values.getOrDefault(key, null);
    }

    public static ReadConfigProp getInstance() {
        return INST;
    }
}