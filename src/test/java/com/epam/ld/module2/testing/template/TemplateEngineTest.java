package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class TemplateEngineTest {

    private static final String TEST_ADDRESS = "Test Address";
    private static final String TEST_TEXT_WITH_TAGS = "Test #TAG#";
    private static final String TEST_TEXT_AFTER_REPLACE = "Test Hello";

    @Spy
    TemplateEngine templateEngineSpy;

    TemplateEngine templateEngine;
    Template template;
    Client client;

    @BeforeEach
    public void setUp() {
        templateEngine = new TemplateEngine();
        client = new Client();
        client.setAddresses(TEST_ADDRESS);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Testowo", "Hello world", "no tag here, sadly"})
    public void generateMessageTestWithoutTags(String input) {
        template = new Template(input);
        String message = templateEngine.generateMessage(template, client);
        assertEquals(input + "\n" + TEST_ADDRESS, message);
    }

    @Test
    public void generateMessageTestWithTagsforChange() {
        template = new Template(TEST_TEXT_WITH_TAGS);

        templateEngineSpy = spy(new TemplateEngine());
        doReturn(TEST_TEXT_AFTER_REPLACE + "\n" + TEST_ADDRESS).when(templateEngineSpy).generateMessage(any(),any());
        String message = templateEngineSpy.generateMessage(template, client);
        assertEquals(TEST_TEXT_AFTER_REPLACE + "\n" + TEST_ADDRESS, message);
    }

    @Test
    public void placeholderValueNotProvidedException() {
        template = new Template(TEST_TEXT_WITH_TAGS);
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> templateEngine.generateMessage(template, client));
    }
}
