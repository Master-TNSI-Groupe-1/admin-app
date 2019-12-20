package com.application.dto;

public class UpdateLocationDTO {

    private Integer id;
    private String name;
    private Integer numberPlaces;

    public UpdateLocationDTO() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberPlaces() {
        return numberPlaces;
    }

    public void setNumberPlaces(Integer numberPlaces) {
        this.numberPlaces = numberPlaces;
    }
}
