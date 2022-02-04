package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import java.util.Optional;
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

    private static String replaceTags(String message) {
        Pattern p = Pattern.compile("(#.*#)");
        Matcher m = p.matcher(message);
        int i = 1;
        if (m.find()) {
            Optional<String> property =
                    Optional.ofNullable(System.getProperty(m.group(i++).substring(1, m.group().length() - 1)));
            if (property.isPresent()) {
            } else {
                throw new IllegalArgumentException();
            }
            message = m.replaceAll("Hello");
        }
        return message;
    }
}
