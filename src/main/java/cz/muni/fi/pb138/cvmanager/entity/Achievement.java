package cz.muni.fi.pb138.cvmanager.entity;

/**
 * Created by nfabian on 27.4.16.
 */
public class Achievement {

    private int year;
    private String title;
    private String value;

    public Achievement() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
