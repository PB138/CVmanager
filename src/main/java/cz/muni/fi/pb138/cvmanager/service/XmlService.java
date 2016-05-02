package cz.muni.fi.pb138.cvmanager.service;

import cz.muni.fi.pb138.cvmanager.entity.*;
import cz.muni.fi.pb138.cvmanager.enumeration.CurriculumVitaeAttribute;
import cz.muni.fi.pb138.cvmanager.enumeration.CurriculumVitaeElement;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nfabian on 27.4.16.
 */
@Service
public class XmlService {

    private static final String XML_CV_FOLDER = "cvxml";

    /**
     * Removes users XML CV
     * @param username username
     */
    public void removeXml(String username) {
        File file = new File(createXmlPath(username));
        if(file.exists())
            file.delete();
    }

    /**
     * Serializes curriculum vitae into XML file in the cvxml folder using username for file name
     * @param username username
     * @param cv curriculum vitae
     * @throws TransformerException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public void serializeToXml(String username, CurriculumVitae cv) throws TransformerException,
            ParserConfigurationException, IOException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        DOMSource domSource = new DOMSource(createDocument(cv));
        StreamResult result = new StreamResult(createFile(username));
        transformer.transform(domSource, result);
    }

    /**
     * Creates file if doesn't exist. Transfer user name into an xml cv filename and path.
     * @param username Username
     * @return Xml cv file path
     * @throws IOException
     */
    private String createFile(String username) throws IOException {
        String filepath = createXmlPath(username);
        File file = new File(filepath);
        if(!file.exists())
            file.createNewFile();
        return filepath;
    }

    private String createXmlPath(String username) {
        return XML_CV_FOLDER + "/" + username + "_cv.xml";
    }

