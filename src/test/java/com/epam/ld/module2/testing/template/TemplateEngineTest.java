package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class TemplateEngineTest {

    TemplateEngine templateEngine;
    Template template;
    Client client;

    @BeforeEach
    public void setUp() {
        templateEngine = mock(TemplateEngine.class);
        template = mock(Template.class);
        client = mock(Client.class);
    }

    @Test
    public void generateMessageTest() {
        String message = templateEngine.generateMessage(template, client);
        assertNull(message);
    }
}
