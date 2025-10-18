package org;
import java.util.Arrays;

public class ArrayExaple {
    public static void main(String[] args) {
        int[] array = {1, 5, 6, 4, 3, 6, 9, 8, 4, 6, 8};

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + 3;
        }
        System.out.println(Arrays.toString(array));
    }
}
