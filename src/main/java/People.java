import java.util.concurrent.Semaphore;

public class People implements Runnable{

    Semaphore s;
    Book book ;
    private static String name;

    public People(Semaphore s, String name,Book book) {
        this.s = s;
        this.name = name;
        this.book = book;
    }

    public static String getName() {
        return name;
    }

    @Override
    synchronized public void run() {
        System.out.println("Человек "+ name + " пришёл в зал");
        try {
            System.out.println("Человек " + name + " берёт книги");
            s.acquire();
            book.increment();
            System.out.println("Человек " + name + " читает");
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Человек " + name + " уходит");
        s.release();

    }
}
