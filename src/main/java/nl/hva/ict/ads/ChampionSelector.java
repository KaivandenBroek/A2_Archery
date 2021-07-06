package nl.hva.ict.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of Archer's this class can be used to sort the list using one of
 * three sorting algorithms. Note that you are NOT allowed to change the
 * signature of these methods! Adding method is perfectly fine.
 */
public class ChampionSelector {
    /**
     * This method uses either selection sort or insertion sort for sorting the
     * archers.
     */
    public static List<Archer> selInsSort(List<Archer> archers, Comparator<Archer> scoringScheme) {

        // selection sort
        for (int i = 0; i < archers.size(); i++) {
            int currentMinIndex = i;
            for (int j = 0; j < archers.size() + 1; j++) {
                if (scoringScheme.compare(archers.get(j), archers.get(currentMinIndex)) < 0) {
                    if (archers.get(j).getTotalScore() < archers.get(currentMinIndex).getTotalScore()) { // klopt dit?
                        currentMinIndex = j;
                    }
                    // add:
                    // - biggest total score
                    // - most 10s
                    // - most 9s
                    // - lowest ID
                }
            }

            // swap
            Archer temp = archers.get(currentMinIndex);
            archers.set(currentMinIndex, archers.get(i));
            archers.set(i, temp);
        }

        // swap array at currentMinIndex with array at i

        return archers;
    }

    /**
     * This method uses quick sort for sorting the archers.
     */
    public static List<Archer> quickSort(List<Archer> archers, Comparator<Archer> scoringScheme) {

        archers = quickSortMethod(archers, 0, archers.size() -1); // comperator word nog niet gebruikt

        return archers;
    }

    public static List<Archer> quickSortMethod(List<Archer> archers, int low, int high) {
        if (low < high) {
            int pivot = low;
            int left = low + 1;
            int right = high;
            int pivotValue = archers.get(pivot).getTotalScore();

            while (left <= right) {
                // left <= high -> limit protection
                while (left <= high && pivotValue >= archers.get(left).getTotalScore()) {
                    left++;
                }
                // right > low -> limit protection
                while (right > low && pivotValue < archers.get(right).getTotalScore()) {
                    right--;
                }
                if (left < right) {
                    Collections.swap(archers, left, right);
                }
            }
            Collections.swap(archers, pivot, left - 1);
            quickSortMethod(archers, low, right - 1); // <-- pivot was wrong!
            quickSortMethod(archers, right + 1, high);   // <-- pivot was wrong!
        }
        return archers;
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {

        // pivot, for now it is the last index
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /**
     * This method uses the Java collections sort algorithm for sorting the archers.
     */
    public static List<Archer> collectionSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        Collections.sort(archers, scoringScheme);
        return archers;
    }
}
