package threads;

public class ThreadRunner {

   


    public static void main(String[] args) {
            Multithreading thread = new Multithreading();
            Multithreading thread2 = new Multithreading();
            thread.start();
            thread2.start();

    }
}
