package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class HomeWorkTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFillFormTest() {

        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .setGender(gender)
                .typeNumber(phoneNumber)
                .setDateOfBirth(day, birthMonth, birthYear)
                .setSubjectsInput(subject)
                .setHobby(hobby)
                .uploadPicture(file)
                .setCurrentAddressInput(address)
                .setStateAndCity(state, city)
                .submitPage()
                .checkPage(modalHeader)
                .checkPage("Student Name", firstName + " " + lastName)
                .checkPage("Student Email", email)
                .checkPage("Gender", gender)
                .checkPage("Mobile", phoneNumber)
                .checkPage("Date of Birth", day + " " + birthMonth + "," + birthYear)
                .checkPage("Subjects", subject)
                .checkPage("Hobbies", hobby)
                .checkPage("Picture", file)
                .checkPage("Address", address)
                .checkPage("State and City", state + " " + city);
    }
}