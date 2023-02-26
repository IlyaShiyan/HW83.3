import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore s = new Semaphore(7,true);
        Book book = new Book();

        for (int i = 1; i < 61; i++) {

            new Thread(new People(s, ""+i, book)).start();
            Thread.sleep(400);
        }

    }
}
