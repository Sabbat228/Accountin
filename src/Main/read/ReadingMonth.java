package Main.read;

import Main.model.MonthlyReport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class ReadingMonth {
    public static ArrayList<MonthlyReport> read() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input name file:");
        String name_file = "c:\\Users\\User\\Desktop\\" + in.nextLine() + ".csv";
        char m = name_file.charAt(1);
        ArrayList<MonthlyReport> monthlyReportList = null;
        if (m == 'm') {
            System.out.println("Вы выбрали не тот формат!!!");
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(name_file))) {
                String line = null;
                Scanner scanner = null;
                int index = 0;
                monthlyReportList = new ArrayList<>();
                MonthlyReport monthlyReport = null;
                while ((line = reader.readLine()) != null) {
                    monthlyReport = new MonthlyReport();
                    scanner = new Scanner(line);
                    scanner.useDelimiter(";");
                    while (scanner.hasNext()) {
                        String data = scanner.next();
                        if (index == 0)
                            monthlyReport.setItem_name(data);
                        else if (index == 1)
                            monthlyReport.setIs_exeption(data);
                        else if (index == 2)
                            monthlyReport.setQuantity(parseInt(data));
                        else if (index == 3)
                            monthlyReport.setSum_of_one(parseInt(data));
                        else
                            System.out.println("Некорректные данные::" + data);
                        index++;
                    }
                    index = 0;
                    monthlyReportList.add(monthlyReport);
                }
                reader.close();
                monthlyReport.toString();
                monthlyReport.sumMonth(monthlyReportList);
                System.out.println(monthlyReportList);
                return monthlyReportList;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return monthlyReportList;
    }

}
