import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

       
        System.out.println("Value for key 'Apple': " + map.get("Apple"));

        
        map.remove("Banana");
        System.out.println("HashMap after removing 'Banana': " + map);

        
        System.out.println("Iterating over HashMap:");
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        System.out.println("Contains key 'Orange': " + map.containsKey("Orange"));
        System.out.println("Contains value 30: " + map.containsValue(30));
        System.out.println("Contains key 'Banana': " + map.containsKey("Banana"));
        System.out.println("Contains value 20: " + map.containsValue(20));
    }
}
