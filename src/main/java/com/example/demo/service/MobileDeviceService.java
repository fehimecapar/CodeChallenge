package com.example.demo.service;

import com.example.demo.results.DataResult;
import com.example.demo.web.dto.MobileDeviceDto;

import java.util.List;

public interface MobileDeviceService {
    DataResult<List<MobileDeviceDto>> getAllMobileDevice(); //get all data from MobileDevice table
    DataResult<List<MobileDeviceDto>> addMobileDevices(List<MobileDeviceDto> mdlist) throws Exception; //add all datas or multiple data to MobileDevice table from devices.json file
    DataResult<MobileDeviceDto> addMobileDevice(MobileDeviceDto md) throws Exception; //save one data to MobileDevice table

    DataResult<List<MobileDeviceDto>> brandFilter(String brand); // for device?brand=any type url
    DataResult<List<MobileDeviceDto>> brandAndOsVersionFilter(String brand, String osVersion, int page, int size); //for devices?brand=Apple&osVersion=12.4.1&page=1&size=5

}
