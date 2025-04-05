package com.devices.devices.model;


import org.springframework.stereotype.Component;

@Component
public class Light {
    private boolean isOn;

    public void toggleSwitch(boolean state) {
        this.isOn = state;
    }

    public boolean isOn() {
        return isOn;
    }
}
