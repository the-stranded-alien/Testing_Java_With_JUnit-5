package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController indexController;
    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(),  "Wrong view returned");
        assertEquals("index", indexController.index(),  () -> "Another expensive message" +
                "Make me only if you need me");

    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()), () -> "This is some expensive"
        + "Message to build"
        + "For my test");
    }
}