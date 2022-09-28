package com.example.demo.service;

import com.example.demo.results.DataResult;
import com.example.demo.web.dto.MobileDeviceDto;

import java.util.List;

public interface MobileDeviceService {

    DataResult<List<MobileDeviceDto>> getAllMobileDevice(); //get data from MobileDevice table
    DataResult<MobileDeviceDto> addMobileDevice(MobileDeviceDto md) throws Exception; //add data to MobileDevice table

    //void deleteAllData(); //i have used this function due to i have added wrong data
    DataResult<List<MobileDeviceDto>> brandFilter(String brand);


}
