package com.example.demo.service;

import com.example.demo.model.MobileDeviceModel;

import java.util.HashSet;

public interface MobileDeviceService {

    void addMobileDevice(MobileDeviceModel md); //add data to MobileDevice table
    HashSet<MobileDeviceModel> getAllMobileDevice(); //get data from MobileDevice table

}
