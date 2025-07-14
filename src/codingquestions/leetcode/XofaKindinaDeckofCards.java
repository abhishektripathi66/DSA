import java.util.HashMap;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards
 * Solved
 * Easy
 * Topics
 * Companies
 * You are given an integer array deck where deck[i] represents the number written on the ith card.
 * <p>
 * Partition the cards into one or more groups such that:
 * <p>
 * Each group has exactly x cards where x > 1, and
 * All the cards in one group have the same integer written on them.
 * Return true if such partition is possible, or false otherwise.
 */
public class XofaKindinaDeckofCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) return false;
        Map<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            a.put(deck[i], a.getOrDefault(deck[i], 0) + 1);
        }

        int ans = 0;

        for (int key : a.keySet()) {

            ans = gcd(ans, a.get(key));
        }

        return ans >= 2 ? true : false;


    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
