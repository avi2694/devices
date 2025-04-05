package com.devices.devices.model;

import org.springframework.stereotype.Component;

@Component
public class AirConditioner {

    public static final String ON = "ON";
    public static final String OFF = "OFF";
    private boolean isOn;

    public void setState(String mode) {
        if (ON.equalsIgnoreCase(mode)) {
            isOn = true;
        } else if (OFF.equalsIgnoreCase(mode)) {
            isOn = false;
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public String getMode() {
        return isOn ? ON : OFF;
    }
}
