package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class HomeWorkTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void successfulFillFormTest() {

        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeEmail(testData.email)
                .setGender(testData.gender)
                .typeNumber(testData.phoneNumber)
                .setDateOfBirth(testData.day, testData.birthMonth, testData.birthYear)
                .setSubjectsInput(testData.subject)
                .setHobby(testData.hobby)
                .uploadPicture(testData.file)
                .setCurrentAddressInput(testData.address)
                .setStateAndCity(testData.state, testData.city)
                .submitPage()
                .checkPage(modalHeader)
                .checkPage("Student Name", testData.firstName + " " + testData.lastName)
                .checkPage("Student Email", testData.email)
                .checkPage("Gender", testData.gender)
                .checkPage("Mobile", testData.phoneNumber)
                .checkPage("Date of Birth", testData.day + " " + testData.birthMonth + "," + testData.birthYear)
                .checkPage("Subjects", testData.subject)
                .checkPage("Hobbies", testData.hobby)
                .checkPage("Picture", testData.file)
                .checkPage("Address", testData.address)
                .checkPage("State and City", testData.state + " " + testData.city);
    }
}