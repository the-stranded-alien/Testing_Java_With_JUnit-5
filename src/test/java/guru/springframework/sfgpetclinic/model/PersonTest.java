package guru.springframework.sfgpetclinic.model;

import guru.springframework.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertion() {
        // Given
        Person person = new Person(1l, "Joe", "Buck");
        // Then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName()));
    }

    @Test
    void groupedAssertionMessages() {
        // Given
        Person person = new Person(1l, "Joe", "Buck");
        // Then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName(), "First Name Failed"),
                () -> assertEquals("Buck", person.getLastName(), "Last Name Failed"));
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {
        // todo - impl
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
    }
}