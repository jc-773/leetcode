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

    public static final int[] array = {4,3,2,7,8,2,3,1};
    public static final int[] nums1 = { 1, 1, 0, 1, 0, 0, 1, 0, 1 };
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
    public static final String[] words = { "neet","code","love","you"};
    public static final List<String> listOfStrings = new ArrayList<>();

    public static void main(String[] args) {
        findDisappearedNumbers(array);
    }

    /* BRUTE FORCE APPROACHES */

    //121. Best Time to Buy and Sell Stock
    public static int maxProfitBrute(int[] prices) {
        //each index in the array represents a day so you cant give multiple conditions for the same day
         int max = 0;
       for(int i = 0; i < prices.length; i++) {
         for(int j = i + 1; j < prices.length; j++) {
             if(prices[j] > prices[i]) {
                 int profit = prices[j] + prices[i];
                 max = Math.max(max, profit);
             }
         }
       }
       return max;
    }

    /* HASH MAPS */

    public static String frequencySort(String s) {
        return null;
    }

    //448. Find All Numbers Disappeared in an Array
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
       for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
       }

       for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(i + 1)) {
                list.add(i);
            }
       }
       return list;
    }

    // 1207. Unique Number of Occurrences
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            set.add(entry.getValue());
        }
        return set.size() == map.size();
    }

    //169. Majority Element
    public static int majorityElement(int[] nums) {
       int mostOccurences = 0;
       Map<Integer, Integer> map = new HashMap<>();
       for(int i : nums) {
        map.put(i, map.getOrDefault(i, 0) + 1);
       }

       int max = 0;
       for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                mostOccurences = entry.getKey();
            }
       }
       return mostOccurences;
    }

    /* ARRAYS */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                boolean left = (i == 0 || flowerbed[i-1] == 0);
                boolean right = (i == flowerbed.length-1 || flowerbed[i+1] == 0);

                if(left && right) {
                    count++;
                }
            }
        }
        return count > n;
    }

    // 1493. Longest Subarray of 1's After Deleting One Element
    public static int longestSubarray(int[] nums) {
        int windowSize = 0;
        int start = 0;
        int zeroCount = 0;

        for(int i = 0; i < nums.length; i++) {
            zeroCount += nums[i] == 0 ? 1 : 0;

            while(zeroCount > 1) {
                zeroCount -= nums[start] == 0 ? 1 : 0;
                start++;
            }

            windowSize = Math.max(windowSize, i - start);
        }
        return windowSize;
      }

    // 1470. Shuffle the Arrays
    public static int[] shuffle(int[] nums, int n) {
      int half = nums.length / 2;
      int [] xArray = new int [half];
      int [] yArray = new int [half];

      for(int i = 0; i < xArray.length; i++) {
        xArray[i] = nums[i];
      }
      int index = 0;
      for(int i = half; i < nums.length; i++) {
        yArray[index++] = nums[i];
      }
    
      int xIndex = 0;
      int yIndex = 0;
      for(int i = 0; i < nums.length; i++) {
        if(i % 2 == 0 || i == 0) {
            nums[i] = xArray[xIndex++];
        }else {
            nums[i] = yArray[yIndex++];
        }
      }
      return nums;
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

    //1. Two Sum - Easy
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int diff = target - num;

            if(map.containsKey(diff) && map.get(diff) != i) {
               int index = map.get(diff);
               return new int [] {index, i};
            }
        }
        return new int [] {};
    }

    //167. Two Sum II - Input Array Is Sorted - Medium
    public static int[] twoSumSorted(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;

       while(left < right) {
        int currentSum = nums[left] + nums[right];

        if(currentSum < target) {
            left++;
        }else if(currentSum > target) {
            right--;
        }else {
            return new int [] {left + 1, right + 1};
        }
       }
       return new int [] {};
    }

    /* STRINGS */

    public static String reverseWords151(String s) {
        List<String> list = new ArrayList<>();
        String [] sArray = s.split(" ");
        for(int i = 0; i < sArray.length; i++) {
            if(!sArray[i].isEmpty()) {
                list.add(sArray[i]);
            }
        }

        String reversed = "";
        Collections.reverse(list);
        for(int i = 0; i < list.size(); i++) {
            reversed += list.get(i) + " ";
        }
        return reversed.trim();
    }

     //1119. Remove Vowels from a String
     public static String removeVowels(String s) {
        String regex = "[aeiouAEIOU]";
        return s.replaceAll(regex, "");
     }

    //557. Reverse Words in a String III
    public static String reverseWords(String s) {
        return null;
    }

     // 1456. Maximum Number of Vowels in a Substring of Given Length
    public static int maxVowels(String s, int k) {
       String vowels = "aeiouAEIOU";
       Set<Character> set = new HashSet<>();
       for(char c : vowels.toCharArray()) {
        set.add(c);
       }

       int max = 0;
       for(int i = 0; i < k; i++) {
        if(set.contains(s.charAt(i))) {
            max++;
        }
       }

       int windowSum = max;
       for(int i = k; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                windowSum++;
            }
            if(set.contains(s.charAt(i-k))) {
                windowSum--;
            }
            max = Math.max(max, windowSum);
       }
       return max;
    }

    // 392. Is Subsequence
    public static boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;

        while(left < s.length() && right < t.length()) {
            if(s.charAt(left) == t.charAt(right)) {
                left++;
            }
                right++;
            
        }
        return left == s.length();
    }

    public static String reverseVowels(String s) {
        String regex = "aeiouAEIOU";
        Set<Character> set = new HashSet<>();
        char [] c = regex.toCharArray();
        for(char character : c) {
            set.add(character);
        }

        int left = 0;
        int right = s.length()-1;
        char [] sArray = s.toCharArray();
        while(left < right) {
            if(set.contains(sArray[left]) && set.contains(sArray[right])) {
                char temp = sArray[left];
                sArray[left] = sArray[right];
                sArray[right] = temp;
                left++;
                right--;
            }
            else if(!set.contains(sArray[left])) {
                left++;
            }
            else if(!set.contains(sArray[right])) {
               right--;
            }
        }
        String returnString = new String(sArray);
        
        return returnString;
    }

    public static boolean checkInclusion(String s1, String s2) {
       List<String> list = new ArrayList<>();

       for(int left = 0, right = s1.length(); right < s2.length(); right++) {
            String substring = s2.substring(left, right);
            list.add(substring);
            left++;
       }

       int index = 0;
       for(String s : list) {
        char [] c = s.toCharArray();
        char [] h = s1.toCharArray();
        Arrays.sort(c);
        Arrays.sort(h);

        if(c[index++] == h[index++]) {

        }
        
       }
       return true;
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

    public static boolean isPalindromeSpecialChars(String s) {
        String regex = "[^a-zA-Z0-9\\s]";
        String replaced = s.replaceAll(regex, "").replaceAll(" ", "").toLowerCase();
        String noSpace = replaced.replaceAll(" ", "");
        int left = 0;
        int right = noSpace.length()-1;
 
        while(left < right) {
         if(noSpace.charAt(left) != noSpace.charAt(right)) {
             return false;
         }
         left++;
         right--;
        }
        return true;
     }

     /*
      * Constraints: 
        s.length = t.length
        sort
        compare
      */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char [] sArray = s.toCharArray();
        char [] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for(int i = 0; i < sArray.length; i++) {
            if(sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static int countHi(String str) {
        String hi = "hi";
        int length = hi.length();
        int stringLength = str.length();

        int count = 0;
        for (int left = 0, right = length; right <= str.length(); right++) {
            char leftC = str.charAt(left);
            char rightC = str.charAt(right);
            String sub = str.substring(left, right);
            if (str.substring(left, right).equals(hi)) {
                count++;
            }
            left++;
        }
        return count;
    }

    /* TWO POINTERS */

    //121. Best Time to Buy and Sell Stock
    public static int maxProfit(int [] prices) {
        int left = 0;
        int right = 1;

        int max = 0;
        while(right < prices.length) {
            if(prices[left] > prices[right]) {
                max = Math.max(max, prices[right] - prices[left]);
            }else {
                left = right;
            }
            right++;
        }
        return max;
    }

    //1512. Number of Good Pairs
    //this accumulates the count of i found in the value of the map
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
         int count = 0;
 
         for(int i : nums) {
             count += map.getOrDefault(i, 0);
             map.put(i, map.getOrDefault(i, 0) + 1);
         }
         return count;
     }

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
                k += 1 - nums[left]; // this one minus left will return 1 if nums[left] = 0
                left++;
            }
        }

        return right - left;
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

    // 11. Container With Most Water -
    public static int maxArea(int[] height) {
      int left = 0; 
      int right = height.length-1;
      int max = 0;

      while(left < right) {
        int windowLength = right - left;
        max = Math.max(max, Math.min(height[left],height[right]) * windowLength);

        if(height[left] <= height[right]) {
            left++;
        }else {
            right--;
        }
      }
        return max;
    }

    /**
     * 1679. Max Number of K-Sum Pairs - Using 2 pointers
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
        int right = nums.length-1;

        int count = 0;
        while(left < right) {
            if(nums[left] < k) {
                left++;
            }
            else if(nums[left] > k) {
                right--;
            }else{
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

    private static String reverseWordInPlace(String s) {
        
        int left = 0;
        int right = s.length() - 1;
        char [] c = s.toCharArray();
        
        while(left < right) {
            char temp = c[right];
            c[right] = c[left];
            c[left] = temp;
            left++;
            right--;
        }
        return String.copyValueOf(c);
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

    // HackerRank - MinSum 10 - Medium
    public static int minSum(List<Integer> num, int k) {

        int MIN_SUM = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
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

    // Utilities

    private static double ceil(int max) {

        double max_ = (double) max;

        double maxD = max_ / 2.0;

        return Math.ceil(maxD);

    }

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
