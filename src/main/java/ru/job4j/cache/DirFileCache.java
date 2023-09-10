package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String out = null;
        try {
            out = Files.readString(Path.of(cachingDir + "/" + key));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    public static void main(String[] args) {
        AbstractCache<String, String> dirFileCache = new DirFileCache("./src/main/java/ru/job4j/cache");
        //    System.out.println(dirFileCache.load("Names.txt"));
        System.out.println(dirFileCache.get("Names.txt"));
    }
}