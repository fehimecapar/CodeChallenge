package com.example.demo.repository;

import com.example.demo.model.MobileDeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileDeviceRepository extends JpaRepository<MobileDeviceModel, Integer> {

}
