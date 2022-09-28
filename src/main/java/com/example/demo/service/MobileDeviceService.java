package com.example.demo.service;

import com.example.demo.model.MobileDeviceModel;
import com.example.demo.web.dto.MobileDeviceDto;

import java.util.HashSet;

public interface MobileDeviceService {

    HashSet<MobileDeviceModel> getAllMobileDevice(); //get data from MobileDevice table
    void addMobileDevice(MobileDeviceDto md); //add data to MobileDevice table

    //void deleteAllData(); //i have used this function due to i have added wrong data


}
