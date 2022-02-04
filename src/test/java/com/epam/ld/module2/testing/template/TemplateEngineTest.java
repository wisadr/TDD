package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateEngineTest {

    public static final String TEST_ADDRESS = "Test Address";
    public static final String TEST_TEXT = "Test text";
    TemplateEngine templateEngine;
    Template template;
    Client client;

    @BeforeEach
    public void setUp() {
        templateEngine = new TemplateEngine();
        template = new Template(TEST_TEXT);
        client = new Client();
        client.setAddresses(TEST_ADDRESS);
    }

    @Test
    public void generateMessageTest() {
        String message = templateEngine.generateMessage(template, client);
        assertEquals(TEST_TEXT + "\n" + TEST_ADDRESS, message);
    }
}
