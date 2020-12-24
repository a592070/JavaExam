package JavaForReallyImpatientExam.Chapter2.Demo01LocalDate;

import java.time.LocalDate;
import java.time.ZoneId;

public class Demo01LocalDate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020,5,20);
        LocalDate dateNow = LocalDate.now(ZoneId.of("GMT+8"));
        System.out.println(dateNow);
        System.out.println(ZoneId.systemDefault());
        System.out.println(dateNow.plusDays(200));
        System.out.println(dateNow.getChronology());
        System.out.println(dateNow.getEra());

    }

}
