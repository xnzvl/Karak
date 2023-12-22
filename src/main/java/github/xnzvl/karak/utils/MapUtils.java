package github.xnzvl.karak.utils;

import java.util.Collection;
import java.util.HashMap;

public class MapUtils {
    private MapUtils() {
        // not meant for instantiation
    }

    public static <K, V> HashMap<K, V> defaultHashMapFrom(
            Collection<K> keys,
            V defaultValue
    ) {
        HashMap<K, V> kvMap = new HashMap<>(keys.size());
        for (var key : keys) {
            kvMap.put(key, defaultValue);
        }
        return kvMap;
    }
}
