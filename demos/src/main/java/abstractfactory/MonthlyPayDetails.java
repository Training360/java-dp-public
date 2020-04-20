package abstractfactory;

public class MonthlyPayDetails implements PayDetails {

    private double monthlyAmount;

    public MonthlyPayDetails(double monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    @Override
    public double pay() {
        return monthlyAmount;
    }
}
