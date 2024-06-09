package easy.strings;

public class Runner {
    public static final StringProblems problems = new StringProblems();

    public static void main(String[] args) {
        int [] array = {1,0,1};
        int [] b = problems.moveZeroes(array);
        printArray(b);
    }

    private static void printArray(int [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
