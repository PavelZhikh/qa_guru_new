package tests;

import org.junit.jupiter.api.Test;

public class CheckingPropertyTest {
    @Test
    void propertyTest() {
        String environment = System.getProperty("environment");

        System.out.println("Test environment is: " + environment);
    }
}
