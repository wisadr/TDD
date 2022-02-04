package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemplateEngineTest {

    public static final String TEST_ADDRESS = "Test Address";
    public static final String TEST_TEXT_WITHOUT_TAGS = "Test text";
    public static final String TEST_TEXT_WITH_TAGS = "Test #TAG#";
    public static final String TEST_TEXT_AFTER_REPLACE = "Test Hello";

    TemplateEngine templateEngine;
    Template template;
    Client client;

    @BeforeEach
    public void setUp() {
        templateEngine = new TemplateEngine();
        client = new Client();
        client.setAddresses(TEST_ADDRESS);
    }

    @Test
    public void generateMessageTestWithoutTags() {
        template = new Template(TEST_TEXT_WITHOUT_TAGS);
        String message = templateEngine.generateMessage(template, client);
        assertEquals(TEST_TEXT_WITHOUT_TAGS + "\n" + TEST_ADDRESS, message);
    }

    @Test
    public void generateMessageTestWithTagsforChange() {
        template = new Template(TEST_TEXT_WITH_TAGS);
        String message = templateEngine.generateMessage(template, client);
        assertEquals(TEST_TEXT_AFTER_REPLACE + "\n" + TEST_ADDRESS, message);
    }

    @Test
    public void placeholderValueNotProvidedException(){
        template = new Template(TEST_TEXT_WITH_TAGS);
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> templateEngine.generateMessage(template, client));
    }
}
