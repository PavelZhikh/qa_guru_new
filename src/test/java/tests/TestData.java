package tests;
import net.datafaker.Faker;

public class TestData {
    Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String birthYear = String.format(String.valueOf(faker.number().numberBetween(1900,2100)));
    public String birthMonth = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    public String day = String.format("%02d", faker.number().numberBetween(1,28));
    public String subject = faker.options().option("Math", "Arts", "Accounting", "Social Studies");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String file = faker.options().option("real-ronaldo.jpg", "barselona-messi.jpg");
    public String address = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = chooseCityBasedOnState();
    public static String modalHeader = "Thanks for submitting the form";

    public String chooseCityBasedOnState() {
        String city = selectCity(state);

        return city;
        }

    public String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}