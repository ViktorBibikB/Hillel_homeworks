import algorithm.CocktailSort;
import algorithm.QuickSort;
import algorithm.QuickSortWithMedian;
import algorithm.QuickSortRecursive;


public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{149, 192, 47, 152, 159, 195, 61, 66, 17, 167, 118, 64, 27, 80, 30, 105};
        Main.display(arr);

        QuickSortWithMedian.recQuickSort(arr, 0, arr.length - 1);
        QuickSortWithMedian.display(arr);

        QuickSortRecursive.recQuickSort(arr, 0, arr.length - 1);
        QuickSortRecursive.display(arr);

        QuickSort.recQuickSort(arr, 0, arr.length - 1);
        QuickSort.display(arr);

        CocktailSort.cocktailSortV1(arr);
        CocktailSort.display(arr);

        CocktailSort.cocktailSortV2(arr);
        CocktailSort.display(arr);
    }

    public static void display(int[] arr) {
        System.out.print("Base Array = ");
        for (int integer : arr) System.out.print(integer + " ");
        System.out.println();
    }
}
