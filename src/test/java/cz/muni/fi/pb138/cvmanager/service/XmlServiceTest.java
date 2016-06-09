package cz.muni.fi.pb138.cvmanager.service;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import cz.muni.fi.pb138.cvmanager.entity.CurriculumVitae;
import cz.muni.fi.pb138.cvmanager.enumeration.CurriculumVitaeAttribute;
import cz.muni.fi.pb138.cvmanager.enumeration.CurriculumVitaeElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import cz.muni.fi.pb138.cvmanager.TestEntityFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by nfabian on 6.6.16.
 */
@RunWith(DataProviderRunner.class)
public class XmlServiceTest {

    XmlService xmlService;

    @Before
    public void initialize() {
        xmlService = new XmlService();
    }

    @Test
    public void loadFromXmlTest()
            throws IOException, SAXException, ParserConfigurationException {
        CurriculumVitae cv = xmlService.loadFromXml("test");
        Assert.assertEquals("Cv name loading is wrong.",
                "FullName", cv.getFullName());
        Assert.assertEquals("Cv address loading is wrong.",
                "Address", cv.getAddress());
        Assert.assertEquals("Cv birthday loading is wrong",
                "1.1.1960", cv.getBirthday());
        Assert.assertEquals("Cv contacts amount is wrong",
                2, cv.getContacts().size());
        Assert.assertEquals("Cv first contact id is wrong",
                "Tel", cv.getContacts().get(0).getId());
        Assert.assertEquals("Cv first contact value is wrong",
                "111 222 333", cv.getContacts().get(0).getValue());
        Assert.assertEquals("Cv first contact id is wrong",
                "Email", cv.getContacts().get(1).getId());
        Assert.assertEquals("Cv first contact value is wrong",
                "email@centrum.sk", cv.getContacts().get(1).getValue());
        Assert.assertEquals("Cv work experiences amount is wrong",
                2, cv.getWorkExperience().size());
        Assert.assertEquals("Cv work experience company is wrong",
                "Ceske tehliarne", cv.getWorkExperience().get(0).getCompany());
    }

    @Test
    public void removeXmlTest() throws IOException {
        String fileName = "fileToRemove";
        File xmlFile = new File("cvxml/fileToRemove_cv.xml");
        xmlFile.createNewFile();
        Assert.assertTrue("File hasn't been created", xmlFile.exists());
        xmlService.removeXml(fileName);
        Assert.assertFalse("File hasn't been removed", xmlFile.exists());
    }

    @DataProvider
    public static Object[][] curriculumVitaeData() {
        return new Object[][] {
                {TestEntityFactory.createCurriculumVitae(),
                        CurriculumVitaeElement.PERSONAL_INFORMATION},
                {TestEntityFactory.createCurriculumVitaeOnlyPersonalInformation(),
                        CurriculumVitaeElement.PERSONAL_INFORMATION},
                {TestEntityFactory.createCurriculumVitaeWithAchievements(),
                        CurriculumVitaeElement.ACHIEVEMENT_ITEM},
                {TestEntityFactory.createCurriculumVitaeWithContact(),
                        CurriculumVitaeElement.CONTACT},
                {TestEntityFactory.createCurriculumVitaeWithEducation(),
                        CurriculumVitaeElement.EDUCATION_ITEM},
                {TestEntityFactory.createCurriculumVitaeWithHobbies(),
                        CurriculumVitaeElement.HOBBY_ITEM},
                {TestEntityFactory.createCurriculumVitaeWithLanguages(),
                        CurriculumVitaeElement.LANGUAGE_ITEM},
                {TestEntityFactory.createCurriculumVitaeWithSkills(),
                        CurriculumVitaeElement.SKILL_ITEM},
                {TestEntityFactory.createCurriculumVitaeWithWork(),
                        CurriculumVitaeElement.WORK_ITEM}
        };
    }

    @Test
    @UseDataProvider("curriculumVitaeData")
    public void createDocumentTest(CurriculumVitae cv, CurriculumVitaeElement element)
            throws ParserConfigurationException {;
        Document document = xmlService.createDocument(cv);
        Assert.assertNotEquals("Dom document is null", null, document);
        Assert.assertNotEquals("Element is null: " + element.toString(), "",
                    document.getElementsByTagName(element.toString()));
    }

    @Test
    @UseDataProvider("curriculumVitaeData")
    public void serializeToXmlTest(CurriculumVitae cv, CurriculumVitaeElement element)
            throws IOException, TransformerException, ParserConfigurationException, SAXException {
        xmlService.serializeToXml("TestUsername", cv);
        File testFile = new File("cvxml/TestUsername_cv.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        dBuilder.parse(testFile);
        testFile.delete();
    }

    @DataProvider
    public static Object[][] curriculumVitaeAttributeData() {
        return new Object[][] {
                {CurriculumVitaeElement.CONTACT, CurriculumVitaeAttribute.ID},
                {CurriculumVitaeElement.WORK_ITEM, CurriculumVitaeAttribute.FROM},
                {CurriculumVitaeElement.WORK_ITEM, CurriculumVitaeAttribute.TO},
                {CurriculumVitaeElement.WORK_ITEM, CurriculumVitaeAttribute.COMPANY},
                {CurriculumVitaeElement.WORK_ITEM, CurriculumVitaeAttribute.POSITION},
                {CurriculumVitaeElement.EDUCATION_ITEM, CurriculumVitaeAttribute.FROM},
                {CurriculumVitaeElement.EDUCATION_ITEM, CurriculumVitaeAttribute.TO},
                {CurriculumVitaeElement.EDUCATION_ITEM, CurriculumVitaeAttribute.SCHOOL},
                {CurriculumVitaeElement.ACHIEVEMENT_ITEM, CurriculumVitaeAttribute.YEAR},
                {CurriculumVitaeElement.ACHIEVEMENT_ITEM, CurriculumVitaeAttribute.TITLE},
                {CurriculumVitaeElement.LANGUAGE_ITEM, CurriculumVitaeAttribute.LANGUAGE},
                {CurriculumVitaeElement.LANGUAGE_ITEM, CurriculumVitaeAttribute.LEVEL},
                {CurriculumVitaeElement.SKILL_ITEM, CurriculumVitaeAttribute.TITLE}
        };
    }

    @Test
    @UseDataProvider("curriculumVitaeAttributeData")
    public void createDocumentAttributesTest(CurriculumVitaeElement element,
                                             CurriculumVitaeAttribute attribute)
            throws ParserConfigurationException {;
        Document document = xmlService.createDocument(TestEntityFactory.createCurriculumVitae());
        Assert.assertNotEquals("Dom document is null", null, document);
        Assert.assertNotEquals("Attribute is null: " + attribute.toString(), "",
                document.getElementsByTagName(element.toString()).item(0)
                        .getAttributes().getNamedItem(attribute.toString()));
    }

}
