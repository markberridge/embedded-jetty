package uk.co.markberridge.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PrinterServiceImpl implements PrinterService {

    private static Logger log = Logger.getLogger(PrinterServiceImpl.class);

    @Override
    public void printMessage() {
        printMessage("Hello World! (service)");
    }

    @Override
    public void printMessage(String message) {
        log.info(message);
    }
}
