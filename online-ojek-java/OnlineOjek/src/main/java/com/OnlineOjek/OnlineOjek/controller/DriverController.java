package com.OnlineOjek.OnlineOjek.controller;

import com.OnlineOjek.OnlineOjek.model.Driver;
import com.OnlineOjek.OnlineOjek.repository.DriverRepository;
import com.OnlineOjek.OnlineOjek.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    DriverService driverService;

    @CrossOrigin @PostMapping("api/drivers")
    public Driver createDriver(@RequestBody  Driver driver){
        return driverService.addDriver(driver);
    }

    @CrossOrigin @GetMapping("api/drivers")
    public List<Driver> getAllDriver(){
        return driverService.getAllDriver();
    }

    @CrossOrigin @GetMapping("api/drivers/status/eligible")
    public List<Driver> getEligibleDriver(){
        return driverService.getEligibleDriver();
    }


    @CrossOrigin @GetMapping("api/drivers/{driver_id}")
    public Driver getDriver(@PathVariable ("driver_id") Long driver_id){
        return  driverService.findDriverById(driver_id);
    }
}
