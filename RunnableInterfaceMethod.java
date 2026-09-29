public class RunnableInterfaceMethod {
    public static void main(String[] args) {
        Thread t1 = new Thread(createTask("Good Morning", 1000));
        Thread t2 = new Thread(createTask("Hello", 2000));
        Thread t3 = new Thread(createTask("Welcome", 3000));

        t1.start();
        t2.start();
        t3.start();
    }

    private static Runnable createTask(String message, long delayMillis) {
        return () -> {
            try {
                while (true) {
                    System.out.println(message);
                    Thread.sleep(delayMillis);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        };
    }
}
