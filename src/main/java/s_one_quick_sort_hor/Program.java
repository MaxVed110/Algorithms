package s_one_quick_sort_hor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Program {
    public static void main(String[] args) {

        int[] arr = ArrayUtils.prepareArray();


        // ArrayUtils.printArray(arr);
        // SortUtils.quickSort(arr, 0, arr.length-1);
        // ArrayUtils.printArray(arr);

        int[] test = ArrayUtils.prepareArray(1100);

        int[] testT = ArrayUtils.prepareArray(1100);
        // long startTime = System.currentTimeMillis();
        // SortUtils.directSort(test);
        // long endTime = System.currentTimeMillis();
        // long process = endTime - startTime;
        // System.out.println(process + " direct");

        // startTime = System.currentTimeMillis();
        // SortUtils.quickSort(test, 0, test.length-1);
        // endTime = System.currentTimeMillis();
        // process = endTime - startTime;
        // System.out.println(process + " quick");
        long startTime = System.currentTimeMillis();
        SortUtils.heapSort(test);
        long endTime = System.currentTimeMillis();
        long process = endTime - startTime;
        System.out.println(process + " heapSort");

        startTime = System.currentTimeMillis();
        SortUtils.heapSortTwo(testT);
        endTime = System.currentTimeMillis();
        process = endTime - startTime;
        System.out.println(process + " heapSortTwo");

    }


    static class ArrayUtils {
        private static final Random random = new Random();

        static int[] prepareArray() {
            int[] array = new int[random.nextInt(16) + 5];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(100);
            }
            return array;
        }

        static int[] prepareArray(int length) {
            int[] array = new int[length];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(100);
            }
            return array;
        }

        static void printArray(int[] array) {
            for (int elem : array) {
                System.out.printf("%d\t", elem);
            }
            System.out.println();
        }
    }

    static class SortUtils {
        static void directSort(int[] array) {
            for (int i = 0; i < array.length - 1; i++) {
                int minPos = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[minPos]) {
                        minPos = j;
                    }
                }
                if (minPos != i) {
                    int temp = array[i];
                    array[i] = array[minPos];
                    array[minPos] = temp;
                }
            }
        }

        static void quickSort(int[] array, int startPos, int endPos) {
            int left = startPos;
            int right = endPos;
            int middle = array[(left + right) / 2];

            do {
                while (array[left] < middle) {
                    left++;
                }

                while (array[right] > middle) {
                    right--;
                }
                if (left <= right) {
                    if (left < right) {
                        int temp = array[left];
                        array[left] = array[right];
                        array[right] = temp;
                    }
                    left++;
                    right--;
                }
            } while (left <= right);

            if (left < endPos) {
                quickSort(array, left, endPos);
            }
            if (right > startPos) {
                quickSort(array, startPos, right);
            }
        }

        /**
         * homework
         */
        static void heap(int[] array, int heapSize, int rootIndex) {
            int maxElement = rootIndex;
            int leftChild = 2 * rootIndex + 1;
            int rightChild = 2 * rootIndex + 2;

            if (leftChild < heapSize && array[leftChild] > array[maxElement]) {
                maxElement = leftChild;
            }

            if (rightChild < heapSize && array[rightChild] > array[maxElement]) {
                maxElement = rightChild;
            }

            if (maxElement != rootIndex) {
                int temp = array[rootIndex];
                array[rootIndex] = array[maxElement];
                array[maxElement] = temp;

                heap(array, heapSize, maxElement);
            }
        }

        static void heapSort(int[] array) {
            for (int i = array.length / 2 - 1; i >= 0; i--) {
                heap(array, array.length, i);
            }

            for (int i = array.length-1; i >=0; i--) {
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                heap(array, i, 0);
            }
        }

        static void heapVersTwo(int[] array, int heapSize, int rootIndex, int iteration){
            int maxElement = rootIndex;
            int leftChild = 2 * rootIndex + 1;
            int rightChild = 2 * rootIndex + 2;

            if (leftChild < heapSize && array[leftChild] > array[maxElement]) {
                maxElement = leftChild;
            }

            if (rightChild < heapSize && array[rightChild] > array[maxElement]) {
                maxElement = rightChild;
            }

            if (maxElement != rootIndex) {
                int temp = array[rootIndex];
                array[rootIndex] = array[maxElement];
                array[maxElement] = temp;

                heapVersTwo(array, heapSize, maxElement, iteration);
            }
            if (iteration > 0) {
                heapVersTwo(array, heapSize, iteration-1, iteration -1);
            }
        }

        static void heapSortTwo(int[] array){
            int heapSize = array.length;

            heapVersTwo(array, heapSize, heapSize, heapSize);

            for (int i = heapSize-1; i >=0 ; i--) {
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                heapVersTwo(array, i, 0, 0);
            }
        }
    }
}
