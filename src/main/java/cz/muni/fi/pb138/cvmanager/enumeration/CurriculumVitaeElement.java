package cz.muni.fi.pb138.cvmanager.enumeration;

/**
 * Created by nfabian on 27.4.16.
 */
public enum CurriculumVitaeElement {

    ADDRESS("address"),
    ACHIEVEMENT_ITEM("achievementItem"),
    ACHIEVEMENTS("achievements"),
    BIRTHDAY("birthday"),
    CONTACT("contact"),
    CONTACTS("contacts"),
    CURRICULUM_VITAE("cv"),
    EDUCATION_ITEM("educationItem"),
    EDUCATIONS("educations"),
    FULL_NAME("fullName"),
    HOBBY_ITEM("hobbyItem"),
    HOBBIES("hobbies"),
    LANGUAGE_ITEM("languageItem"),
    LANGUAGES("languages"),
    PERSONAL_INFORMATION("personalInformation"),
    PERSONAL_PROFILE("personalProfile"),
    SKILL_ITEM("skillItem"),
    SKILLS("skills"),
    WORK_EXPERIENCE("workExperience"),
    WORK_ITEM("workItem");

    private final String value;

    CurriculumVitaeElement(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
