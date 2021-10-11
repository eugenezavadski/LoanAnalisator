package by.zavadski;

import static by.zavadski.Input.printMessage;
import static by.zavadski.Input.readDouble;
import static by.zavadski.Input.readKeyInt;
import static by.zavadski.Input.readPositiveInt;
import static by.zavadski.Input.readString;
import static by.zavadski.Input.showAvailableOptionsForInput;
import static by.zavadski.Input.showInputHelp;
import static by.zavadski.Switches.switchGender;
import static by.zavadski.Switches.switchLoanPurpose;
import static by.zavadski.Switches.switchLoanPurposeRate;
import static by.zavadski.Switches.switchLoanRating;
import static by.zavadski.Switches.switchSourceIncome;
import static by.zavadski.Switches.switchSourceIncomeRate;
import static by.zavadski.data.Constants.AGE_RANGE;
import static by.zavadski.data.Constants.GENDER_RANGE;
import static by.zavadski.data.Constants.INCOME_SUM_RANGE;
import static by.zavadski.data.Constants.LOAN_PURPOSE_RANGE;
import static by.zavadski.data.Constants.LOAN_RATING_RANGE;
import static by.zavadski.data.Constants.LOAN_SUM_RANGE;
import static by.zavadski.data.Constants.REPAY_TIME_RANGE;
import static by.zavadski.enums.MessagesEnum.LOAN_ACCEPTED;
import static by.zavadski.enums.MessagesEnum.MAX_AVAILABLE_SUM;
import static by.zavadski.enums.MessagesEnum.NOT_IN_RANGE;
import static by.zavadski.enums.MessagesEnum.VALUE_ACCEPTED;
import static by.zavadski.enums.SourceIncome.getSourceIncomeNamesList;
import static by.zavadski.isChecker.isAgeOnRepayAllowedAForLoan;
import static by.zavadski.isChecker.isIncomeEnough;
import static by.zavadski.isChecker.isIncomeSumMoreThanHalfAnnualPayment;
import static by.zavadski.isChecker.isMaxAvailableSumMoreThanLoanSum;
import static by.zavadski.isChecker.isNumberInRange;

import by.zavadski.enums.LoanPurpose;
import by.zavadski.enums.MessagesEnum;
import by.zavadski.data.ApplicationForm;

public class Main {

    public static ApplicationForm form = new ApplicationForm();

    public static void main(String[] args) {
        processAge();
        processGender();
        processSourceIncome();
        processIncomeSum();
        processLoanRating();
        processLoanSum();
        processRepayTime();
        processLoanPurpose();
        printAllVarsDebug();
        validateForm();
    }

    private static void processAge() {
        showInputHelp("Age", AGE_RANGE);
        form.setAge(readPositiveInt());
        validateRange(isNumberInRange(form.getAge(), AGE_RANGE));
    }

    private static void processGender() {
        showInputHelp("Gender", GENDER_RANGE);
        form.setGender(switchGender(readString(GENDER_RANGE)));
        printMessage(MessagesEnum.VALUE_ACCEPTED.getText(), form.getGender().toString());
    }

    private static void processSourceIncome() {
        showInputHelp("Source of Income", " ");
        showAvailableOptionsForInput(getSourceIncomeNamesList());
        form.setSourceIncome(switchSourceIncome(readPositiveInt()));
        form.setMaxLoanSumForSourceIncome(form.getSourceIncome().getMaxLoanSum());
        form.setSourceIncomeRate(switchSourceIncomeRate(form.getSourceIncome().getIndex()));
    }

    private static void processIncomeSum() {
        showInputHelp("Income For Last Year", "mln");
        form.setIncomeSum(readPositiveInt());
        validateRange(form.getIncomeSum(), INCOME_SUM_RANGE);
    }

    private static void processLoanRating() {
        showInputHelp("Loan Rating", LOAN_RATING_RANGE);
        form.setLoanRating(switchLoanRating(readKeyInt()));
        form.setMaxLoanSumByLoanRating(form.getLoanRating().getMaxAvailableSum());
        form.setLoanRate(form.getLoanRating().getLoanRateByRating());
    }

