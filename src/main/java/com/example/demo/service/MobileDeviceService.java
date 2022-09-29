package com.example.demo.service;

import com.example.demo.results.DataResult;
import com.example.demo.web.dto.MobileDeviceDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MobileDeviceService {
    DataResult<List<MobileDeviceDto>> getAllMobileDevice(); //get data from MobileDevice table
    DataResult<List<MobileDeviceDto>> addMobileDevices(List<MobileDeviceDto> mdlist) throws Exception; //add data to MobileDevice table
    DataResult<MobileDeviceDto> addMobileDevice(MobileDeviceDto md) throws Exception; //add data to MobileDevice table

    DataResult<List<MobileDeviceDto>> brandFilter(String brand);
    DataResult<List<MobileDeviceDto>> brandAndOsVersionFilter(String brand, String osVersion, int page, int size);

}
