import java.util.Arrays;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }
}

public class ProblemStatements {
    static void bubbleSort(Client[] clients) {
        int swaps = 0;

        for (int i = 0; i < clients.length - 1; i++) {
            for (int j = 0; j < clients.length - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swaps++;
                }
            }
        }

        System.out.println("Bubble Sort Ascending:");
        for (Client c : clients) {
            System.out.println(c.name + " : " + c.riskScore);
        }
        System.out.println("Swaps: " + swaps);
    }

    static void insertionSort(Client[] clients) {
        for (int i = 1; i < clients.length; i++) {
            Client key = clients[i];
            int j = i - 1;

            while (j >= 0 && (clients[j].riskScore < key.riskScore ||
                    (clients[j].riskScore == key.riskScore &&
                            clients[j].accountBalance > key.accountBalance))) {
                clients[j + 1] = clients[j];
                j--;
            }

            clients[j + 1] = key;
        }

        System.out.println("Insertion Sort Descending:");
        for (Client c : clients) {
            System.out.println(c.name + " : " + c.riskScore + " : " + c.accountBalance);
        }
    }

    static void topRisks(Client[] clients) {
        System.out.println("Top Highest Risk Clients:");
        int limit = Math.min(10, clients.length);
        for (int i = 0; i < limit; i++) {
            System.out.println(clients[i].name + "(" + clients[i].riskScore + ")");
        }
    }

    static Client[] copy(Client[] arr) {
        Client[] temp = new Client[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = new Client(arr[i].name, arr[i].riskScore, arr[i].accountBalance);
        }
        return temp;
    }

    public static void main(String[] args) {
        Client[] clients = {
                new Client("clientC", 80, 20000),
                new Client("clientA", 20, 50000),
                new Client("clientB", 50, 30000),
                new Client("clientD", 80, 15000)
        };

        Client[] bubbleArray = copy(clients);
        Client[] insertionArray = copy(clients);

        bubbleSort(bubbleArray);
        System.out.println();

        insertionSort(insertionArray);
        System.out.println();

        topRisks(insertionArray);
    }
}