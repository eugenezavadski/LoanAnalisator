package by.zavadski;

public class Calculation {


    //    расчет годового платежа
    public static double calculateAnnualPayment(double loanSum, int repayTime, double fullRate) {
        return (loanSum * (1 + repayTime * (fullRate / 100))) / repayTime;
    }

    public static int calculateMaxCreditSum(int maxLoanSumByLoanRate, int maxLoanSumByEmploymentType) {
        return Math.min(maxLoanSumByEmploymentType, maxLoanSumByLoanRate);
    }

    public static double calculateLoanSumRate(double loanSum) {
        return Math.abs(-1 * Math.log(loanSum));
    }


}
