public class ProblemStatements {
    static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Search Found at Index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Linear Search: not found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    static int insertionPoint(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static Integer floorValue(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer floor = null;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    static Integer ceilingValue(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer ceiling = null;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                ceiling = arr[mid];
                high = mid - 1;
            }
        }
        return ceiling;
    }

    public static void main(String[] args) {
        int[] unsortedRisks = {50, 10, 100, 25};
        int[] sortedRisks = {10, 25, 50, 100};
        int target = 30;

        System.out.println("Linear Search in Unsorted Array:");
        linearSearch(unsortedRisks, target);

        System.out.println();

        int position = insertionPoint(sortedRisks, target);
        System.out.println("Insertion Point for " + target + ": " + position);

        Integer floor = floorValue(sortedRisks, target);
        Integer ceiling = ceilingValue(sortedRisks, target);

        System.out.println("Floor Value: " + floor);
        System.out.println("Ceiling Value: " + ceiling);
    }
}