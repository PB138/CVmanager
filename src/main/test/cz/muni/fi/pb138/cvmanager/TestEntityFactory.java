package cz.muni.fi.pb138.cvmanager;

import cz.muni.fi.pb138.cvmanager.entity.*;

/**
 * Created by nfabian on 6.6.16.
 */
public class TestEntityFactory {


    public static CurriculumVitae createCurriculumVitae() {
        return createCurriculumVitae(true, true, true, true, true, true, true, true);
    }

    public static CurriculumVitae createCurriculumVitaeOnlyPersonalInformation() {
        return createCurriculumVitae(true, false, false, false, false, false, false, false);
    }

    public static CurriculumVitae createCurriculumVitaeWithContact() {
        return createCurriculumVitae(true, true, false, false, false, false, false, false);
    }

    public static CurriculumVitae createCurriculumVitaeWithWork() {
        return createCurriculumVitae(true, false, true, false, false, false, false, false);
    }

    public static CurriculumVitae createCurriculumVitaeWithEducation() {
        return createCurriculumVitae(true, false, false, true, false, false, false, false);
    }

    public static CurriculumVitae createCurriculumVitaeWithAchievements() {
        return createCurriculumVitae(true, false, false, false, true, false, false, false);
    }

    public static CurriculumVitae createCurriculumVitaeWithLanguages() {
        return createCurriculumVitae(true, false, false, false, false, true, false, false);
    }

    public static CurriculumVitae createCurriculumVitaeWithSkills() {
        return createCurriculumVitae(true, false, false, false, false, false, true, false);
    }

    public static CurriculumVitae createCurriculumVitaeWithHobbies() {
        return createCurriculumVitae(true, false, false, false, false, false, false, true);
    }

    private static CurriculumVitae createCurriculumVitae(boolean personalInf, boolean contacts, boolean workExperiences,
                                                         boolean educations, boolean achievements, boolean languages,
                                                         boolean skills, boolean hobbies) {
        CurriculumVitae cv = new CurriculumVitae();

        if (personalInf) {
            cv.setFullName("fullName");
            cv.setAddress("address");
            cv.setBirthday("1.1.1990");
            cv.setPersonalProfile("PersonalInformation");
        }

        if (contacts) {
            Contact contact = new Contact();
            contact.setId("Tel");
            contact.setValue("Tel num");
            cv.getContacts().add(contact);
        }

        if (workExperiences) {
            Work work = new Work();
            work.setFrom(1990);
            work.setTo(2000);
            work.setCompany("Company");
            work.setPosition("Position");
            work.setValue("Value");
            cv.getWorkExperience().add(work);
        }

        if (educations) {
            Education education = new Education();
            education.setFrom(2000);
            education.setTo(2010);
            education.setSchool("School");
            education.setValue("SchoolValue");
            cv.getEducations().add(education);
        }

        if (achievements) {
            Achievement achievement = new Achievement();
            achievement.setYear(1000);
            achievement.setTitle("Achievement title");
            achievement.setValue("Achievement value");
            cv.getAchievements().add(achievement);
        }

        if (languages) {
            Language language = new Language();
            language.setLang("Lang");
            language.setLevel("Lang level");
            cv.getLanguages().add(language);
        }

        if (skills) {
            Skill skill = new Skill();
            skill.setTitle("Skill");
            skill.setValue("Skill value");
            cv.getSkills().add(skill);
        }

        if (hobbies) {
            Hobby hobby = new Hobby();
            hobby.setTitle("Hobby");
            hobby.setValue("Hobby value");
        }

        return cv;
    }
}
