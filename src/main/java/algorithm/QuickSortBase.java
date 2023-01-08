package algorithm;

public class QuickSortBase {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partitionIt(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = (left - 1);

        for (int j = left; j <= right - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return (i + 1);
    }

    public static void recQuickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pi = partitionIt(arr, left, right);

            recQuickSort(arr, left, pi - 1);
            recQuickSort(arr, pi + 1, right);
        }
    }

    public static void display(int[] theArray) {
        System.out.print("Rec. Array = ");
        for (int i : theArray) System.out.print(i + " ");
        System.out.println();
    }
}
