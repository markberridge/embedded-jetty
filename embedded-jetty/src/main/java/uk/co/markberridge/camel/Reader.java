package uk.co.markberridge.camel;

import org.apache.log4j.Logger;

public class Reader {

    private static Logger log = Logger.getLogger(Reader.class);

    public void read(String body) {
        log.info("--------------------------------------------------------------------------------");
        log.info("--------------------- Received file in inbox with content: ---------------------\n" + body);
        log.info("--------------------------------------------------------------------------------");
    }
}
