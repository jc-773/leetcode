package easy.strings;

public class Runner {
    public static final StringProblems problems = new StringProblems();

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecars"));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        System.out.println("String: " + s );
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static String reverseStringBuilder(String s) {
        StringBuilder builder = new StringBuilder(s);
        builder.reverse();
        return builder.toString();
    }
        

    public static String reverseString(String s) {
        String s2 = "";
        for (int i = s.length()-1; i >= 0 ; i--) {
            s2 += s.charAt(i);
        }
        return s2;
    }

    private static void printArray(int [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
