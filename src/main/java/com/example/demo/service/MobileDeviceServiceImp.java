package com.example.demo.service;

import com.example.demo.model.MobileDeviceModel;
import com.example.demo.repository.MobileDeviceRepository;
import com.example.demo.web.dto.MobileDeviceDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;

@Service
public class MobileDeviceServiceImp implements MobileDeviceService{
    HashSet<MobileDeviceModel> mobileDeviceList = new HashSet<MobileDeviceModel>();
    public MobileDeviceRepository mobileDeviceRepository;

    public MobileDeviceServiceImp(HashSet<MobileDeviceModel> mobileDeviceList, MobileDeviceRepository mobileDeviceRepository) {
        this.mobileDeviceList = mobileDeviceList;
        this.mobileDeviceRepository = mobileDeviceRepository;
    }

    @Override
    public void addMobileDevice(MobileDeviceDto modelDeviceDto) {
        MobileDeviceModel md = new MobileDeviceModel();
        //mobileDeviceList.add(md);
        md.setId(1);
        md.setModel(modelDeviceDto.getModel());
        md.setBrand(modelDeviceDto.getBrand());
        md.setOs(modelDeviceDto.getOs());
        md.setOsVersion(modelDeviceDto.getOsVersion());
        mobileDeviceRepository.save(md);
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
