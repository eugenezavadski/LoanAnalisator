package by.zavadski;

import static by.zavadski.Input.printMessage;
import static by.zavadski.data.Constants.RETIREMENT_AGE;
import static by.zavadski.enums.MessagesEnum.LOAN_ACCEPTED;
import static by.zavadski.enums.MessagesEnum.LOAN_NOT_ACCEPTED;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class isChecker {

    public static void isLoanAccepted(boolean statement) {
        if (!statement) {
            printMessage(LOAN_NOT_ACCEPTED.getText());
            System.exit(2);
        } else {
            printMessage(LOAN_ACCEPTED.getText());
        }
    }

    public static boolean isAgeOnRepayAllowedAForLoan(int age, int repayTime) {
        if (RETIREMENT_AGE > (age + repayTime)) {
            return true;
        } else {
            printMessage(LOAN_NOT_ACCEPTED.getText());
            System.exit(2);
            return false;
        }
    }

    public static boolean isIncomeEnough(double loanSum, double incomeSum, int repayTime) {
        if ((loanSum / repayTime) < (incomeSum / 3)) {
            return true;
        } else {
            printMessage(LOAN_NOT_ACCEPTED.getText());
            System.exit(2);
            return false;
        }
    }

    public static boolean isIncomeSumMoreThanHalfAnnualPayment(double incomeSum, double annualPayment) {
        if (annualPayment < incomeSum / 2) {
            return true;
        } else {
            printMessage(LOAN_NOT_ACCEPTED.getText());
            System.exit(2);
            return false;
        }
    }

    public static boolean isMaxAvailableSumMoreThanLoanSum(double maxAvailableSum, double loanSum) {
        if (maxAvailableSum >= loanSum) {
            return true;
        } else {
            printMessage(LOAN_NOT_ACCEPTED.getText());
            System.exit(2);
            return false;
        }
    }

    public static boolean isNumberInRange(int inputInt, String pattern) {
        String[] range = pattern.split(":");
        int min = parseInt(range[0]);
        int max = parseInt(range[1]);
        return (inputInt >= min && inputInt <= max);
    }

    public static boolean isNumberInRange(double inputDouble, String pattern) {
        String[] range = pattern.split(":");
        double min = parseDouble(range[0]);
        double max = parseDouble(range[1]);
        return (inputDouble >= min && inputDouble <= max);
    }
}
