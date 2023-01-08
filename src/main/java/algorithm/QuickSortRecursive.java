package algorithm;

public class QuickSortRecursive {

    public static void recQuickSort(int[] arr, int left, int right) {
        if (right - left <= 0)
            return;
        else {
            int pivot = arr[right];

            int partition = partitionIt(arr, left, right, pivot);
            recQuickSort(arr, left, partition - 1);
            recQuickSort(arr, partition + 1, right);
        }
    }

    private static int partitionIt(int[] arr, int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (arr[++leftPtr] < pivot) ;
            while (rightPtr > 0 && arr[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(arr, leftPtr, rightPtr);
        }
        swap(arr, leftPtr, right);
        return leftPtr;
    }

    private static void swap(int[] arr, int dex1, int dex2) {
        int temp;
        temp = arr[dex1];
        arr[dex1] = arr[dex2];
        arr[dex2] = temp;
    }

    public static void display(int[] theArray) {
        System.out.print("Rec. Array = ");
        for (int i : theArray) System.out.print(i + " ");
        System.out.println();
    }
}
