package by.zavadski.enums;

public enum MessagesEnum {
    NOT_IN_RANGE("Value not in range."),
    NOT_PATTERN("Value not correspond to pattern."),
    NOT_A_NUMBER("That's not a number."),
    VALUE_ACCEPTED("Value accepted."),
    LOAN_NOT_ACCEPTED("Loan NOT ACCEPTED (exit code 2)."),
    LOAN_ACCEPTED("Loan ACCEPTED."),
    MAX_AVAILABLE_SUM("Maximum available Loan Sum: ");

    String text;

    MessagesEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