    private static void processLoanSum() {
        showInputHelp("Requested Sum", LOAN_SUM_RANGE);
        form.setLoanSum(readDouble());
        validateRange(form.getLoanSum(), LOAN_SUM_RANGE);
        form.setLoanSumRate(Calculation.calculateLoanSumRate(form.getLoanSum()));
    }

    private static void processRepayTime() {
        showInputHelp("Repay Time", REPAY_TIME_RANGE);
        form.setRepayTime(readPositiveInt());
        validateRange(form.getRepayTime(), REPAY_TIME_RANGE);
    }

    private static void processLoanPurpose() {
        showInputHelp("Loan Purpose", LOAN_PURPOSE_RANGE);
        showAvailableOptionsForInput(LoanPurpose.getLoanPurposeNamesList());
        form.setLoanPurpose(switchLoanPurpose(readPositiveInt()));
        form.setLoanPurposeRate(switchLoanPurposeRate(form.getLoanPurpose().getIndex()));
        form.setAnnualPayment(Calculation
                .calculateAnnualPayment(form.getLoanSum(), form.getRepayTime(),
                        form.getFullRate()));
    }


    public static void validateForm() {
        printMessage(MAX_AVAILABLE_SUM.getText() + form.getMaxAvailableSum());

        printMessage("Retirement Ages is OK");
        isAgeOnRepayAllowedAForLoan(form.getAge(), form.getRepayTime());

        printMessage("Loan Sum / Repay Time > 1/3 of income");
        isIncomeEnough(form.getLoanSum(), form.getIncomeSum(),
                form.getRepayTime());

        printMessage("Max Available Sum not exceeded");
        isMaxAvailableSumMoreThanLoanSum(form.getMaxAvailableSum(), form.getLoanSum());

        printMessage("Annual Payment > 1/2 Income");
        isIncomeSumMoreThanHalfAnnualPayment(form.getIncomeSum(), form.getAnnualPayment());

        printMessage(LOAN_ACCEPTED.getText());

    }


    private static boolean validateRange(boolean statement) {
        if (!statement) {
            printMessage(NOT_IN_RANGE.getText());
            return false;
        } else {
            printMessage(VALUE_ACCEPTED.getText());
            return true;
        }
    }

    private static boolean validateRange(double value, String range) {
        if (!isNumberInRange(value, range)) {
            printMessage(NOT_IN_RANGE.getText(), String.valueOf(value));
            return false;
        } else {
            printMessage(VALUE_ACCEPTED.getText(), String.valueOf(value));
            return true;
        }
    }

    private static void printAllVarsDebug() {
        System.out.printf("Age:%d%n Gender:%s%n Source of Income:%s%n IncomeSum:%d%n "
                        + "Loan Rating:%d%n Loan Sum:%.2f mln%n Repay Time: %dy%n "
                        + "LoanPurpose: %s%n maxssumBySourceIncome: %d%n maxSumByLoanRating: %d%n Loan Rate Summary: %.2f%n",
                form.getAge(),
                form.getGender(),
                form.getSourceIncome(),
                form.getIncomeSum(),
                form.getLoanRating().getValue(),
                form.getLoanSum(),
                form.getRepayTime(),
                form.getLoanPurpose(),
                form.getMaxLoanSumForSourceIncome(),
                form.getMaxLoanSumByLoanRating(),
                form.getSummaryRate());
        System.out
                .printf("loanRate %.2f%n loanPurposeRate %.2f%n sourceIncomeRate %.2f%n loanSumRate %.2f%n fullRate: %.2f%n",
                        form.getLoanRate(),
                        form.getLoanPurposeRate(),
                        form.getSourceIncomeRate(),
                        form.getLoanSumRate(),
                        form.getFullRate());
        System.out.printf("Annual Payment: %.2f%n", form.getAnnualPayment());
    }

}


