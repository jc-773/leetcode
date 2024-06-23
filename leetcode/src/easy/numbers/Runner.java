package easy.numbers;

public class Runner {
    public static final NumberProblems problems = new NumberProblems();

    public static void main(String[] args) {
        int [] a = {1,2,3,1,1,3};
        int b = problems.numIdenticalPairs_(a);
        System.out.println("count: " + b);        
    }

    private static void printArray(int [] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
