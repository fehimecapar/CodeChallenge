package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "MobileDeviceTable")//table name
public class MobileDeviceModel {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    * */
    @NotNull @NotEmpty
    private String brand;
    @NotNull @NotEmpty
    private String model;
    @NotNull @NotEmpty
    private String os;
    @NotNull @NotEmpty
    private String osVersion;

    /*
    @Override //OOP
    public int hashCode() { return Objects.hash(id); }
    **/
}
