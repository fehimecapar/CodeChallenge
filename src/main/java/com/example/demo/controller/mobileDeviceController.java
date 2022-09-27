package com.example.demo.controller;

import com.example.demo.model.MobileDeviceModel;
import com.example.demo.service.MobileDeviceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
public class MobileDeviceController {

    @Autowired
    MobileDeviceServiceImp mobileDeviceServiceImp;

    @GetMapping("/get")
    public HashSet<MobileDeviceModel> getAllMobileDevice(){
        return mobileDeviceServiceImp.getAllMobileDevice();
    }

    @PostMapping("/post")
    public String addMobileDevice(@RequestBody MobileDeviceModel modelDeviceModel){
        mobileDeviceServiceImp.addMobileDevice(modelDeviceModel);
        return "mobile device has been added";
    }

    /*@DeleteMapping("/delete")
    public void deleteMobileDevice() {
        mobileDeviceServiceImp.deleteAllData();
    }**/

}
