package guru.springframework.sfgpetclinic.model;

import guru.springframework.ModelTests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"Spring", "Framework", "Test"})
    void valueSource(String value) {
        System.out.println(value);
    }
}