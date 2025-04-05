package com.devices.devices.model;

import org.springframework.stereotype.Component;

@Component
public class Fan {
    private int speed;

    public void setSpeed(int speed) {
        if(speed>=0 && speed <=2) {
            this.speed = speed;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return speed>0;
    }
}
