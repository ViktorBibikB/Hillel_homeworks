package math.mathactions;

import java.util.Arrays;

public class ArrayActions {
    public int[] getAllValesAfterLast4(int[] arr){
        if(arr.length <= 0)
            throw new IndexOutOfBoundsException("Array length should not be 0.");

        int indexOf4 = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 4)
                indexOf4 = i;
        }

        if (indexOf4 == -1)
            throw new RuntimeException("Number 4 does not presence in current array.");

        return Arrays.copyOfRange(arr, indexOf4 + 1, arr.length);
    }

    public boolean isArrayConsistsOf4And1(int[] arr){
        boolean isFour = false;
        boolean isOne = false;
        boolean other = false;

        for (int number: arr) {
            if(number == 4)
                isFour = true;
            else if (number == 1)
                isOne = true;
            else
                other = true;
        }

        return isFour && isOne && !other;
    }
}
