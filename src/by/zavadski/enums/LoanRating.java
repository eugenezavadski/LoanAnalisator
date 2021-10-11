package by.zavadski.enums;

public enum LoanRating {
    MINUS_TWO(0, 0.0, 0),
    MINUS_ONE(-1, 1.5, 1),
    NULL(0, 0.0, 5),
    ONE(1, -0.25, 10),
    TWO(2, -0.75, 10);

    int value;
    double loanRateByRating;
    int maxAvailableSum;

    LoanRating(int value, double loanRateByRating, int maxAvailableSum) {
        this.value = value;
        this.loanRateByRating = loanRateByRating;
        this.maxAvailableSum = maxAvailableSum;
    }

    public int getValue() {
        return value;
    }

    public double getLoanRateByRating() {
        return loanRateByRating;
    }

    public int getMaxAvailableSum() {
        return maxAvailableSum;
    }
}
