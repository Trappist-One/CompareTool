package org.xukz.compare.context;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xukz
 * @since 1.0
 */
public class CompareResult {

    @Setter
    @Getter
    private String identity;

    private Map<String, Object> newMap = new LinkedHashMap<>();

    private Map<String, Object> delMap = new LinkedHashMap<>();

    private Map<String, Object> modMap = new LinkedHashMap<>();


    public void addResult(String identity, Object value, Type type) {
        switch (type) {
            case NEW -> newMap.put(identity, value);
            case DEL -> delMap.put(identity, value);
            case MOD -> modMap.put(identity, value);
        }

    }

    public static enum Type {
        NEW,
        DEL,
        MOD
    }
}
