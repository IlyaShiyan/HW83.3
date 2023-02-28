public class Book {

    int i = 100;

    synchronized void take(){

                System.out.printf("%s %s \n","Берёт книгу ", i);
                i-=1;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
    }
    synchronized void put(){

                System.out.printf("%s %s \n","Сдаёт книгу ", i);
                i+=1;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
    }

}
