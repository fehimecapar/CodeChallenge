package com.example.demo.controller;

import com.example.demo.model.MobileDeviceModel;
import com.example.demo.service.MobileDeviceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class MobileDeviceController {

    @Autowired
    MobileDeviceServiceImp mobileDeviceServiceImp;

    @PostMapping("/")
    public void addMobileDevice(@RequestBody MobileDeviceModel model){
        mobileDeviceServiceImp.addMobileDevice(model);
    }
    @GetMapping("/getall")
    public HashSet<MobileDeviceModel> getAllMobileDevice(){
        return mobileDeviceServiceImp.getAllMobileDevice();
    }
}
