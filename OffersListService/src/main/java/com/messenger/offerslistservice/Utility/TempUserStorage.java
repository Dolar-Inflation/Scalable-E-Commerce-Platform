package com.messenger.offerslistservice.Utility;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TempUserStorage {
    private final Map<String, String> storage = new ConcurrentHashMap<>();

    public void put(String sub, String username) {
        storage.put(sub, username);
    }

    public String pop(String sub) {
        return storage.remove(sub); // удаляем после чтения
    }
}

