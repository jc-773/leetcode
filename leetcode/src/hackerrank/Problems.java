package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Problems {
        public static void main(String[] args) {
           List<Integer> list = generateRandomNumbers(100, 1,100);
           countingSort(list);
        }
    

    public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        int max = 0;
        for(int a : arr) {
            max = Math.max(max, a);
        }
        int [] a = new int[max];
        for(int i = 0; i < a.length-1; i++) {
            a[arr.get(i)]++;
        }
        
        for(int n : a) {
            result.add(n);
        }
        
        return result;
    }

    private static List<Integer> generateRandomNumbers(int count, int min, int max) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

}
