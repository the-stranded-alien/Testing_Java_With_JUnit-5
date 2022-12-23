package guru.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;


@Tag("models")
public interface ModelTests {

    @BeforeEach
    default void beforeEachConsoleOutput(TestInfo testInfo) {
        System.out.println("Running Tests - " + testInfo.getDisplayName());
    }

}
