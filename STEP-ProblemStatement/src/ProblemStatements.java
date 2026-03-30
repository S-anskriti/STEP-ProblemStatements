import java.util.Arrays;

public class ProblemStatements {
    static int linearFirst(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Occurrence Index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Not found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    static int linearLast(String[] arr, String target) {
        int comparisons = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear Last Occurrence Index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Not found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Search Found at Index: " + mid);
                System.out.println("Comparisons: " + comparisons);
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] logs = {"accB", "accA", "accB", "accC", "accB"};

        System.out.println("Original Array:");
        for (String s : logs) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        System.out.println();

        Arrays.sort(logs);
        System.out.println("Sorted Array:");
        for (String s : logs) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        binarySearch(logs, "accB");
        System.out.println("Count of accB: " + countOccurrences(logs, "accB"));
        System.out.println("Time Complexity: Linear O(n), Binary O(log n)");
    }
}