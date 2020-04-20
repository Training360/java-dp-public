package intro.inheritance;

public class MonthlyEmployee extends Employee {

    private double monthlyAmount;

    public MonthlyEmployee(String name, double monthlyAmount) {
        super(name);
        this.monthlyAmount = monthlyAmount;
    }

    @Override
    public double pay() {
        return monthlyAmount;
    }

    public double getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(double monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }
}
