package easy.numbers;

public class MaximumAverageSubarray {


    /**
     * Instantiate int variable to 0 to store the maximum sum 
     * Loop through the first k elements and store the acumulated sum in sum variable
     *      - this is the highest possible sum before further evalutation
     * Instantiate another int variable to store the value of sum in the given "window"
     *      - set this value to sum, because our sum wont be any lower than this
     * Loop from k to the length of the passed in int array
     * 
     * 
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int windowSum = sum;
        for(int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i-k];
            sum = Math.max(sum, windowSum);
        }
        return calculateAverage(sum, k);
    }
    public double calculateAverage(int a, int k) {
        double maxAsDouble = (double) a;
        return maxAsDouble / k;
    }
}
