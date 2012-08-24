package uk.co.markberridge.camel;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ReaderImpl implements Reader {

    private static Logger log = Logger.getLogger(ReaderImpl.class);

    public void read(String body) {
        log.info("--------------------------------------------------------------------------------");
        log.info("--------------------- Received file in inbox with content: ---------------------\n" + body);
        log.info("--------------------------------------------------------------------------------");
    }
}
