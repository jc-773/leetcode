package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class LeetCode75 {

    public static final int[] array = { 1,0,1,1,0,1,1,0,1 };
    public static final int[] nums1 = { 1, 2, 3, 3 };
    public static final int[] nums2 = { 1, 1, 2, 2 };
    public static final int[] maxAreaArray = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    public static final int[] maxAreaArrayOutlier = { 1, 2, 4, 3 }; // = 6
    public static final int[] maxAverageSubArray = { 5 };
    public static final int[][] array2 = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 }
    };
    public static final String reverseWords = "Let's take LeetCode contest";
    public static final String s = "abciiidef";

    public static void main(String[] args) {
        longestSubarray(array);
    }

    /* TWO POINTERS */

    // 1004. Max Consecutive Ones III
    // 1,1,1,0,0,0,1,1,1,1,0
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }
            if (k < 0) {
                k += 1 - nums[left];
                left++;
            }
        }

        return right - left;
    }

    // 1456. Maximum Number of Vowels in a Substring of Given Length
    /**
     * abciiidef
     */
    public static int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        int answer = count;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                count--;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    // 643. Maximum Average Subarray I
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxWindowSumAverage = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            maxWindowSumAverage = sum / k;
        }
        double windowSum = sum;
        for (int left = 0, right = k; right < nums.length; right++) {
            windowSum = windowSum + (nums[right] - nums[left]);
            maxWindowSumAverage = Math.max(maxWindowSumAverage, windowSum / k);
            left++;
        }
        return maxWindowSumAverage;
    }

    // 283. Move Zeroes
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[index++] = 0;
        }
    }

    // 392. Is Subsequence
    public boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;

        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }

        return left == s.length();
    }

    // 11. Container With Most Water -
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int windowSize = right - left;
            max = Math.max(max, Math.min(height[left], height[right]) * windowSize);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    // 75. Sort Colors - 0 ms runtime Beats 100%
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;

        for (int i : nums) {
            if (i == 0) {
                zero++;
            }
            if (i == 1) {
                one++;
            }
            if (i == 2) {
                two++;
            }
        }

        int indexCount = 0;
        for (int i = 0; i < zero; i++) {
            nums[indexCount] = 0;
            indexCount++;
        }
        for (int i = 0; i < one; i++) {
            nums[indexCount] = 1;
            indexCount++;
        }
        for (int i = 0; i < two; i++) {
            nums[indexCount] = 2;
            indexCount++;
        }
    }

    /**
     * 1679. Max Number of K-Sum Pairs - Eh runtime - Using HashMap 2 pass
     * 
     * 1. Start with a left pointer starting at the beginning of the array and
     * right pointer at the end of the array
     * 
     * 2. This array must be sorted for this algorithm to work
     * 
     * 3. If the sum of the two-numbers (a[left] + a[right]) < target, then we know
     * we need a larger number, so incremenet left
     * 
     * 4. If the sum of the two-numbers (a[left] + a[right]) > target, then we know
     * we need a smaller number, so decremenet right
     * 
     * 5. If the sum of the two-numbers (a[left] + a[right]) == target, then count++
     *
     */
    public static int maxOperationsPointers(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            } else {
                count++;
                left++;
                right--;
            }
        }
        return count;
    }

    // 1679. Max Number of K-Sum Pairs - Eh runtime - Using HashMap 2 pass
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> occurenceMap = new HashMap<>();
        for (int i : nums) {
            occurenceMap.put(i, occurenceMap.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for (int i : nums) {
            int current = i;
            int complement = k - current;

            if (occurenceMap.getOrDefault(current, 0) > 0 // a real time lookup to see if the value&complement hav been
                                                          // used up or not
                    && occurenceMap.getOrDefault(complement, 0) > 0) {
                if (current == complement) {
                    if (occurenceMap.get(current) >= 2) {
                        count++;
                        occurenceMap.put(current, occurenceMap.get(current) - 2);
                    }
                } else {
                    count++;
                    occurenceMap.put(current, occurenceMap.get(current) - 1);
                    occurenceMap.put(complement, occurenceMap.get(complement) - 1);
                }
            }
        }
        return count;
    }

    // 1470. Shuffle the Array
    public static int[] shuffle(int[] nums, int n) {
        int half = nums.length / 2;
        int[] firstHalf = new int[half];
        int[] secondHalf = new int[half];

        for (int i = 0; i < half; i++) {
            firstHalf[i] = nums[i];
        }

        for (int i = half; i < nums.length; i++) {
            secondHalf[i - half] = nums[i];
        }

        // should we use pointers here?
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = firstHalf[left++];
            } else {
                nums[i] = secondHalf[right++];
            }
        }

        return nums;
    }

    // 1119. Remove Vowels from a String
    public static String removeVowels(String s) {
        String replace = s.replaceAll("[aeiouAEIOU]", "");
        return replace;
    }

    // 557. Reverse Words in a String III
    public static String reverseWords(String s) {
        String[] words = s.split("\\s+");
        String newWord = "";
        for (String word : words) {
            newWord += reverseWord(word) + " ";
        }
        String clean = newWord.trim();
        return clean;
    }

    private static String reverseWord(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] c = s.toCharArray();
        String newString = "";
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }

        for (char character : c) {
            newString += character;
        }
        return newString;
    }

    // 1207. Unique Number of Occurrences
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> uniqueMap = new HashMap<>();

        for (int i : arr) {
            uniqueMap.put(i, uniqueMap.getOrDefault(i, 0) + 1);
        }

        Set<Integer> uniqueOccurences = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : uniqueMap.entrySet()) {
            uniqueOccurences.add(entry.getValue());
        }

        return uniqueOccurences.size() == uniqueMap.size();
    }

    // 2215. Find the Difference of Two Arrays
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        /*
         * nums1[1,2,3], nums2[2,4,6]
         * 
         * [1,3],[4,6]
         */
        List<Integer> nums1List = new ArrayList<>();
        List<Integer> nums2List = new ArrayList<>();

        Set<Integer> nums2Set = new HashSet<>();
        for (int i : nums2) {
            nums2Set.add(i);
        }

        Set<Integer> nums1Set = new HashSet<>();
        for (int i : nums1) {
            nums1Set.add(i);
        }

        for (int i : nums1Set) {
            if (!nums2Set.contains(i)) {
                // add to new List
                nums2List.add(i);
            }
        }

        for (int i : nums2Set) {
            if (!nums1Set.contains(i)) {
                // add to new List
                nums1List.add(i);
            }
        }

        List<List<Integer>> returnList = new ArrayList<>();
        returnList.add(nums2List);
        returnList.add(nums1List);
        return returnList;
    }

    // 1493. Longest Subarray of 1's After Deleting One Element
    public static int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int longestWindow = 0;
        int start = 0;

        for(int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 :0);

            while(zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
            longestWindow = Math.max(longestWindow, i - start);
        }

        return longestWindow;
    }

    // Some HackerRank question
    public static int minSum(List<Integer> num, int k) {

        int MIN_SUM = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(num);

        for (int i = 0; i < k; i++) {
            if (queue.size() > 0) {
                double max = queue.poll();
                double ceil = max / 2;
                int operation = (int) (Math.ceil(ceil));
                queue.add(operation);
            }
        }

        while (queue.size() > 0) {
            MIN_SUM += queue.poll();
        }

        return MIN_SUM;

    }

    private static double ceil(int max) {

        double max_ = (double) max;

        double maxD = max_ / 2.0;

        return Math.ceil(maxD);

    }

    // Utilities

    private static int countOfDuplicates(Map<Integer, Integer> map) {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                count++;
            }
        }
        return count;
    }
}
