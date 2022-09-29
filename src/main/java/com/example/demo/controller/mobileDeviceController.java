package com.example.demo.controller;

import com.example.demo.results.DataResult;
import com.example.demo.service.MobileDeviceService;
import com.example.demo.web.dto.MobileDeviceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/getAll")
    public DataResult<List<MobileDeviceDto>> getAllMobileDevice(){
        return mobileDeviceService.getAllMobileDevice();
    }
    @GetMapping("/device")
    public DataResult<List<MobileDeviceDto>> brandFilter(@RequestParam("brand") String brand){
        return mobileDeviceService.brandFilter(brand);
    }
    @GetMapping("/devices")//bu hata iki tane getMapping içine aynı şeyi koymamdan kaynaklandı
    public DataResult<List<MobileDeviceDto>> brandAndOsVersionFilter(@RequestParam("brand") String brand, @RequestParam("osVersion")String osVersion,
                                                                     @RequestParam("page") int page, @RequestParam("size") int size){
        return mobileDeviceService.brandAndOsVersionFilter(brand, osVersion, page, size);
    }

    @PostMapping("/post")
    public DataResult addMobileDevices(@RequestBody List<MobileDeviceDto> modelDeviceDto) throws Exception {
        return mobileDeviceService.addMobileDevices(modelDeviceDto);
    }
    @PostMapping("/save")
    public DataResult addMobileDevice(@RequestBody MobileDeviceDto modelDeviceDto) throws Exception {
        return mobileDeviceService.addMobileDevice(modelDeviceDto);
    }

}
