package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MobileDeviceDto {

    public Long id;
    @NonNull
    private String brand;
    @NonNull
    private String model;
    @NonNull
    private String os;
    @NonNull
    private String osVersion;

}
