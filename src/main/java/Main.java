import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore s = new Semaphore(7,true);
        Book book = new Book();
        CountDownLatch cdl = new CountDownLatch(3);

        for (int i = 1; i < 61; i++) {

            new Thread(new People(s, ""+i, book, cdl)).start();
            Thread.sleep(400);
            cdl.await();
        }

    }
}
