package com.example.demo.controller;

import com.example.demo.model.MobileDeviceModel;
import com.example.demo.results.DataResult;
import com.example.demo.results.SuccessDataResult;
import com.example.demo.service.MobileDeviceService;
import com.example.demo.service.MobileDeviceServiceImp;
import com.example.demo.web.dto.MobileDeviceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RequestMapping("/md")
@RestController
public class MobileDeviceController {

    @Autowired
    MobileDeviceService mobileDeviceService;

    public MobileDeviceController(MobileDeviceService mobileDeviceService) {
        this.mobileDeviceService = mobileDeviceService;
    }

    @GetMapping("/getall")
    public DataResult<List<MobileDeviceDto>> getAllMobileDevice(){
        return mobileDeviceService.getAllMobileDevice();
    }
    @GetMapping("/device")
    public DataResult<List<MobileDeviceDto>> brandFilter(@RequestParam String brand){
        return mobileDeviceService.getAllMobileDevice();
    }

    @PostMapping("/post")
    public DataResult addMobileDevice(@RequestBody MobileDeviceDto modelDeviceDto) throws Exception {
        //mobileDeviceService.addMobileDevice(modelDeviceDto);
        return mobileDeviceService.addMobileDevice(modelDeviceDto);
    }

    /*@DeleteMapping("/delete")
    public void deleteMobileDevice() {
        mobileDeviceServiceImp.deleteAllData();
    }**/

}
