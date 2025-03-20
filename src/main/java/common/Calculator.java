package common;

public class Calculator {

    private double first;
    private double second;
    private double result;

    public Calculator(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public void add() {
        result = first + second;
    }

    public double getResult() {
        return result;
    }

    public void sub() {
        result = first - second;
    }
}
