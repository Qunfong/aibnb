package com.bnb.ai;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class BaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    protected void logMessage(String message) {
        LOGGER.info(message);
    }
}
