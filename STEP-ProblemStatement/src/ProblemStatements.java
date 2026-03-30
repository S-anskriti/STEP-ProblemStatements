class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }
}

public class ProblemStatements {
    static void mergeSort(Asset[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(Asset[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Asset[] L = new Asset[n1];
        Asset[] R = new Asset[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].returnRate <= R[j].returnRate) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(Asset[] arr, int low, int high) {
        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].returnRate > pivot.returnRate ||
                    (arr[j].returnRate == pivot.returnRate && arr[j].volatility < pivot.volatility)) {
                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static Asset[] copy(Asset[] arr) {
        Asset[] temp = new Asset[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = new Asset(arr[i].name, arr[i].returnRate, arr[i].volatility);
        }
        return temp;
    }

    public static void main(String[] args) {
        Asset[] assets = {
                new Asset("AAPL", 12.0, 5.0),
                new Asset("TSLA", 8.0, 9.0),
                new Asset("GOOG", 15.0, 4.0),
                new Asset("META", 12.0, 3.0)
        };

        Asset[] mergeArray = copy(assets);
        Asset[] quickArray = copy(assets);

        mergeSort(mergeArray, 0, mergeArray.length - 1);
        System.out.println("Merge Sort Ascending by Return:");
        for (Asset a : mergeArray) {
            System.out.println(a.name + " : " + a.returnRate + "%");
        }

        System.out.println();

        quickSort(quickArray, 0, quickArray.length - 1);
        System.out.println("Quick Sort Descending by Return and Ascending by Volatility:");
        for (Asset a : quickArray) {
            System.out.println(a.name + " : " + a.returnRate + "% : " + a.volatility);
        }
    }
}