package by.zavadski;

import static by.zavadski.Input.printMessage;
import static by.zavadski.enums.LoanPurpose.BUISNESS_GROW;
import static by.zavadski.enums.LoanPurpose.CAR;
import static by.zavadski.enums.LoanPurpose.CONSUMER;
import static by.zavadski.enums.LoanPurpose.MORTAGE;
import static by.zavadski.enums.MessagesEnum.LOAN_NOT_ACCEPTED;
import static by.zavadski.enums.MessagesEnum.NOT_IN_RANGE;
import static by.zavadski.enums.MessagesEnum.NOT_PATTERN;
import static by.zavadski.enums.MessagesEnum.VALUE_ACCEPTED;
import static by.zavadski.enums.SourceIncome.BUSINESS;
import static by.zavadski.enums.SourceIncome.EMPLOYEE;
import static by.zavadski.enums.SourceIncome.PASSIVE_INCOME;
import static by.zavadski.enums.SourceIncome.UNEMPLOYMENT;
import static java.lang.Integer.parseInt;

import by.zavadski.enums.Genders;
import by.zavadski.enums.LoanPurpose;
import by.zavadski.enums.LoanRating;
import by.zavadski.enums.SourceIncome;

public class Switches {


    public static int[] parseMinMax(String sumRange) {
        String[] range = sumRange.split(":");
        int[] minMax = new int[2];
        int min = parseInt(range[0]);
        int max = parseInt(range[1]);
        minMax[0] = min;
        minMax[1] = max;
        return minMax;
    }

    public static double switchSourceIncomeRate(int index) {
        switch (index) {
            case 1:
                return PASSIVE_INCOME.getLoanRate();
            case 2:
                return EMPLOYEE.getLoanRate();
            case 3:
                return BUSINESS.getLoanRate();
            case 4:
                return UNEMPLOYMENT.getLoanRate();
            default:
                throw new IllegalStateException(LOAN_NOT_ACCEPTED.getText() + index);
        }
    }

    public static double switchLoanPurposeRate(int index) {
        switch (index) {
            case 1:
                return MORTAGE.getLoanRate();
            case 2:
                return BUISNESS_GROW.getLoanRate();
            case 3:
                return CAR.getLoanRate();
            case 4:
                return CONSUMER.getLoanRate();
            default:
                throw new IllegalStateException(NOT_IN_RANGE.getText() + index);
        }
    }

    public static LoanRating switchLoanRating(int loanRating) {
        switch (loanRating) {
            case -2:
                printMessage(LOAN_NOT_ACCEPTED.getText(),"Due Loan Rating -2");
                System.exit(2);
//                return LoanRating.MINUS_TWO;
            case -1:
                printMessage(VALUE_ACCEPTED.getText(), String.valueOf(loanRating));
                return LoanRating.MINUS_ONE;
            case 0:
                printMessage(VALUE_ACCEPTED.getText(), String.valueOf(loanRating));
                return LoanRating.NULL;
            case 1:
                printMessage(VALUE_ACCEPTED.getText(), String.valueOf(loanRating));
                return LoanRating.ONE;
            case 2:
                printMessage(VALUE_ACCEPTED.getText(), String.valueOf(loanRating));
                return LoanRating.TWO;
            default:
                throw new IllegalStateException(NOT_IN_RANGE.getText() + loanRating);
        }
    }

    public static void getMessage(int alertNumber, String details) {
        switch (alertNumber) {
            case 1:
                System.out.printf("Value %s not in range!%n", details);
                break;
            case 2:
                System.out.printf("Value not correspond pattern: %s%n", details);
                break;
            case 3:
                System.out.printf("That's not a number!%n");
                break;
            case 4:
                System.out.printf("Value %s accepted%n", details);
                break;
            case 5:
                System.out.printf("Credit can't be accepted for Loan Rating:%s%n", details);
                break;
            case 6:
                System.out.printf("Enter number of option from list:%s%n", details);
                break;
            case 7:
                System.out.printf("Credit can't be accepted for specified Income Source %s%n", details);
                break;
            case 8:
                System.out.printf("Credit can't be accepted due Retirement Age:%s%n", details);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + alertNumber);
        }

    }

    public static Genders switchGender(String gender) {
        switch (gender.toUpperCase()) {
            case "F":
                return Genders.FEMALE;
            case "M":
                return Genders.MALE;
            default:
                printMessage(NOT_PATTERN.getText(), gender);
                return Genders.NOT_KNOWN;
        }
    }

    public static LoanPurpose switchLoanPurpose(int selectedOption) {
        switch (selectedOption) {
            case 1:
                printMessage(VALUE_ACCEPTED.getText(), String.valueOf(selectedOption));
                return MORTAGE;
            case 2:
                printMessage(VALUE_ACCEPTED.getText(), String.valueOf(selectedOption));
                return BUISNESS_GROW;
            case 3:
                printMessage(VALUE_ACCEPTED.getText(), String.valueOf(selectedOption));
                return CAR;
            case 4:
                printMessage(VALUE_ACCEPTED.getText(), String.valueOf(selectedOption));
                return CONSUMER;
            default:
                throw new IllegalStateException(NOT_IN_RANGE.getText() + selectedOption);
        }
    }

    public static SourceIncome switchSourceIncome(int selectedOption) {
        switch (selectedOption) {
            case 1:
                printMessage(VALUE_ACCEPTED.getText(), PASSIVE_INCOME.getIncomeSource());
                return PASSIVE_INCOME;
            case 2:
                printMessage(VALUE_ACCEPTED.getText(), EMPLOYEE.getIncomeSource());
                return EMPLOYEE;
            case 3:
                printMessage(VALUE_ACCEPTED.getText(), BUSINESS.getIncomeSource());
                return BUSINESS;
            case 4:
                printMessage(LOAN_NOT_ACCEPTED.getText(), "Due Source of Income: " + UNEMPLOYMENT.getIncomeSource());
                System.exit(2);
            default:
                throw new IllegalStateException(NOT_IN_RANGE.getText() + selectedOption);
        }
    }



}
