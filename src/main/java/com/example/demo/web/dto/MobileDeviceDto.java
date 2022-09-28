package com.example.demo.web.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class MobileDeviceDto {

    @NotNull
    @NotEmpty
    private String model;

    @NotNull @NotEmpty
    private String brand;


    @NotNull @NotEmpty
    private String os;

    @NotNull @NotEmpty
    private String osVersion;

}
