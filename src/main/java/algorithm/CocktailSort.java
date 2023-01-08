package algorithm;

public class CocktailSort {
    public static void cocktailSortV1(int arr[]) {
        boolean swapped = true;
        int start = 0;
        int end = arr.length;

        while (true) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, arr[i], arr[i + 1]);
                    swapped = true;
                }
            }

            if (!swapped)
                break;

            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, arr[i], arr[i + 1]);
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }

    public static void cocktailSortV2(int[] arr) {
        int start = arr[0];
        int end = arr.length - 1;
        boolean swapped = false;

        while (start <= end) {
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, arr[i], arr[i + 1]);
                    swapped = true;
                }
            }
            end--;

            for (int i = end; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, arr[i], arr[i + 1]);
                    swapped = true;
                }
            }
            start++;

            if(!swapped)
                break;
        }
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void display(int[] theArray) {
        System.out.print("Coc. Array = ");
        for (int i : theArray) System.out.print(i + " ");
        System.out.println();
    }
}
