package com.cs505.group.main.util;

import devillogs.logging.ConsoleHandler;
import devillogs.logging.Level;
import devillogs.logging.LogRecord;
import devillogs.logging.Logger;

/**
 * author: Maurice Johnson
 *
 * This is a utility class that contains one
 * static method that utilizes the Devil Logs API
 *
 */
public class LoggerUtil {

    private static LogRecord.LogRecordBuilder lrb = LogRecord.builder().withLevel(Level.INFO);
    private static Logger logger = Logger.getInstance();
    private static ConsoleHandler consoleHandler = new ConsoleHandler();
    private static boolean handlerAdded = false;

    /**
     * static method that logs the passed in string to the console
     * @param str
     */
    public static void log(String str){
        if (handlerAdded == false){
            logger.addHandler(consoleHandler);
            handlerAdded = true;
        }
        logger.log(lrb.withMessage(str+"\n").build());
    }
}
