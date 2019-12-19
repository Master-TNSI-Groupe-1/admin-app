package com.application.dto;

import javax.validation.constraints.NotNull;

public class NewPointXYDTO {

    @NotNull(message = "locationId can't empty!")
    private int locationId;

    @NotNull(message = "longitude can't empty!")
    private Double longitude;

    @NotNull(message = "latitude can't empty!")
    private Double latitude;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
