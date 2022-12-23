package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("controllers")
class IndexControllerTest {

    IndexController indexController;
    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test Proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(),  "Wrong view returned");
        assertEquals("index", indexController.index(),  () -> "Another expensive message" +
                "Make me only if you need me");

        assertThat(indexController.index()).isEqualTo("index");

    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
           indexController.oopsHandler();
        });
    }

    @Disabled("Demo of Time Out")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here!");
        });
    }

    @Disabled("Demo of Time Out")
    @Test
    void testTimeOutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here! (Preempt)"); // Won't get here
        });
    }

    @Disabled
    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_STRING")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "sahilgupta")
    @Test
    void testIfUserSG() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "x")
    @Test
    void testIfUserX() {

    }
}