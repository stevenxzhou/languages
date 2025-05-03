package basics;

public class Synchronized {
    public static int counter = 0;

    public static synchronized void increaseCounter() {
        counter += 1;
    }

    public static synchronized void decreaseCounter() {
        counter -= 1;
    }

    public static void printCounter() {
        System.out.println(counter);
    }

    public static void main(String[] args) {
        // Create threads to simulate race condition
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
                increaseCounter();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
                decreaseCounter();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Start threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish: it is used to focus current thread. Needs to pair with synchronized to prevent racing condition. 
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final counter value
        printCounter();
    }
}
