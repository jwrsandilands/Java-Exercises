package best_practices;
import java.util.Scanner;
import static java.lang.Math.floor;

/*
This class has a super bloated method that does too many things at once. Refactor the describeYear method and
separate out the responsibilities into other methods to improve readability and maintainability.
 */
public class YearDescriber {

    static Scanner fromUser = new Scanner(System.in);

    private YearDescriber(){}; //static class

    public static void describeYear() {
        System.out.println("What year would you like to learn about?");
        int year = getUserYear();

        String printMessage = constructMessage(year);
        System.out.println(printMessage);
    }

    public static String constructMessage(int year){
        String printMessage = year + " was ";
        if(checkIfLeapYear(year)) {
            printMessage += "a leap year,";
        } else {
            printMessage += "not a leap year,";
        }
        printMessage += " and started on a ";
        printMessage += calculateYearStartDay(year);
        printMessage += "!";

        return printMessage;
    }

    public static int getUserYear(){
        int year;
        while(true) {
            try {
                year = fromUser.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Please just input a year in the format YYYY!");
            }
        }
        return year;
    }

    public static boolean checkIfLeapYear(int year){
        return (year%4 == 0) || ((year%100 == 0) && !(year%400 == 0));
    }

    public static String calculateYearStartDay(int year){
        int startDay = (1
                + (int)floor((2.6*11) -0.2)
                - (2*(year/100))
                + ((year%100)-1)
                + (int)floor((double)((year%100)-1) / 4)
                + (int)floor((double)(year/100) / 4));
        /*
        int/int uses integer division e.g 11/5 = 2 (discard the remainder)
        double/int uses true division e.g. (double)(11)/5 = 2.2
        */
        startDay = (startDay % 7 + 7) % 7;
        /*
        % is remainder function, NOT modulus division operator.
        Line 41 implements true modulus division.
        https://cs.uwaterloo.ca/~alopez-o/math-faq/node73.html for more info on the equation used.
        */

        String[] Days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return Days[startDay];
    }
}