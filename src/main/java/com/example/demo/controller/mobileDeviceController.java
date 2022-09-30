package com.example.demo.controller;

import com.example.demo.results.DataResult;
import com.example.demo.service.MobileDeviceService;
import com.example.demo.web.dto.MobileDeviceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/md")
@RestController
public class MobileDeviceController {

    @Autowired
    MobileDeviceService mobileDeviceService;

    public MobileDeviceController(MobileDeviceService mobileDeviceService) {
        this.mobileDeviceService = mobileDeviceService;
    }

    @GetMapping("/getAll") // get all data
    public DataResult<List<MobileDeviceDto>> getAllMobileDevice(){
        return mobileDeviceService.getAllMobileDevice();
    }

    @GetMapping("/device") // fetch data by brand
    public DataResult<List<MobileDeviceDto>> brandFilter(@RequestParam("brand") String brand){
        return mobileDeviceService.brandFilter(brand);
    }
    @GetMapping("/devices") // fetch data by brand and osVersion
    public DataResult<List<MobileDeviceDto>> brandAndOsVersionFilter(@RequestParam("brand") String brand, @RequestParam("osVersion")String osVersion,
                                                                     @RequestParam("page") int page, @RequestParam("size") int size){
        return mobileDeviceService.brandAndOsVersionFilter(brand, osVersion, page, size);
    }

    @PostMapping("/post")// save all data and multiple data
    public DataResult addMobileDevices(@RequestBody List<MobileDeviceDto> modelDeviceDto) throws Exception {
        return mobileDeviceService.addMobileDevices(modelDeviceDto);
    }
    @PostMapping("/save")//save just one data
    public DataResult addMobileDevice(@RequestBody MobileDeviceDto modelDeviceDto) throws Exception {
        return mobileDeviceService.addMobileDevice(modelDeviceDto);
    }

}
