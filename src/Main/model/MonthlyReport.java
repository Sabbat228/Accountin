package Main.model;

import java.util.List;

public class MonthlyReport {
    private String item_name;
    private String is_exept;
    private int quantity;
    private int sum_of_one;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getIs_exept() {
        return is_exept;
    }

    public String setIs_exeption(String is_exept) {
        this.is_exept = is_exept;
        return is_exept;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSum_of_one() {
        return sum_of_one;
    }

    public void setSum_of_one(int sum_of_one) {
        this.sum_of_one = sum_of_one;
    }

    @Override
    public String toString(){
        return "Name:"+getItem_name()+" "+"Is_exeption:"+ getIs_exept()+" "+"Quantity:"+getQuantity()+" "+"Sum_of_one:"+getSum_of_one();
    }

    public  Integer sumMonth(List<MonthlyReport> monthlyReportList){
        int sumM = 0;
        for (MonthlyReport a : monthlyReportList){
            if (a.getIs_exept().equals("TRUE")){sumM=a.getSum_of_one() * a.getQuantity()+sumM;}
            else {sumM = -1*(a.getSum_of_one()*a.getQuantity())+sumM;}
        }
        System.out.println(sumM);
        return sumM;
    }
}
