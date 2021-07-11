import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class stock extends Thread{
    /*
    * Type 1 = jk
    * Type 2 = jk_cm
    * Type 3 = zeone
    * Type 4 = zeonh
    * */
    public int jk = 10;
    public int jk_cm = 10;
    public int zeonh = 10;
    public int zeone = 10;
    public List<Double> prices_jk = new ArrayList<Double>();
    public List<Double> prices_jk_cm = new ArrayList<Double>();
    public List<Double> prices_zeonh = new ArrayList<Double>();
    public List<Double> prices_zeone = new ArrayList<Double>();
    public String time;
    public ZonedDateTime zonedDateTime;
    public void run(){
        while (true) {
            Random ran = new Random();
            if (ran.nextInt(2) == 1) {
                int rand = ran.nextInt(101);
                jk += rand;
            } else {
                int rand = ran.nextInt(101);
                jk -= rand;
                if (jk <= 0) {
                    jk = 0;
                }
            }
            prices_jk.add((double) jk);
            if (ran.nextInt(2) == 1) {
                int rand = ran.nextInt(101);
                zeone += rand;
            } else {
                int rand = ran.nextInt(101);
                zeone -= rand;
                if (zeone <= 0) {
                    zeone = 0;
                }
            }
            prices_zeone.add((double) zeone);
            if (ran.nextInt(2) == 1) {
                int rand = ran.nextInt(101);
                zeonh += rand;
            } else {
                int rand = ran.nextInt(101);
                zeonh -= rand;
                if (zeonh <= 0) {
                    zeonh = 0;
                }
            }
            prices_zeonh.add((double) zeonh);
            if (ran.nextInt(2) == 1) {
                int rand = ran.nextInt(101);
                jk_cm += rand;
            } else {
                int rand = ran.nextInt(101);
                jk_cm -= rand;
                if (jk_cm <= 0) {
                    jk_cm = 0;
                }
            }
            prices_jk_cm.add((double) jk_cm);
            zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy년MM월dd일, HH시mm분ss초");
            time = zonedDateTime.format(myFormatObj);
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
