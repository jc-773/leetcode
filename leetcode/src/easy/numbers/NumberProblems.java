package easy.numbers;

public class NumberProblems {

    public static int[] reversOdd(int[] a) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            while (left < right && a[left] % 2 == 0) {
                left++;
            }

            while (left < right && a[right] % 2 == 0) {
                right--;
            }

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;

                left++;
                right--;
            }
        }

        return a;
    }

    public static int numIdenticalPairs_(int[] nums) {
        int left = 0, right = 1;
        int count = 0;
        while (left < right && left < nums.length) {
            if (right <= nums.length-1) {
                if(nums[left] == nums[right]) {
                  count++;
                }
                right++;
            }
            else {
                left++;
                right = left + 1;
            }

        }
        return count;
    }

    public static int numIdenticalPairs(int[] nums) {
        int left = 0, right = 1;
        int count = 0;
        while (left < right && left < nums.length) {
            if (right <= nums.length-1) {
                if (nums[left] == nums[right]) {
                    count++;
                    left++;
                    right = left + 1;
                }
                else {
                    right++;
                }
            }
            else {
                left++;
                right = left + 1;
            }

        }
        return count;
    }
}
