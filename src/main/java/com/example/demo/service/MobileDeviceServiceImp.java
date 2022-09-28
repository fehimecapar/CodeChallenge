package com.example.demo.service;

import com.example.demo.model.MobileDeviceModel;
import com.example.demo.repository.MobileDeviceRepository;
import com.example.demo.results.DataResult;
import com.example.demo.results.ErrorDataResult;
import com.example.demo.results.SuccessDataResult;
import com.example.demo.web.dto.MobileDeviceDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Service
public class MobileDeviceServiceImp implements MobileDeviceService{
    HashSet<MobileDeviceModel> mobileDeviceList = new HashSet<MobileDeviceModel>();
    private MobileDeviceRepository mobileDeviceRepository;
    List<MobileDeviceDto> mobileDeviceDtos;
    public MobileDeviceServiceImp(HashSet<MobileDeviceModel> mobileDeviceList, MobileDeviceRepository mobileDeviceRepository) {
        this.mobileDeviceList = mobileDeviceList;
        this.mobileDeviceRepository = mobileDeviceRepository;
    }

    @Override
    public DataResult<MobileDeviceDto> addMobileDevice(MobileDeviceDto modelDeviceDto) {
        MobileDeviceModel md = new MobileDeviceModel();
        try {
            osControle(modelDeviceDto.getOs());
            md.setId(new Random().nextInt());
            md.setModel(modelDeviceDto.getModel());
            md.setBrand(modelDeviceDto.getBrand());
            md.setOs(modelDeviceDto.getOs());
            md.setOsVersion(modelDeviceDto.getOsVersion());
            mobileDeviceRepository.save(md);
            return new SuccessDataResult<>(modelDeviceDto,"Success");
        }catch (Exception e){
            return new ErrorDataResult<>(modelDeviceDto, e.getMessage());
        }

    }

    @Override
    public DataResult<List<MobileDeviceDto>> brandFilter(String brand) {

        List<MobileDeviceModel> mobileDeviceModelsByBrand = mobileDeviceRepository.findMobileDeviceModelsByBrand(brand);
        mobileDeviceDtos = new ArrayList<>();
        for (MobileDeviceModel mobileDeviceModel : mobileDeviceModelsByBrand) {

            MobileDeviceDto mdd = new MobileDeviceDto();
            mdd.setModel(mobileDeviceModel.getModel());
            mdd.setBrand(mobileDeviceModel.getBrand());
            mdd.setOs(mobileDeviceModel.getOs());
            mdd.setOsVersion(mobileDeviceModel.getOsVersion());

            mobileDeviceDtos.add(mdd);

        }
        return new SuccessDataResult<>(mobileDeviceDtos,"Data Listed");

    }

    private void osControle(String os) throws Exception {

        if(!os.equalsIgnoreCase("Android") && !os.equalsIgnoreCase("IOS")) {
            throw new Exception("Os type is not define");
        }
    }


    @Override
    public DataResult<List<MobileDeviceDto>> getAllMobileDevice() {
        List<MobileDeviceModel> mobileDeviceModels = mobileDeviceRepository.findAll();
        mobileDeviceDtos = new ArrayList<>();
        for (MobileDeviceModel mobileDeviceModel : mobileDeviceModels) {

            MobileDeviceDto mdd = new MobileDeviceDto();
            mdd.setModel(mobileDeviceModel.getModel());
            mdd.setBrand(mobileDeviceModel.getBrand());
            mdd.setOs(mobileDeviceModel.getOs());
            mdd.setOsVersion(mobileDeviceModel.getOsVersion());

            mobileDeviceDtos.add(mdd);

        }
        return new SuccessDataResult<>(mobileDeviceDtos,"Data Listed");

    }

}
