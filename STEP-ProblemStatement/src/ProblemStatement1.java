import java.util.*;

public class ProblemStatement1 {

    static HashMap<String, Set<String>> map = new HashMap<>();
    static int n = 5;

    public static void main(String[] args) {

        String doc1 = "this is a simple essay written by a student for testing plagiarism detection system";
        String doc2 = "this is a simple essay written by a student for checking plagiarism in documents";

        addDocument("essay_089.txt", doc1);
        addDocument("essay_092.txt", doc2);

        analyzeDocument("essay_123.txt", doc1);
    }

    static void addDocument(String id, String text) {
        String[] w = text.split(" ");

        for (int i = 0; i <= w.length - n; i++) {
            String g = "";
            for (int j = 0; j < n; j++) {
                g += w[i + j] + " ";
            }

            if (!map.containsKey(g)) {
                map.put(g, new HashSet<>());
            }

            map.get(g).add(id);
        }
    }

    static void analyzeDocument(String id, String text) {
        String[] w = text.split(" ");
        HashMap<String, Integer> count = new HashMap<>();

        int total = 0;

        for (int i = 0; i <= w.length - n; i++) {
            String g = "";
            for (int j = 0; j < n; j++) {
                g += w[i + j] + " ";
            }

            total++;

            if (map.containsKey(g)) {
                for (String d : map.get(g)) {
                    count.put(d, count.getOrDefault(d, 0) + 1);
                }
            }
        }

        System.out.println("Extracted " + total + " n-grams");

        for (String d : count.keySet()) {
            int m = count.get(d);
            double sim = (m * 100.0) / total;
            System.out.println("Found " + m + " matching n-grams with " + d);
            System.out.println("Similarity: " + sim + "%");
        }
    }
}