package com.devices.devices.service;

import com.devices.devices.controller.DeviceController;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DeviceSystemScheduler {
    private DeviceController deviceController;

    public DeviceSystemScheduler(DeviceController deviceController) {
        this.deviceController = deviceController;
    }

    @Scheduled(cron = "0 0 1 1 1 *")
    public void doSystemUpdate() {
        this.deviceController.turnOffAllDevices();
    }
}
