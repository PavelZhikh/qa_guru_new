package tests;

import net.datafaker.Faker;

public class TestData {
    public static String
            firstName,
            lastName,
            email,
            gender,
            phoneNumber,
            birthMonth,
            birthYear,
            day,
            subject,
            hobby,
            file,
            address,
            state,
            city,
            modalHeader;
    public static void generateTestDate() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();

        //String firstName = "Petr";
        //String lastName = "Ivanov";
        //String email = "petrIvanov@mail.ru";
        String gender = "Male";
        String phoneNumber = "0123456789";
        String birthMonth = "May";
        String birthYear = "1990";
        String day = "10";
        String subject = "Arts";
        String hobby = "Music";
        String file = "barselona-messi.jpg";
        String address = "New current address";
        String state = "Haryana";
        String city = "Karnal";
        String modalHeader = "Thanks for submitting the form";
    }
}

//МОЕ СТАРОЕ
//package tests;
//
//public class TestData {
//    public static String firstName = "Petr";
//    public static String lastName = "Ivanov";
//    public static String email = "petrIvanov@mail.ru";
//    public static String gender = "Male";
//    public static String phoneNumber = "0123456789";
//    public static String birthMonth = "May";
//    public static String birthYear = "1990";
//    public static String day = "10";
//    public static String subject = "Arts";
//    public static String hobby = "Music";
//    public static String file = "barselona-messi.jpg";
//    public static String address = "New current address";
//    public static String state = "Haryana";
//    public static String city = "Karnal";
//    public static String modalHeader = "Thanks for submitting the form";
//}

//МОЕ НОВОЕ
//package tests;
//
//import net.datafaker.Faker;
//
//public class TestData {
//    public static String
//            firstName,
//            lastName,
//            email,
//            gender,
//            phoneNumber,
//            birthMonth,
//            birthYear,
//            day,
//            subject,
//            hobby,
//            file,
//            address,
//            state,
//            city,
//            modalHeader;
//    public static void generateTestDate() {
//        Faker faker = new Faker();
////        firstName = faker.name().firstName();
//        firstName = "Oleg";
//        lastName = "Ivanov";
//        email = "petrIvanov@mail.ru";
//        gender = "Male";
//        phoneNumber = "0123456789";
//        birthMonth = "May";
//        birthYear = "1990";
//        day = "10";
//        subject = "Arts";
//        hobby = "Music";
//        file = "barselona-messi.jpg";
//        address = "New current address";
//        state = "Haryana";
//        city = "Karnal";
//        modalHeader = "Thanks for submitting the form";
//    }
//}

//ПРИМЕР
//package tests;
//
//import net.datafaker.Faker;
//
//import java.io.File;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Locale;
//
//public class TestData {
//    public static String
//            firstName,
//            lastName,
//            email,
//            gender,
//            phoneNumber,
//            birthYear,
//            birthMonth,
//            day,
//            subject,
//            hobby,
//            file,
//            address,
//            state,
//            city;
//    public static String modalHeader = "Thanks for submitting the form";
//    public static LocalDate birthDate;
//
//    public static void prepareTestDate() {
//        Faker faker = new Faker();
//        firstName = faker.name().firstName();
//        lastName = faker.name().lastName();
//        email = faker.internet().emailAddress();
//        gender = faker.options().option("Male", "Female", "Other");
//        phoneNumber = faker.number().digits(10); // 10-значный номер
//        // Генерация даты рождения (человек от 18 до 65 лет)
//        birthDate = faker.timeAndDate().birthday(18, 65);
//        birthYear = String.valueOf(birthDate.getYear());
//        birthMonth = birthDate.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH));
//        day = birthDate.format(DateTimeFormatter.ofPattern("dd"));
//        // Образование и хобби
//        subject = faker.options().option("Maths", "Physics", "Chemistry", "Social Studies", "English");
//        hobby = faker.options().option("Sports", "Reading", "Music");
//        //Картинка из папки Ресурсы-файлы
//        File folder = new File("src/test/resources/files");
//        File[] files = folder.listFiles();
//        if (files != null && files.length > 0) {
//            File randomFile = faker.options().nextElement(files);
//            file = "files/" + randomFile.getName();
//        }
//        address = faker.address().fullAddress();
//        //штат и город связаны
//        // StateAndCity stateAndCity = faker.options().nextElement(StateAndCity.values());
//        state = faker.options().option("Haryana");
//        city = faker.options().option("Karnal");
//    }
//}