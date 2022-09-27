package com.example.demo.service;

import com.example.demo.model.MobileDeviceModel;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class MobileDeviceServiceImp implements MobileDeviceService{
    HashSet<MobileDeviceModel> mobileDeviceList = new HashSet<MobileDeviceModel>();
    @Override
    public void addMobileDevice(MobileDeviceModel md) {
        mobileDeviceList.add(md);
        md.setModel(md.getModel());
        md.setBrand(md.getBrand());
        md.setOs(md.getOs());
        md.setOsVersion(md.getOsVersion());
    }
    @Override
    public HashSet<MobileDeviceModel> getAllMobileDevice() {
        if(mobileDeviceList.isEmpty()){
            return null;
        }
        else{
            return mobileDeviceList;
        }
    }

}
