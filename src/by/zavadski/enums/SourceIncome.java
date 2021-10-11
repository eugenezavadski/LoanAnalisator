package by.zavadski.enums;

public enum SourceIncome {
    PASSIVE_INCOME(1,
            "пассивный доход",
            0.5,
            1),
    EMPLOYEE(2,
            "наемный работник",
            -0.25,
            5),
    BUSINESS(3,
            "собственный бизнес",
            0.25,
            10),
    UNEMPLOYMENT(4,
            "безработный",
            0,
            0);

    int index;
    String incomeSource;
    double loanRate;
    int maxLoanSum;

    public int getMaxLoanSum() {
        return maxLoanSum;
    }

    SourceIncome(int index, String incomeSource, double loanRate, int maxLoanSum) {
        this.index = index;
        this.incomeSource = incomeSource;
        this.loanRate = loanRate;
        this.maxLoanSum = maxLoanSum;
    }

    public static String[] incomeSourceCategoriesNames = new String[0];
    public static SourceIncome[] incomeSourceCategories = SourceIncome.values();


    public int getIndex() {
        return index;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public double getLoanRate() {
        return loanRate;
    }

    public static String[] getSourceIncomeNamesList() {
        incomeSourceCategoriesNames = new String[incomeSourceCategories.length];
        for (int i = 0; i < incomeSourceCategories.length; i++) {
            incomeSourceCategoriesNames[i] = incomeSourceCategories[i].getIncomeSource();
        }
        return incomeSourceCategoriesNames;
    }

    public static String getCategoryName(String[] categoriesNames, int index) {
        return categoriesNames[index];
    }


}
