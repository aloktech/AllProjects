/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;

/**
 *
 * @author Pintu
 */
@Getter
@Setter
@Builder
public class LogService {

    private String infoMsg;
    private String errorMsg;
    private String warningMsg;
    private Logger logger;
    private LogType logType;
    private EventType eventType;
    private List<Object> parameters;

    public void execute() {
        parameters.add(0, eventType.getName());
        switch (logType) {
            case INFO:
                logger.info(MessageFormat.format(infoMsg, parameters.toArray(new Object[0])));
                break;
            case WARNING:
                logger.warn(MessageFormat.format(warningMsg, parameters.toArray(new Object[0])));
                break;
            case ERROR:
                logger.error(MessageFormat.format(errorMsg, parameters.toArray(new Object[0])));
                break;
            case NONE:
            default:
                throw new AssertionError(logType.name());
        }
    }

    public static class LogServiceBuilder {

        private String infoMsg = "{0}";
        private String errorMsg = "{0} {1}";
        private String warningMsg = "{0}";
        private Logger logger;
        private LogType logType = LogType.NONE;
        private EventType eventType = EventType.NONE;
        private List<Object> parameters = new ArrayList<>();

        public LogServiceBuilder() {
        }
    }
}
