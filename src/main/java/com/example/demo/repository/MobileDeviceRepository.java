package com.example.demo.repository;

import com.example.demo.model.MobileDeviceModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobileDeviceRepository extends JpaRepository<MobileDeviceModel, Integer> {

    List<MobileDeviceModel> findMobileDeviceModelsByBrand(String brand);
    List<MobileDeviceModel> findMobileDeviceModelsByBrandAndOsVersion(String brand, String osVersion, Pageable page);


}
