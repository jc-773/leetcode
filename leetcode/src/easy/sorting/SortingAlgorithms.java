package easy.sorting;

public class SortingAlgorithms {
    
    public static void main(String[] args) {
        int [] a = {5, 2, 4, 1, 9, 3};

        printArray(quickSort(a, 0, a.length-1));
    }

     /**
     * 
     * Partition the array  *the most important part of the quicksort algorithm* to find the pivot
     * recursive call from beginning - pivot
     * recursive call from pivot - end 
     * 
     * 
     * @param a
     * @return
     */
    public static int [] quickSort(int [] a, int lowIndex, int highIndex) {
        if(lowIndex < highIndex) {
            int pivot = partition(a, lowIndex, highIndex);
            quickSort(a, lowIndex, pivot - 1);
            quickSort(a, pivot + 1, highIndex);
        }
        return a;
    }


    private static int partition(int [] a, int lowIndex, int highIndex) {
        int lp = lowIndex;
        int rp = highIndex;

        //loops until left-pointer is no longer before right-pointer
        while(lp < rp) {
            //loop will stop once value of lp is greater than value of highIndex
            while(a[lp] <= a[highIndex] && lp < rp) {
                lp++;
            }
            //loop will stop once value of rp is less than value of highIndex
            while(a[rp] >= a[highIndex] && lp < rp) {
                rp--;
            }

            //once the lp and rp stop we know they need to be swapped
            int temp = a[lp];
            a[lp] = a[rp];
            a[rp] = temp;
        }
        //swap the high index with lp - assures the correct spot for "highIndex"
        int temp = a[lp];
        a[lp] = a[highIndex];
        a[highIndex] = temp;

        return lp;
    }


    /**
     *  i  j 
     *  5, 2, 4, 1, 9, 3
     * 
     * @param a
     * @return
     */
    public static int [] selectionSort(int [] a) {
        for(int i = 0; i < a.length; i++) {
            int min = a[i];
            for(int j = i + 1; j < a.length; j++) {
                if(a[j] < min) {
                    min = a[j];
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        return a;
    }

     /**
     *     i        j             
     *  1, 2, 5, 4, 9, 3
     * 
     * @param a
     * @return
     */
    public static int [] bubbleSort(int [] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(a[j] < a[i]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        return a;
    }

   
    public static void printArray(int [] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
