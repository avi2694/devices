package com.devices.devices.controller;


import com.devices.devices.model.AirConditioner;
import com.devices.devices.model.Fan;
import com.devices.devices.model.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.devices.devices.model.AirConditioner.OFF;
import static com.devices.devices.model.AirConditioner.ON;

@RestController
@RequestMapping("api")
public class DeviceController {
    private final Light light;
    private final Fan fan;
    private final AirConditioner airConditioner;

    @Autowired
    public DeviceController(Light light, Fan fan, AirConditioner airConditioner) {
        this.light = light;
        this.fan = fan;
        this.airConditioner = airConditioner;
    }

    @PostMapping("/light")
    public ResponseEntity<String> setLightState(@RequestParam  boolean state) {
        this.light.toggleSwitch(state);
        return ResponseEntity.ok("Light state set to :" + (state?"ON":"OFF"));
    }

    @PostMapping("/fan")
    public ResponseEntity<String> setFanState(@RequestParam int speed) {
        if(speed>=0 && speed<=2) {
            this.fan.setSpeed(speed);
            return ResponseEntity.ok("Fan Speed set to : " + speed);
        }
        return ResponseEntity.badRequest().body("Invalid fan speed");

    }

    @PostMapping("/ac")
    public ResponseEntity<String> setACMode(@RequestParam String mode) {
        if(ON.equalsIgnoreCase(mode) || OFF.equalsIgnoreCase(mode)) {
            this.airConditioner.setState(mode);
            return ResponseEntity.ok("AC mode set to  : " + mode);
        }
        return ResponseEntity.badRequest().body("Invalid AC thermostat mode");
    }

    @GetMapping("/light")
    public ResponseEntity<String> getLightState() {
        return ResponseEntity.ok("Light state set to :" + (this.light.isOn()?"ON":"OFF"));
    }

    @GetMapping("/fan")
    public ResponseEntity<String> getFanState() {
        return ResponseEntity.ok("Fan Speed set to : " + this.fan.getSpeed());
    }

    @GetMapping("/ac")
    public ResponseEntity<String> getACState() {
        return ResponseEntity.ok("AC mode set to  : " + this.airConditioner.getMode());
    }

    //to be called by scheduler
    public void turnOffAllDevices() {
        this.fan.setSpeed(0);
        this.airConditioner.setState(OFF);
        this.light.toggleSwitch(false);
    }

}
