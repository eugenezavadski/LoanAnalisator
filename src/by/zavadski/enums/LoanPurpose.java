package by.zavadski.enums;

public enum LoanPurpose {
    MORTAGE(1, "ипотека", -2),
    BUISNESS_GROW(2, "развитие бизнеса", -0.5),
    CAR(3, "автокредит", 0),
    CONSUMER(4, "потребительский", 1.5);

    int index;
    String loanPurpose;
    double loanRate;


    LoanPurpose(int index, String loanPurpose, double loanRate) {
        this.index = index;
        this.loanPurpose = loanPurpose;
        this.loanRate = loanRate;
    }

    public static String[] loanPurposeNames = new String[0];
    public static LoanPurpose[] loanPurposesArray = LoanPurpose.values();

    public int getIndex() {
        return index;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public double getLoanRate() {
        return loanRate;
    }

    public static String[] getLoanPurposeNamesList() {
        loanPurposeNames = new String[loanPurposesArray.length];
        for (int i = 0; i < loanPurposesArray.length; i++) {
            loanPurposeNames[i] = loanPurposesArray[i].getLoanPurpose();
        }
        return loanPurposeNames;
    }

}
