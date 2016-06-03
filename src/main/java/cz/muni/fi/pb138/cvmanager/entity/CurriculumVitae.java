package cz.muni.fi.pb138.cvmanager.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nfabian on 27.4.16.
 */
public class CurriculumVitae {

    private String fullName;
    private String address;
    private String birthday;
    private List<Contact> contacts;
    private String personalProfile;
    private List<Work> workExperience;
    private List<Education> educations;
    private List<Achievement> achievements;
    private List<Language> languages;
    private List<Skill> skills;
    private List<Hobby> hobbies;

    public CurriculumVitae() {
        contacts = new ArrayList<Contact>();
        workExperience = new ArrayList<Work>();
        educations = new ArrayList<Education>();
        achievements = new ArrayList<Achievement>();
        languages = new ArrayList<Language>();
        skills = new ArrayList<Skill>();
        hobbies = new ArrayList<Hobby>();
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

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public List<Work> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<Work> workExperience) {
        this.workExperience = workExperience;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
}
