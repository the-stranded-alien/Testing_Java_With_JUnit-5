package guru.springframework.sfgpetclinic.model;

import guru.springframework.CustomArgsProvider;
import guru.springframework.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                            () -> assertEquals("Joe", owner.getFirstName(), "First Name didn't match"),
                            () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City didn't match"),
                        () -> assertEquals("1231231234", owner.getTelephone())
                ));

        assertThat(owner.getCity(), is("Key West"));
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Test"})
    void valueSource(String value) {
        System.out.println(value);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "NY, 1, 3"
    })
    void csvInputTest(String stateName, int value1, int value2) {
        System.out.println(stateName + " = " + value1 + " : " + value2);
    }

    @DisplayName("CSV From File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int value1, int value2) {
        System.out.println(stateName + " = " + value1 + " : " + value2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int value1, int value2) {
        System.out.println(stateName + " = " + value1 + " : " + value2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("FL", 1, 8),
                Arguments.of("OH", 2, 7),
                Arguments.of("NY", 3, 9)
        );
    }

    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String stateName, int value1, int value2) {
        System.out.println(stateName + " = " + value1 + " : " + value2);
    }
}