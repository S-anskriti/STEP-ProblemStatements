import java.util.*;
public class ProblemStatement1 {
        static HashMap<String, Integer> users = new HashMap<>();
        static HashMap<String, Integer> attempts = new HashMap<>();

        public static void main(String[] args) {
            users.put("john_doe", 1);
            users.put("admin", 2);
            System.out.println(checkAvailability("john_doe"));
            System.out.println(checkAvailability("jane_smith"));
            System.out.println(suggestAlternatives("john_doe"));
            System.out.println(getMostAttempted());
        }
        static boolean checkAvailability(String username) {
            attempts.put(username, attempts.getOrDefault(username, 0) + 1);
            if (users.containsKey(username)) return false;
            return true;
        }
        static List<String> suggestAlternatives(String username) {
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= 3; i++) {
                String s = username + i;
                if (!users.containsKey(s)) list.add(s);
            }
            list.add(username.replace("_", "."));
            return list;
        }
        static String getMostAttempted() {
            String name = "";
            int max = 0;
            for (String key : attempts.keySet()) {
                if (attempts.get(key) > max) {
                    max = attempts.get(key);
                    name = key;
                }
            }
            return name;
        }
    }