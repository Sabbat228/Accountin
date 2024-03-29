package Main;

import Main.model.MonthlyReport;
import Main.read.ReadingMonth;
import Main.read.ReadingYear;

import java.util.Scanner;

public class Main {
    MonthlyReport monthlyReport;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int chase = in.nextInt();
        switch (chase){
            case 1:
                ReadingMonth.read();
                break;
            case 2:
                ReadingYear.main();
                break;
        }
    }

}
