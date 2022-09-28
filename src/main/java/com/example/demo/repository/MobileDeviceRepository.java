package com.example.demo.repository;

import com.example.demo.model.MobileDeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobileDeviceRepository extends JpaRepository<MobileDeviceModel, Integer> {

    List<MobileDeviceModel> findMobileDeviceModelsByBrand(String brand);
    List<MobileDeviceModel> findMobileDeviceModelsByBrandAndModel(String brand, String model);
    List<MobileDeviceModel> findMobileDeviceModelsByBrandOrModel(String brand, String model);

}
