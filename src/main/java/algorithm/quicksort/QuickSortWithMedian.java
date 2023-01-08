package algorithm.quicksort;

import java.util.Arrays;

public class QuickSortWithMedian {

    public static void recQuickSort(int[] arr, int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(arr, left, right);
        else {
            long median = medianOf3(arr, left, right);
            int partition = partitionIt(arr, left, right, median);
            recQuickSort(arr, left, partition - 1);
            recQuickSort(arr, partition + 1, right);
        }
    }

    private static int partitionIt(int[] arr, int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true) {
            while (arr[++leftPtr] < pivot) ;
            while (arr[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(arr, leftPtr, rightPtr);
        }
        swap(arr, leftPtr, right - 1);
        return leftPtr;
    }

    private static long medianOf3(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[left] > arr[center])
            swap(arr, left, center);
        if (arr[left] > arr[right])
            swap(arr, left, right);
        if (arr[center] > arr[right])
            swap(arr, center, right);
        swap(arr, center, right - 1);
        return arr[right - 1];
    }

    private static void swap(int[] arr, int dex1, int dex2) {
        int temp = arr[dex1];
        arr[dex1] = arr[dex2];
        arr[dex2] = temp;
    }

    private static void manualSort(int[] arr, int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (arr[left] > arr[right])
                swap(arr, left, right);
            return;
        } else {
            if (arr[left] > arr[right - 1])
                swap(arr, left, right - 1);
            if (arr[left] > arr[right])
                swap(arr, left, right);
            if (arr[right - 1] > arr[right])
                swap(arr, right - 1, right);
        }
    }

    public static void display(int[] theArray)
    {
        System.out.print("Med. Array = ");
        for (int i : theArray) System.out.print(i + " ");
        System.out.println();
    }
}
