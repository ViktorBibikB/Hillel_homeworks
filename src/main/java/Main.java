import algorithm.CocktailSort;
import algorithm.QuickSortBase;
import algorithm.QuickSortWithMedian;
import algorithm.QuickSortImproved;


public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{149, 192, 47, 152, 159, 195, 61, 66, 17, 167, 118, 64, 27, 80, 30, 105};
        Main.display(arr);

        QuickSortWithMedian.recQuickSort(arr, 0, arr.length - 1);
        QuickSortWithMedian.display(arr);

        QuickSortImproved.recQuickSort(arr, 0, arr.length - 1);
        QuickSortImproved.display(arr);

        QuickSortBase.recQuickSort(arr, 0, arr.length - 1);
        QuickSortBase.display(arr);

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
