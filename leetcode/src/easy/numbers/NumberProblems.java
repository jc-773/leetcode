package easy.numbers;

public class NumberProblems {
    

    public static int [] reversOdd(int [] a) {
        int left = 0;
        int right = a.length-1;

        while(left < right) {
            while(left < right && a[left] % 2 == 0){
                left++;
            }

            while(left < right && a[right] % 2 == 0){
                right--;
            }

            if(left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;

                left++;
                right--;
            }
        }

        return a;
    }
}
