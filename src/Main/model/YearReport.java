package Main.model;

import java.util.List;

public class YearReport {
    private int month;
    private int amount;
    private String is_expense;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getIs_expense() {
        return is_expense;
    }

    public void setIs_expense(String is_expense) {
        this.is_expense = is_expense;
    }
    @Override
    public String toString(){
        return "Month:"+getMonth()+"Amount:"+getAmount()+"Is+expense"+getIs_expense();
    }
    public Integer sumYear(List<YearReport> yearReportList){
        int sumY = 0;
        for (YearReport a : yearReportList){
            if (a.getIs_expense().equals("TRUE")){sumY=a.getAmount()+sumY;}
            else {sumY = -1*a.getAmount()+sumY;}
        }
        System.out.println(sumY);
        return sumY;
    }
}
