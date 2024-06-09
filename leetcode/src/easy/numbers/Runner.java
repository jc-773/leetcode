package easy.numbers;

public class Runner {
    public static final NumberProblems problems = new NumberProblems();

    public static void main(String[] args) {
        int [] a = {2,5,6,3,8};
        int [] reverseOdds = problems.reversOdd(a);
        printArray(reverseOdds);
    }

    private static void printArray(int [] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
