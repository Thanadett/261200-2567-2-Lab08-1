import java.util.Random;

class Printer implements Runnable {
    private final int id;
    private static final int MAX_NUMBER = 50;
    private static final Random random = new Random();

    public Printer(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            System.out.println("thread #" + id + ": " + i);
            try {
                Thread.sleep(random.nextInt(91) + 10);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Printer(1));
        Thread t2 = new Thread(new Printer(2));
        Thread t3 = new Thread(new Printer(3));

        t1.start();
        t2.start();
        t3.start();
    }
}

 /* 1. ก่อนที่จะเพิ่ม Thread.sleep():
        - Thread ที่ทำงานก่อนจะจบก่อน ตัวเลขจะห่างกันมาก
    2. หลังใช้ Thread.sleep():
        - ตัวเลขจะถูกพิมพ์สลับกัน หรือก็คือ แต่ละ Thread จะจบพร้อมๆ หรือใกล้ ๆ กันมากขึ้น
    3. Explain
        - Multithreading ใน Java คือการให้หลายเธรดทำงานพร้อมกันในโปรแกรมเดียวกัน
        - แต่ละเธรดจะทำงานในช่วงเวลาสั้นๆ ตามลำดับที่ CPU มอบหมายให้
        - ลำดับแต่ละรอบไม่เหมือนกัน
 */
