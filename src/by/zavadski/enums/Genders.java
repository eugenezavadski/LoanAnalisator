package by.zavadski.enums;
//ISO5218 описывает стандартные коды для обозначения пола для информационных систем

public enum Genders {
    NOT_KNOWN(0),
    MALE(1),
    FEMALE(2),
    NOT_APLICABLE(9);

    int iso5218Code;

    Genders(int iso5218Code) {
        this.iso5218Code = iso5218Code;
    }
}
