package cz.muni.fi.pb138.cvmanager.enumeration;

/**
 * Created by nfabian on 27.4.16.
 */
public enum CurriculumVitaeAttribute {

    COMPANY("company"),
    FROM("from"),
    ID("id"),
    LANGUAGE("lang"),
    LEVEL("level"),
    POSITION("position"),
    SCHOOL("school"),
    TITLE("title"),
    TO("to"),
    YEAR("year");

    private final String value;

    CurriculumVitaeAttribute(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
