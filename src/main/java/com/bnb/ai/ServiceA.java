package com.bnb.ai;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.UUID;

@Slf4j
public class ServiceA extends BaseService implements DataService {

    private static final Logger logger
            = LoggerFactory.getLogger(ServiceA.class);
    private final DataService serviceB;
    private final Random random = new Random();

    public ServiceA(DataService serviceB) {
        this.serviceB = serviceB;
    }

    public static void main(String[] args) {
        int counter = 0;
        while (counter < 10000) {
            counter++;
            ServiceA serviceA = new ServiceA(new ServiceB(new ServiceC()));
            serviceA.sendData(UUID.randomUUID().toString(), "Processing data", "Service C");
        }
    }

    @Override
    public void sendData(String messageId, String message, String targetService) {
        logger.info(String.format("[Service A] Sending data (message id: %s) to %s: %s", messageId, targetService, message));

        // Simulate processing and potential failure
        if (random.nextInt(10) == 0) { // Simulate 10% failure rate
            logger.info(String.format("[Service A] Failed to send data (message id: %s)!", messageId));
            return;
        }

        serviceB.sendData(messageId, message, targetService); // Delegate to Service B
    }

}