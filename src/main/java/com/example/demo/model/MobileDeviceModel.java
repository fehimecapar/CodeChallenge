package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor       
//@Table(name="mobileDevices")
public class MobileDeviceModel {
    public Long id;
    @NonNull
    private String brand;
    @NonNull
    private String model;
    @NonNull
    private String os;
    @NonNull
    private String osVersion;

    @Override //OOP
    public int hashCode() {
        return Objects.hash(id);
    }

}

