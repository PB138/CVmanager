package cz.muni.fi.pb138.cvmanager.entity;

/**
 * Created by nfabian on 27.4.16.
 */
public class Education {

    private int from;
    private int to;
    private String school;
    private String value;

    public Education() {
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
