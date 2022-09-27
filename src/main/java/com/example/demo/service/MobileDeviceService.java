package com.example.demo.service;

import com.example.demo.model.MobileDeviceModel;

import java.util.HashSet;

public interface MobileDeviceService {

    HashSet<MobileDeviceModel> getAllMobileDevice(); //get data from MobileDevice table
    void addMobileDevice(MobileDeviceModel md); //add data to MobileDevice table

    //void deleteAllData(); //i have used this function due to i have added wrong data


}
