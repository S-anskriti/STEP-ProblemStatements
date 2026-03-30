import java.util.ArrayList;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

public class ProblemStatements {
    static void bubbleSortByFee(ArrayList<Transaction> transactions) {
        int n = transactions.size();
        int passes = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < n - i - 1; j++) {
                if (transactions.get(j).fee > transactions.get(j + 1).fee) {
                    Transaction temp = transactions.get(j);
                    transactions.set(j, transactions.get(j + 1));
                    transactions.set(j + 1, temp);
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        System.out.println("Bubble Sort (fees ascending):");
        for (Transaction t : transactions) {
            System.out.println(t.id + ":" + t.fee);
        }
        System.out.println("Passes: " + passes);
        System.out.println("Swaps: " + swaps);
    }

    static void insertionSortByFeeAndTimestamp(ArrayList<Transaction> transactions) {
        for (int i = 1; i < transactions.size(); i++) {
            Transaction key = transactions.get(i);
            int j = i - 1;

            while (j >= 0 && (
                    transactions.get(j).fee > key.fee ||
                            (transactions.get(j).fee == key.fee &&
                                    transactions.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                transactions.set(j + 1, transactions.get(j));
                j--;
            }

            transactions.set(j + 1, key);
        }

        System.out.println("Insertion Sort (fee + timestamp ascending):");
        for (Transaction t : transactions) {
            System.out.println(t.id + ":" + t.fee + "@" + t.timestamp);
        }
    }

    static void findHighFeeOutliers(ArrayList<Transaction> transactions) {
        boolean found = false;
        System.out.println("High-fee outliers:");
        for (Transaction t : transactions) {
            if (t.fee > 50) {
                System.out.println(t.id + ":" + t.fee);
                found = true;
            }
        }
        if (!found) {
            System.out.println("none");
        }
    }

    static ArrayList<Transaction> copyList(ArrayList<Transaction> original) {
        ArrayList<Transaction> copy = new ArrayList<>();
        for (Transaction t : original) {
            copy.add(new Transaction(t.id, t.fee, t.timestamp));
        }
        return copy;
    }

    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));
        transactions.add(new Transaction("id4", 60.0, "11:00"));
        transactions.add(new Transaction("id5", 25.0, "09:00"));

        ArrayList<Transaction> bubbleList = copyList(transactions);
        ArrayList<Transaction> insertionList = copyList(transactions);

        bubbleSortByFee(bubbleList);
        System.out.println();

        insertionSortByFeeAndTimestamp(insertionList);
        System.out.println();

        findHighFeeOutliers(transactions);
    }
}