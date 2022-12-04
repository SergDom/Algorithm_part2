package IntegerList;

import java.util.Arrays;

public class SortTest {


    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(200_000) ;
        }
        return arr;
    }

    public static void sortBubble(int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void sortInsert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > element) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j]=element;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray();
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);

        long start = System.currentTimeMillis();
//        System.out.println(Arrays.toString(arr));
        sortBubble(arr1);
//        sortSelection(arr2);
//        sortInsert(arr3);
        System.out.println(System.currentTimeMillis() - start);

    }
}
