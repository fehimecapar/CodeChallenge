package com.example.demo.controller;

import com.example.demo.model.MobileDeviceModel;
import com.example.demo.service.MobileDeviceService;
import com.example.demo.service.MobileDeviceServiceImp;
import com.example.demo.web.dto.MobileDeviceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RequestMapping("/md")
@RestController
public class MobileDeviceController {

    @Autowired
    MobileDeviceService mobileDeviceService;

    public MobileDeviceController(MobileDeviceService mobileDeviceService) {
        this.mobileDeviceService = mobileDeviceService;
    }

    @GetMapping("/get")
    public HashSet<MobileDeviceModel> getAllMobileDevice(){
        return mobileDeviceService.getAllMobileDevice();
    }

    @PostMapping("/post")
    public String addMobileDevice(@RequestBody MobileDeviceDto modelDeviceDto){
        mobileDeviceService.addMobileDevice(modelDeviceDto);
        return "mobile device has been added";
    }

    /*@DeleteMapping("/delete")
    public void deleteMobileDevice() {
        mobileDeviceServiceImp.deleteAllData();
    }**/

}
