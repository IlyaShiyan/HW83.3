import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class People implements Runnable{
    Semaphore s;
    String name;
    Book book;
    CountDownLatch cdl;

    public People(Semaphore s, String n, Book book,CountDownLatch c) {
        this.s = s;
        this.name = n;
        this.book = book;
        this.cdl = c;
    }

    @Override
    public void run() {
        System.out.println("Человек "+ name + " пришёл");
        try {
            System.out.println("Человек " + name + " ожидает место");
            s.acquire();
            for (int i = 0; i < 3; i++) {
            book.take();
            cdl.countDown();
            }
            System.out.println("Человек " + name + " читает");
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Человек " + name + " уходит");
        s.release();
        for (int i = 0; i < 3; i++) {
            book.put();
        }
    }
}