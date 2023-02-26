public class Book {
    synchronized void increment(){

        int i = 100;

        while (i!=0) {

            for (int j = 0; j < 3; j++) {

                System.out.printf("%s %d \n", People.getName(), i);
                i--;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
