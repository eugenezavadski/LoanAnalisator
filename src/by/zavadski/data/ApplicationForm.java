package by.zavadski.data;

import by.zavadski.enums.Genders;
import by.zavadski.enums.LoanPurpose;
import by.zavadski.enums.LoanRating;
import by.zavadski.enums.SourceIncome;

public class ApplicationForm {

    int age;
    Genders gender;
    SourceIncome sourceIncome;
    int incomeSum;
    LoanRating loanRating;
    double loanSum;
    int repayTime;
    LoanPurpose loanPurpose;

    int maxLoanSumForSourceIncome;
    int maxLoanSumByLoanRating;

    double loanRate;
    double loanPurposeRate;
    double sourceIncomeRate;
    double loanSumRate;

    double annualPayment;

    public double getMaxAvailableSum() {
        if (maxLoanSumForSourceIncome <= maxLoanSumByLoanRating) {
            return maxLoanSumForSourceIncome;
        } else {
            return maxLoanSumByLoanRating;
        }
    }

    public double getAnnualPayment() {
        return annualPayment;
    }

    public void setAnnualPayment(double annualPayment) {
        this.annualPayment = annualPayment;
    }


    public double getSummaryRate() {
        return (loanRate + loanPurposeRate + sourceIncomeRate + loanSumRate);
    }

    public double getFullRate() {
        return Constants.BASE_LOAN_RATE + getSummaryRate();
    }

    public void setLoanSum(double loanSum) {
        this.loanSum = loanSum;
    }

    public double getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(double loanRate) {
        this.loanRate = loanRate;
    }

    public double getLoanPurposeRate() {
        return loanPurposeRate;
    }

    public void setLoanPurposeRate(double loanPurposeRate) {
        this.loanPurposeRate = loanPurposeRate;
    }

    public double getSourceIncomeRate() {
        return sourceIncomeRate;
    }

    public void setSourceIncomeRate(double sourceIncomeRate) {
        this.sourceIncomeRate = sourceIncomeRate;
    }

    public double getLoanSumRate() {
        return loanSumRate;
    }

    public void setLoanSumRate(double loanSumRate) {
        this.loanSumRate = loanSumRate;
    }

    public int getMaxLoanSumByLoanRating() {
        return maxLoanSumByLoanRating;
    }

    public void setMaxLoanSumByLoanRating(int maxLoanSumByLoanRating) {
        this.maxLoanSumByLoanRating = maxLoanSumByLoanRating;
    }

    public int getMaxLoanSumForSourceIncome() {
        return maxLoanSumForSourceIncome;
    }

    public void setMaxLoanSumForSourceIncome(int maxLoanSumForSourceIncome) {
        this.maxLoanSumForSourceIncome = maxLoanSumForSourceIncome;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public SourceIncome getSourceIncome() {
        return sourceIncome;
    }

    public void setSourceIncome(SourceIncome sourceIncome) {
        this.sourceIncome = sourceIncome;
    }

    public int getIncomeSum() {
        return incomeSum;
    }

    public void setIncomeSum(int incomeSum) {
        this.incomeSum = incomeSum;
    }

    public LoanRating getLoanRating() {
        return loanRating;
    }

    public void setLoanRating(LoanRating loanRating) {
        this.loanRating = loanRating;
    }

    public Double getLoanSum() {
        return loanSum;
    }

    public void setLoanSum(Double loanSum) {
        this.loanSum = loanSum;
    }

    public int getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(int repayTime) {
        this.repayTime = repayTime;
    }

    public LoanPurpose getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(LoanPurpose loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

}
