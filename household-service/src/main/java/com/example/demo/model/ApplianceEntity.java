package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="HOUSEHOLD")
public class ApplianceEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serialnumber;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="status")
    private String status;

    @Column(name="date")
    private LocalDate date;

    public ApplianceEntity() {
        super();
    }

    public ApplianceEntity(Integer serialnumber, String brand, String model, String status, LocalDate date) {
        this.serialnumber = serialnumber;
        this.brand = brand;
        this.model = model;
        this.status = status;
        this.date = date;
    }

    public Integer getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(Integer serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
