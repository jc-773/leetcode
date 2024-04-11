package easy.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingArrayOfIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] mergedIntervals = merge(intervals);
        
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }

    }

    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 2: Initialize a list to store merged intervals
        List<int[]> mergedIntervals = new ArrayList<>();
        
        // Step 3: Iterate and merge intervals
        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size() - 1)[1] < interval[0]) {
                mergedIntervals.add(interval);
            } else {
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], interval[1]);
            }
        }
        
        // Step 4: Convert the list to an array
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
