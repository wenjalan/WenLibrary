package wenjalan.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CollectionUtils {

    // non instantiable
    private CollectionUtils() {
        throw new AssertionError("class is non-instantiable");
    }

    // reverse a shallow map <K, V> to <V, K>
    public static <K, V> Map<V, K> reverseMap(Map<K, V> map) {
        Map<V, K> vkMap = new HashMap<>();
        for (Iterator<K> iter = map.keySet().iterator(); iter.hasNext();) {
            K key = iter.next();
            V val = map.get(key);
            vkMap.put(val, key);
        }
        return vkMap;
    }

}
