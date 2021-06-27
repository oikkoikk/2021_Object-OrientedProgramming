package lab06;

public class Sort {
    public static void main(String[] args) {
        int[] arr = { 7, 4, 5, 1, 3 };

        printArr(arr);
        bubbleSort(arr, arr.length);
        printArr(arr);
    }

    public static void bubbleSort(int arr[], int n) {
        int maxPos = n + 1;

        while (maxPos-- > 0) {
            for (int i = 0; i < maxPos - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // swap
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
}
