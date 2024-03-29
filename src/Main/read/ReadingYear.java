package Main.read;

import Main.model.MonthlyReport;
import Main.model.YearReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingYear {
    public static void main() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Input name file:");
        String name_file =  "C:\\Users\\User\\Desktop\\"+in.nextLine();
        char y = name_file.charAt(1);
        if(y!='y'){
            System.out.println("Вы выбрали не тот формат!!!");}
        else {
            BufferedReader reader = new BufferedReader(new FileReader(name_file));
            String line = null;
            Scanner scanner = null;
            int index = 0;
            List<YearReport> yearReportList = new ArrayList<>();
            YearReport yearReport = null;
            while ((line = reader.readLine()) != null) {
                yearReport = new YearReport();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == 0)
                        yearReport.setMonth(Integer.parseInt(data));
                    else if (index == 1)
                        yearReport.setAmount(Integer.parseInt(data));
                    else if (index == 2)
                        yearReport.setIs_expense(data);
                    else
                        System.out.println("Некорректные данные::" + data);
                    index++;
                }
                index = 0;
                yearReportList.add(yearReport);
            }
            reader.close();
            yearReport.sumYear(yearReportList);
            System.out.println(yearReportList);
        }
            }
}
