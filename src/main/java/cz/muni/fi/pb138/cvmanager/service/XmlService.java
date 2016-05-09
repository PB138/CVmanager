package cz.muni.fi.pb138.cvmanager.service;

import cz.muni.fi.pb138.cvmanager.entity.*;
import cz.muni.fi.pb138.cvmanager.enumeration.CurriculumVitaeAttribute;
import cz.muni.fi.pb138.cvmanager.enumeration.CurriculumVitaeElement;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.w3c.dom.*;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

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
     * Loads curriculum vitae of the user from the XML file
     * @param username User's name
     * @return Curriculum vitae
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public CurriculumVitae loadFromXml(String username) throws ParserConfigurationException,
            IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(createFile(username));
        CurriculumVitae cv = new CurriculumVitae();
        cv.setFullName(loadContent(doc, CurriculumVitaeElement.FULL_NAME.toString()));
        cv.setAddress(loadContent(doc, CurriculumVitaeElement.ADDRESS.toString()));
        cv.setBirthday(loadContent(doc, CurriculumVitaeElement.BIRTHDAY.toString()));
        cv.setContacts(loadContacts(doc));
        cv.setPersonalProfile(loadContent(doc, CurriculumVitaeElement.PERSONAL_PROFILE.toString()));
        cv.setWorkExperience(loadWorkExperiences(doc));
        cv.setEducations(loadEducations(doc));
        cv.setAchievements(loadAchievements(doc));
        cv.setLanguages(loadLanguages(doc));
        cv.setSkills(loadSkills(doc));
        cv.setHobbies(loadHobbies(doc));
        return cv;
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
    
    //udělal jsem tuto metodu public, protože ji potřebuji i ve svých třídách
    /**
     * Creates DOM document of the curriculum vitae
     * @param cv Curriculum vitae
     * @return DOM document
     * @throws ParserConfigurationException
     */
    public Document createDocument(CurriculumVitae cv) throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        DOMImplementation impl = builder.getDOMImplementation();
        Document doc = impl.createDocument(null, CurriculumVitaeElement.CURRICULUM_VITAE.toString(), null);
        appendWithPersonalInformation(doc, cv);
        if(cv.getPersonalProfile() != null)
            appendWithPersonalProfile(doc, cv);
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

    //***************************************************************************
    //************************* Load XML private methods ************************
    //***************************************************************************

    /**
     * Returns Contacts from the DOM document as List
     * @param doc DOM document
     * @return List of Contacts
     */
    private List<Contact> loadContacts(Document doc) {
        NodeList nodeList = doc.getElementsByTagName(CurriculumVitaeElement.CONTACT.toString());
        List<Contact> contacts = new ArrayList<Contact>();
        Element element;
        for (int item = 0; item < nodeList.getLength(); item++) {
            Contact contact = new Contact();
            element = (Element) nodeList.item(item);
            contact.setValue(element.getTextContent());
            contact.setId(element.getAttribute(CurriculumVitaeAttribute.ID.toString()));
            contacts.add(contact);
        }
        return contacts;
    }

    /**
     * Returns WorkExperiences from the DOM document as List
     * @param doc DOM document
     * @return List of Works
     */
    private List<Work> loadWorkExperiences(Document doc) {
        NodeList nodeList = doc.getElementsByTagName(CurriculumVitaeElement.WORK_ITEM.toString());
        List<Work> works = new ArrayList<Work>();
        Element element;
        int tempInt;
        for (int item = 0; item < nodeList.getLength(); item++) {
            Work work = new Work();
            element = (Element) nodeList.item(item);
            work.setValue(element.getTextContent());
            tempInt = toIntOrDefault(element.getAttribute(CurriculumVitaeAttribute.FROM.toString()));
            if (tempInt != Integer.MIN_VALUE)
                work.setFrom(tempInt);
            tempInt = toIntOrDefault(element.getAttribute(CurriculumVitaeAttribute.TO.toString()));
            if (tempInt != Integer.MIN_VALUE)
                work.setTo(tempInt);
            work.setCompany(element.getAttribute(CurriculumVitaeAttribute.COMPANY.toString()));
            work.setPosition(element.getAttribute(CurriculumVitaeAttribute.POSITION.toString()));
            works.add(work);
        }
        return works;
    }

    /**
     * Returns Educations from the DOM document as List
     * @param doc DOM document
     * @return List of Educations
     */
    private List<Education> loadEducations(Document doc) {
        NodeList nodeList = doc.getElementsByTagName(CurriculumVitaeElement.EDUCATION_ITEM.toString());
        List<Education> educations = new ArrayList<Education>();
        Element element;
        int tempInt;
        for (int item = 0; item < nodeList.getLength(); item++) {
            Education education = new Education();
            element = (Element) nodeList.item(item);
            education.setValue(element.getTextContent());
            tempInt = toIntOrDefault(element.getAttribute(CurriculumVitaeAttribute.FROM.toString()));
            if (tempInt != Integer.MIN_VALUE)
                education.setFrom(tempInt);
            tempInt = toIntOrDefault(element.getAttribute(CurriculumVitaeAttribute.TO.toString()));
            if (tempInt != Integer.MIN_VALUE)
                education.setTo(tempInt);
            education.setSchool(element.getAttribute(CurriculumVitaeAttribute.SCHOOL.toString()));
            educations.add(education);
        }
        return educations;
    }

    /**
     * Returns Achievements from the DOM document as List
     * @param doc DOM document
     * @return List of Achievements
     */
    private List<Achievement> loadAchievements(Document doc) {
        NodeList nodeList = doc.getElementsByTagName(CurriculumVitaeElement.ACHIEVEMENT_ITEM.toString());
        List<Achievement> achievements = new ArrayList<Achievement>();
        Element element;
        int tempInt;
        for (int item = 0; item < nodeList.getLength(); item++) {
            Achievement achievement = new Achievement();
            element = (Element) nodeList.item(item);
            achievement.setValue(element.getTextContent());
            tempInt = toIntOrDefault(element.getAttribute(CurriculumVitaeAttribute.YEAR.toString()));
            if (tempInt != Integer.MIN_VALUE)
                achievement.setYear(tempInt);
            achievement.setTitle(element.getAttribute(CurriculumVitaeAttribute.TITLE.toString()));
            achievements.add(achievement);
        }
        return achievements;
    }

    /**
     * Returns Languages from the DOM document as List
     * @param doc DOM document
     * @return List of Languages
     */
    private List<Language> loadLanguages(Document doc) {
        NodeList nodeList = doc.getElementsByTagName(CurriculumVitaeElement.LANGUAGE_ITEM.toString());
        List<Language> languages = new ArrayList<Language>();
        Element element;
        for (int item = 0; item < nodeList.getLength(); item++) {
            Language language = new Language();
            element = (Element) nodeList.item(item);
            language.setLang(element.getAttribute(CurriculumVitaeAttribute.LANGUAGE.toString()));
            language.setLevel(element.getAttribute(CurriculumVitaeAttribute.LEVEL.toString()));
            languages.add(language);
        }
        return languages;
    }

    /**
     * Returns Skills from DOM document as List
     * @param doc DOM document
     * @return List of Skills
     */
    private List<Skill> loadSkills(Document doc) {
        NodeList nodeList = doc.getElementsByTagName(CurriculumVitaeElement.SKILL_ITEM.toString());
        List<Skill> skills = new ArrayList<Skill>();
        Element element;
        for (int item = 0; item < nodeList.getLength(); item++) {
            Skill skill = new Skill();
            element = (Element) nodeList.item(item);
            skill.setValue(element.getTextContent());
            skill.setTitle(element.getAttribute(CurriculumVitaeAttribute.TITLE.toString()));
            skills.add(skill);
        }
        return skills;
    }

    /**
     * Returns Hobbies from DOM document as List
     * @param doc DOM document
     * @return List of Hobbies
     */
    private List<Hobby> loadHobbies(Document doc) {
        NodeList nodeList = doc.getElementsByTagName(CurriculumVitaeElement.HOBBY_ITEM.toString());
        List<Hobby> hobbies = new ArrayList<Hobby>();
        Element element;
        for (int item = 0; item < nodeList.getLength(); item++) {
            Hobby hobby = new Hobby();
            element = (Element) nodeList.item(item);
            hobby.setValue(element.getTextContent());
            hobby.setTitle(element.getAttribute(CurriculumVitaeAttribute.TITLE.toString()));
            hobbies.add(hobby);
        }
        return hobbies;
    }

    /**
     * Returns the content of the element with the specified name as String. If more elements with the specified
     * name has been found the content of the first element will be returned. If no element with the specified name
     * has been found null will be returned
     * @param doc DOM document
     * @param elementName Element name
     * @return Element content as String or null
     */
    private String loadContent(Document doc, String elementName) {
        NodeList nodeList = doc.getElementsByTagName(elementName);
        List<String> contents = new ArrayList<String>();
        Element element;
        element = (Element) nodeList.item(0);
        contents.add(element.getTextContent());
        return !contents.isEmpty() ? contents.get(0).trim() : null;
    }

    //***************************************************************************
    //*********************** Creating XML private methods **********************
    //***************************************************************************

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
     * @param cv Curriculum Vitae
     */
    private void appendWithPersonalProfile(Document doc, CurriculumVitae cv) {
        Node cvNode = doc.getDocumentElement();
        Element element = doc.createElement(CurriculumVitaeElement.PERSONAL_PROFILE.toString());
        Text text = doc.createTextNode(cv.getPersonalProfile());
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

    private int toIntOrDefault(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE;
        }
    }

    //*******************************************************************
    //************************** Base methods ***************************
    //*******************************************************************

    private String createXmlPath(String username) {
        return XML_CV_FOLDER + "/" + username + "_cv.xml";
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
