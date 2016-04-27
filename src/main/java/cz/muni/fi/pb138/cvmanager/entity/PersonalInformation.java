package cz.muni.fi.pb138.cvmanager.entity;

import java.util.List;

/**
 * Created by nfabian on 27.4.16.
 */
public class PersonalInformation {

    private String fullName;
    private String address;
    private String birthday;
    private List<Contact> contacts;

    public PersonalInformation() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
