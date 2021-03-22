import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSortArrayApplication {

    public static void main(String[] args) {
        testMergeSort(0, 30, 30);
        testMergeSort(0, 20, 30);
        testMergeSort(20, 30, 30);
        testMergeSort(10, 20, 30);
    }

    public static void testMergeSort(int start, int end, int length) {
        if (start < 0) {
            start = 0;
        }
        if (end >= length) {
            end = length - 1;
        }

        System.out.println("\n\nUnsorted:");
        int[] array = IntStream.range(0, length).map(i -> (int) (Math.random() * length)).toArray();
        Arrays.stream(array).forEach(value -> System.out.print(value + " "));

        System.out.println("\nSorted: from " + start + " to " + end + " indexes of " + (length - 1));
        sort(array, start, end);
        Arrays.stream(array).forEach(value -> System.out.print(value + " "));
    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (int) Math.floor((start + end) / 2d);
            sort(array, start, middle);
            sort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    private static void merge(int[] array, int start, int middle, int end) {

        int[] leftArray = Arrays.copyOfRange(array, start, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, end + 1);
        int leftIndex = 0;
        int rightIndex = 0;

        if (leftArray.length > 0 && rightArray.length > 0) {
            for (int i = start; i < end; i++) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    leftIndex = migrate(array, i, leftArray, leftIndex, rightArray, rightIndex);
                    if (leftIndex == -1) {
                        break;
                    }
                } else {
                    rightIndex = migrate(array, i, rightArray, rightIndex, leftArray, leftIndex);
                    if (rightIndex == -1) {
                        break;
                    }
                }
            }
        }
    }

    private static int migrate(int[] array, int arrayIndex,
                               int[] lowHalf, int lowHalfIndex,
                               int[] highHalf, int highHalfIndex) {
        array[arrayIndex] = lowHalf[lowHalfIndex];
        lowHalfIndex++;
        if (lowHalfIndex == lowHalf.length) {
            for (int j = highHalfIndex; j < highHalf.length; j++) {
                arrayIndex++;
                array[arrayIndex] = highHalf[j];
            }
            return -1;
        }
        return lowHalfIndex;
    }
}