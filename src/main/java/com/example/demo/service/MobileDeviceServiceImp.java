package com.example.demo.service;

import com.example.demo.model.MobileDeviceModel;
import com.example.demo.repository.MobileDeviceRepository;
import com.example.demo.results.DataResult;
import com.example.demo.results.ErrorDataResult;
import com.example.demo.results.SuccessDataResult;
import com.example.demo.web.dto.MobileDeviceDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.*;

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
    public DataResult<List<MobileDeviceDto>> addMobileDevices(List<MobileDeviceDto> modelDeviceDto) {

        List<MobileDeviceModel> list = new ArrayList<>();
        try {
            for (MobileDeviceDto mobileDeviceDto : modelDeviceDto) {
                MobileDeviceModel md = new MobileDeviceModel();
                osControle(mobileDeviceDto.getOs());
                md.setId(new Random().nextInt());
                md.setModel(mobileDeviceDto.getModel());
                md.setBrand(mobileDeviceDto.getBrand());
                md.setOs(mobileDeviceDto.getOs());
                md.setOsVersion(mobileDeviceDto.getOsVersion());

                list.add(md);
            }
            mobileDeviceRepository.saveAll(list);
            //mobileDeviceRepository.saveAllAndFlush(list.add(md));

            return new SuccessDataResult<>(modelDeviceDto,"Data saved to database");
        }catch (Exception e){
            return new ErrorDataResult<>(modelDeviceDto, e.getMessage());
        }

    }
    @Override
    public DataResult<MobileDeviceDto> addMobileDevice(MobileDeviceDto modelDeviceDto) {
        MobileDeviceModel md = new MobileDeviceModel();
        try {
            osControle(modelDeviceDto.getOs());
            modelBrandOsVersionControle(modelDeviceDto.getModel(), modelDeviceDto.getBrand(), modelDeviceDto.getOsVersion());
            md.setId(new Random().nextInt());
            md.setModel(modelDeviceDto.getModel());
            md.setBrand(modelDeviceDto.getBrand());
            md.setOs(modelDeviceDto.getOs());
            md.setOsVersion(modelDeviceDto.getOsVersion());
            mobileDeviceRepository.saveAndFlush(md);
            return new SuccessDataResult<>("Data Saved");
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
        return new SuccessDataResult<>(mobileDeviceDtos,"Data Listed by brand");

    }

    @Override
    public DataResult<List<MobileDeviceDto>> brandAndOsVersionFilter(String brand, String osVersion, int page, int size) {
        Pageable paging = PageRequest.of(page-1, size);
        List<MobileDeviceModel> mobileDeviceModelsByBrandAndModelsByOsVersion = mobileDeviceRepository.findMobileDeviceModelsByBrandAndOsVersion(brand, osVersion, paging);
        mobileDeviceDtos = new ArrayList<>();
        for (MobileDeviceModel mobileDeviceModel : mobileDeviceModelsByBrandAndModelsByOsVersion) {

            MobileDeviceDto mdd = new MobileDeviceDto();
            mdd.setModel(mobileDeviceModel.getModel());
            mdd.setBrand(mobileDeviceModel.getBrand());
            mdd.setOs(mobileDeviceModel.getOs());
            mdd.setOsVersion(mobileDeviceModel.getOsVersion());

            mobileDeviceDtos.add(mdd);//md değeri boş dönüyor ve debug'a girmiyor
        }
        return new SuccessDataResult<>(mobileDeviceDtos,"Data listed by brand and model");
    }

    private void osControle(String os) throws Exception {

        if(!os.equalsIgnoreCase("Android") && !os.equalsIgnoreCase("IOS")) {
            throw new Exception("Os type is not defined");
        }
    }

    private void modelBrandOsVersionControle(String model, String brand, String osVersion) throws Exception{
        List<MobileDeviceModel> mobileDeviceModels = mobileDeviceRepository.findAll();
        mobileDeviceDtos = new ArrayList<>();
        for (MobileDeviceModel mobileDeviceModel : mobileDeviceModels) {

            String tempModel = mobileDeviceModel.getModel();
            String tempBrand = mobileDeviceModel.getBrand();
            String tempOsVersion = mobileDeviceModel.getOsVersion();

            if(tempModel.equals(model) && tempBrand.equals(brand) && tempOsVersion.equals(osVersion)){
                throw new Exception("this mobile device has already been added to database");
            }
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
