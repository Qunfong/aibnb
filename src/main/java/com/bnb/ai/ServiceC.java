package com.bnb.ai;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Slf4j
public class ServiceC extends BaseService implements DataService {
    private static final Logger logger
            = LoggerFactory.getLogger(ServiceC.class);
    @Override
    public void sendData(String messageId, String message, String targetService) {
        logger.info(String.format("[Service C] Sending data (message id: %s) to %s: %s", messageId, targetService, message));
        // Simulate processing (no further delegation)
        logger.info(String.format("[Service C] Processed data (message id: %s)", messageId));
    }

}
