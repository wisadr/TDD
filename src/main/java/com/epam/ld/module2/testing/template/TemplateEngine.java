package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param client   the client
     * @return the string
     */
    public String generateMessage(Template template, Client client) {
        return replaceTags(template.getText() + "\n" + client.getAddresses());
    }

    public static String replaceTags(String message) {
        Pattern p = Pattern.compile("(#.*#)");
        Matcher m = p.matcher(message);
        boolean result = m.find();
        if (result) {
            message = m.replaceAll("Hello");
        }
        return message;
    }
}
