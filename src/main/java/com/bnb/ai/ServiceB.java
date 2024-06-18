package com.bnb.ai;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.UUID;

@Slf4j
public class ServiceB extends BaseService implements DataService {

    private static final Logger logger
            = LoggerFactory.getLogger(ServiceB.class);

    private final DataService serviceC;
    private final Random random = new Random();

    public ServiceB(DataService serviceC) {
        this.serviceC = serviceC;
    }

    @Override
    public void sendData(String messageId, String message, String targetService) {
        logger.info(String.format("[Service B] Sending data (message id: %s) to %s: %s", messageId, targetService, message));
        // Simulate processing and potential failure
        if (random.nextInt(10) == 0) {
            logger.info(String.format("[Service B] Failed to send data (message id: %s)!", messageId));
            return;
        }

        serviceC.sendData(messageId, message, targetService); // Delegate to Service C
    }


}