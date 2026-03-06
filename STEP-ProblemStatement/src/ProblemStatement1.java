import java.util.*;

public class ProblemStatement1 {

    static HashMap<String, Integer> stock = new HashMap<>();
    static HashMap<String, LinkedList<Integer>> waiting = new HashMap<>();

    public static void main(String[] args) {
        stock.put("IPHONE15_256GB", 100);
        waiting.put("IPHONE15_256GB", new LinkedList<>());

        System.out.println(checkStock("IPHONE15_256GB"));
        System.out.println(purchaseItem("IPHONE15_256GB", 12345));
        System.out.println(purchaseItem("IPHONE15_256GB", 67890));

        stock.put("IPHONE15_256GB", 0);
        System.out.println(purchaseItem("IPHONE15_256GB", 99999));
    }

    static String checkStock(String product) {
        int s = stock.getOrDefault(product, 0);
        return s + " units available";
    }

    static synchronized String purchaseItem(String product, int userId) {
        int s = stock.getOrDefault(product, 0);

        if (s > 0) {
            stock.put(product, s - 1);
            return "Success, " + (s - 1) + " units remaining";
        } else {
            LinkedList<Integer> list = waiting.get(product);
            list.add(userId);
            return "Added to waiting list, position #" + list.size();
        }
    }
}