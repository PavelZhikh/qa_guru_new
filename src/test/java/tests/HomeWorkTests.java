package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
//import net.datafaker.Faker;

import static tests.TestData.*;

public class HomeWorkTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFillFormTest() {
//        Faker faker = new Faker();
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//        String email = faker.internet().emailAddress();
//
//        //String firstName = "Petr";
//        //String lastName = "Ivanov";
//        //String email = "petrIvanov@mail.ru";
//        String gender = "Male";
//        String phoneNumber = "0123456789";
//        String birthMonth = "May";
//        String birthYear = "1990";
//        String day = "10";
//        String subject = "Arts";
//        String hobby = "Music";
//        String file = "barselona-messi.jpg";
//        String address = "New current address";
//        String state = "Haryana";
//        String city = "Karnal";
//        String modalHeader = "Thanks for submitting the form";

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
                .checkPage("Date of Birth", "10 May,1990")
                .checkPage("Subjects", subject)
                .checkPage("Hobbies", hobby)
                .checkPage("Picture", file)
                .checkPage("Address", address)
                .checkPage("State and City", state + " " + city);
    }
}