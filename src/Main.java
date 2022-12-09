import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nHello My Calendar!\n");

        GregorianCalendar calendar = new GregorianCalendar();

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);//today
        System.out.printf("Today is the %d-th ", dayOfMonth);

        int month;//month
        int thisMonth = calendar.get(Calendar.MONTH);//this month
        String monthText = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ROOT);
        System.out.print("of " + monthText);
        int year = calendar.get(Calendar.YEAR);
        System.out.printf(" %d\n\n", year);

        calendar.set(Calendar.DAY_OF_MONTH, 1);//start calendar count days
        calendar.set(Calendar.MONTH, 0);//start calendar count month

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);//name day of week

        String[] nameMonth = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE",
                "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};//name of month

        for (month = 0; month <= Calendar.DECEMBER; month++) {
            System.out.println("" + nameMonth[month]);//prints name of month
            String[] nameDaysOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};//prints name of weekday
            for (String day : nameDaysOfWeek) {
                System.out.print(day + " ");
            }
            System.out.println();
            for (int i = Calendar.SUNDAY; i < dayOfWeek; i++) {//starts first day of month from a right weekday
                System.out.print("    ");
            }

            do {
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                System.out.printf("%3d", currentDay);

                if ((month == thisMonth) && (currentDay == dayOfMonth)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

                if (dayOfWeek == Calendar.SATURDAY) {
                    System.out.println();
                }

                calendar.add(Calendar.DAY_OF_MONTH, 1);
                dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            } while (calendar.get(Calendar.MONTH) == month);

            if (dayOfWeek != Calendar.SUNDAY) {
                System.out.println("\n");
            }
        }
    }
}