import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateBasics {
    public static void main(String[] args) {
        LocalDate driveDate = LocalDate.of(2026, 11, 18);

        System.out.println("Drive date       : " + driveDate);
        System.out.println("Day of week      : " + driveDate.getDayOfWeek());
        System.out.println("Day of year      : " + driveDate.getDayOfYear());
        System.out.println("Days in month    : " + driveDate.lengthOfMonth());
        System.out.println("Leap year?       : " + driveDate.isLeapYear());

        LocalDate reportingDate = driveDate.plusDays(3);
        LocalDate prepStart = driveDate.minusWeeks(2);

        System.out.println("Reporting date   : " + reportingDate);
        System.out.println("Prep starts      : " + prepStart);
        System.out.println("Drive before reporting? " + driveDate.isBefore(reportingDate));

        LocalDate joining = LocalDate.of(2027, Month.JULY, 1);
        System.out.println("Joining date     : " + joining + " (" + joining.getDayOfWeek() + ")");

        LocalTime reportingTime = LocalTime.of(9, 30);
        System.out.println("Reporting time   : " + reportingTime);
        System.out.println("Lunch break      : " + reportingTime.plusHours(3).plusMinutes(30));

        LocalDateTime slot = LocalDateTime.of(driveDate, reportingTime);
        System.out.println("Interview slot   : " + slot);

        DayOfWeek day = driveDate.getDayOfWeek();
        boolean weekend = day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;

        System.out.println("Weekend?         : " + weekend);
    }
}