    /**
     * Creates DOM document of the curriculum vitae
     * @param cv Curriculum vitae
     * @return DOM document
     * @throws ParserConfigurationException
     */
    private Document createDocument(CurriculumVitae cv) throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        DOMImplementation impl = builder.getDOMImplementation();
        Document doc = impl.createDocument(null, CurriculumVitaeElement.CURRICULUM_VITAE.toString(), null);
        appendWithPersonalInformation(doc, cv);
        if(cv.getPersonalProfile() != null)
            appendWithPersonalProfile(doc, cv.getPersonalProfile());
        if(cv.getWorkExperience() != null && !cv.getWorkExperience().isEmpty())
            appendWithWorkExperience(doc, cv.getWorkExperience());
        if(cv.getEducations() != null && !cv.getEducations().isEmpty())
            appendWithEducations(doc, cv.getEducations());
        if(cv.getAchievements() != null && !cv.getAchievements().isEmpty())
            appendWithAchievements(doc, cv.getAchievements());
        if(cv.getLanguages() != null && !cv.getLanguages().isEmpty())
            appendWithLanguages(doc, cv.getLanguages());
        if(cv.getSkills() != null && !cv.getSkills().isEmpty())
            appendWithSkills(doc, cv.getSkills());
        if(cv.getHobbies() != null && !cv.getHobbies().isEmpty())
            appendWithHobbies(doc, cv.getHobbies());
        return doc;
    }

    /**
     * Appends DOM document with the PersonalInformation
     * @param doc DOM document
     * @param cv Curriculum Vitae
     */
    private void appendWithPersonalInformation(Document doc, CurriculumVitae cv) {
        Node cvNode = doc.getDocumentElement();
        Element personalInformation = doc.createElement(CurriculumVitaeElement.PERSONAL_INFORMATION.toString());
        cvNode.appendChild(personalInformation);
        if(!cv.getFullName().isEmpty())
            addChildElement(doc, personalInformation, CurriculumVitaeElement.FULL_NAME.toString(), cv.getFullName());
        if(!cv.getAddress().isEmpty())
            addChildElement(doc, personalInformation, CurriculumVitaeElement.ADDRESS.toString(), cv.getAddress());
        if(!cv.getBirthday().isEmpty())
            addChildElement(doc, personalInformation, CurriculumVitaeElement.BIRTHDAY.toString(), cv.getBirthday());
        if(cv.getContacts() != null && !cv.getContacts().isEmpty()) {
            Element contacts = doc.createElement(CurriculumVitaeElement.CONTACTS.toString());
            personalInformation.appendChild(contacts);
            for(Contact contact : cv.getContacts()) {
                List<Attribute> attributes = new ArrayList<Attribute>();
                if(!contact.getId().isEmpty() && !contact.getValue().isEmpty())
                    attributes.add(new Attribute(CurriculumVitaeAttribute.ID.toString(), contact.getId()));
                addChildElement(doc, contacts,
                        CurriculumVitaeElement.CONTACT.toString(), contact.getValue(), attributes);
            }
        }
    }

    /**
     * Appends DOM document with PersonalProfile
     * @param doc DOM document
     * @param pp Personal Profile
     */
    private void appendWithPersonalProfile(Document doc, PersonalProfile pp) {
        Node cvNode = doc.getDocumentElement();
        Element element = doc.createElement(CurriculumVitaeElement.PERSONAL_PROFILE.toString());
        Text text = doc.createTextNode(pp.getValue());
        element.appendChild(text);
        cvNode.appendChild(element);
    }

    /**
     * Appends DOM document with WorkExperience
     * @param doc DOM document
     * @param workExperience List of Works
     */
    private void appendWithWorkExperience(Document doc, List<Work> workExperience) {
        Node cvNode = doc.getDocumentElement();
        Element workExperienceElement = doc.createElement(CurriculumVitaeElement.WORK_EXPERIENCE.toString());
        for(Work work : workExperience) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            if(work.getFrom() != 0)
                attributes.add(new Attribute(CurriculumVitaeAttribute.FROM.toString(), String.valueOf(work.getFrom())));
            if(work.getTo() != 0)
                attributes.add(new Attribute(CurriculumVitaeAttribute.TO.toString(), String.valueOf(work.getTo())));
            if(work.getCompany() != null && !work.getCompany().isEmpty())
                attributes.add(new Attribute(CurriculumVitaeAttribute.COMPANY.toString(), work.getCompany()));
            if(work.getPosition() != null && !work.getPosition().isEmpty())
                attributes.add(new Attribute(CurriculumVitaeAttribute.POSITION.toString(), work.getPosition()));
            addChildElement(doc, workExperienceElement,
                    CurriculumVitaeElement.WORK_ITEM.toString(), work.getValue(), attributes);
        }
        cvNode.appendChild(workExperienceElement);
    }

    /**
     * Appends DOM document with Educations
     * @param doc DOM document
     * @param educations List of Educations
     */
    private void appendWithEducations(Document doc, List<Education> educations) {
        Node cvNode = doc.getDocumentElement();
        Element educationsElement = doc.createElement(CurriculumVitaeElement.EDUCATIONS.toString());
        for(Education education : educations) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            if(education.getFrom() != 0)
                attributes.add(new Attribute(
                        CurriculumVitaeAttribute.FROM.toString(), String.valueOf(education.getFrom())));
            if(education.getTo() != 0)
                attributes.add(new Attribute(
                        CurriculumVitaeAttribute.TO.toString(), String.valueOf(education.getTo())));
            if(education.getSchool() != null && !education.getSchool().isEmpty())
                attributes.add(new Attribute(
                        CurriculumVitaeAttribute.SCHOOL.toString(), education.getSchool()));
            addChildElement(doc, educationsElement,
                    CurriculumVitaeElement.EDUCATION_ITEM.toString(), education.getValue(), attributes);
        }
        cvNode.appendChild(educationsElement);
    }

    /**
     * Appends DOM document with Achievements
     * @param doc DOM document
     * @param achievements List of Achievements
     */
    private void appendWithAchievements(Document doc, List<Achievement> achievements) {
        Node cvNode = doc.getDocumentElement();
        Element achievementsElement = doc.createElement(CurriculumVitaeElement.ACHIEVEMENTS.toString());
        for(Achievement achievement : achievements) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            if(achievement.getYear() != 0)
                attributes.add(new Attribute(
                        CurriculumVitaeAttribute.YEAR.toString(), String.valueOf(achievement.getYear())));
            if(achievement.getTitle() != null && !achievement.getTitle().isEmpty())
                attributes.add(new Attribute(
                        CurriculumVitaeAttribute.TITLE.toString(), achievement.getTitle()));
            addChildElement(doc, achievementsElement,
                    CurriculumVitaeElement.ACHIEVEMENT_ITEM.toString(), achievement.getValue(), attributes);
        }
        cvNode.appendChild(achievementsElement);
    }

    /**
     * Appends DOM document with Languages
     * @param doc DOM document
     * @param languages List of Languages
     */
    private void appendWithLanguages(Document doc, List<Language> languages) {
        Node cvNode = doc.getDocumentElement();
        Element languagesElement = doc.createElement(CurriculumVitaeElement.LANGUAGES.toString());
        for(Language language : languages) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            if(language.getLang() != null && !language.getLang().isEmpty())
                attributes.add(new Attribute(
                        CurriculumVitaeAttribute.LANGUAGE.toString(), language.getLang()));
            if(language.getLevel() != null && !language.getLevel().isEmpty())
                attributes.add(new Attribute(
                        CurriculumVitaeAttribute.LEVEL.toString(), language.getLevel()));
            addChildElement(doc, languagesElement, CurriculumVitaeElement.LANGUAGE_ITEM.toString(), attributes);
        }
        cvNode.appendChild(languagesElement);
    }

    /**
     * Appends DOM document with Sills
     * @param doc DOM document
     * @param skills List of Skills
     */
    private void appendWithSkills(Document doc, List<Skill> skills) {
        Node cvNode = doc.getDocumentElement();
        Element skillsElement = doc.createElement(CurriculumVitaeElement.SKILLS.toString());
        for(Skill skill : skills) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            if(skill.getTitle() != null && !skill.getTitle().isEmpty())
                attributes.add(new Attribute(CurriculumVitaeAttribute.TITLE.toString(), skill.getTitle()));
            addChildElement(doc, skillsElement, CurriculumVitaeElement.SKILL_ITEM.toString(), attributes);
        }
        cvNode.appendChild(skillsElement);
    }

    /**
     * Appends DOM document with Hobbies
     * @param doc DOM document
     * @param hobbies List of Hobbies
     */
    private void appendWithHobbies(Document doc, List<Hobby> hobbies) {
        Node cvNode = doc.getDocumentElement();
        Element hobbiesElement = doc.createElement(CurriculumVitaeElement.HOBBIES.toString());
        for(Hobby hobby : hobbies) {
            List<Attribute> attributes = new ArrayList<Attribute>();
            if(hobby.getTitle() != null && !hobby.getTitle().isEmpty())
                attributes.add(new Attribute(CurriculumVitaeAttribute.TITLE.toString(), hobby.getTitle()));
            addChildElement(doc, hobbiesElement, CurriculumVitaeElement.HOBBY_ITEM.toString(), attributes);
        }
        cvNode.appendChild(hobbiesElement);
    }

    private void addChildElement(Document doc, Node parent, String child, String text) {
        addChildElement(doc, parent, child, text, null);
    }
    private void addChildElement(Document doc, Node parent, String child, List<Attribute> attributes) {
        addChildElement(doc, parent, child, null, attributes);
    }

    private void addChildElement(Document doc, Node parent, String child, String text, List<Attribute> attributes) {
        Element element = doc.createElement(child);
        if(attributes != null && !attributes.isEmpty())
            for(Attribute attribute : attributes)
                element.setAttribute(attribute.getKey(), attribute.getValue());
        if(text != null && !text.isEmpty())
            addText(doc, element, text);
        parent.appendChild(element);
    }

    private void addText(Document doc, Element element, String text) {
        Text elementText = doc.createTextNode(text);
        element.appendChild(elementText);
    }

    private class Attribute {
        private String key;
        private String value;

        public Attribute(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
