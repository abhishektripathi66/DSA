package datastructures.treemap;

import java.util.TreeMap;
import java.util.Map;

public class TreeMapExample {
    public static void main(String[] args) {

        TreeMap<String, String> map = new TreeMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key1", "value1");

        String value = map.get("key2");
        System.out.println("Value for key2: " + value);

        map.remove("key2");

        System.out.println("Iterating over TreeMap using for-each loop:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        boolean containsKey = map.containsKey("key3");
        System.out.println("TreeMap contains 'key3': " + containsKey);

        boolean containsValue = map.containsValue("value3");
        System.out.println("TreeMap contains 'value3': " + containsValue);

        int size = map.size();
        System.out.println("Size of TreeMap: " + size);
        map.clear();
        System.out.println("Size of TreeMap after clear: " + map.size());
    }
}
