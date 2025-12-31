package com.amalitech.nosqlblog.cache;

public class CacheKey {
    private final String key;

    public CacheKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
