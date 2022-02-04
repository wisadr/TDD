package com.epam.ld.module2.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MailServerTest {
    @TempDir
    File tempDir;

    MailServer consoleMailServer = new MailServer(MailServer.mode.CONSOLE);
    MailServer fileMailServer = new MailServer(MailServer.mode.FILE);
    String messageContent = new String("Hello from test");
    String adresses = new String("to Adrian");



    @Test
    public void sendingInConsoleMode() {
        consoleMailServer.send(adresses,messageContent);
    }

    @Test
    public void sendingInFileMode() throws IOException {
        assertTrue(this.tempDir.isDirectory());

        File letters = new File(tempDir, "letters.txt");
        List<String> lines = Arrays.asList("x", "y", "z");

        Files.write(letters.toPath(), lines);
        assertTrue(Files.exists(letters.toPath()));

        fileMailServer.send(adresses,messageContent);
    }


}
