package com.epam.ld.module2.testing;

/**
 * Mail server class.
 */
public class MailServer {

    private mode workMode;
    public enum mode {
        CONSOLE,
        FILE
    }

    public MailServer(mode workMode) {
        this.workMode = workMode;
    }

    /**
     * Send notification.
     *
     * @param addresses  the addresses
     * @param messageContent the message content
     */
    public void send(String addresses, String messageContent) {
        switch (workMode){
            case FILE:
                //File Handling
                break;
            case CONSOLE:
                //log on console
                break;
        }
    }
}
