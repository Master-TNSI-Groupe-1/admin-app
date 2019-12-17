package com.application.entity;

import javax.persistence.*;

@Entity
public class PointXY {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_point")
    private Integer idPoint;

    @Basic
    private int latitude;

    @Basic
    private int longitude;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_location")
    private Location location;

    public PointXY() {}

    public int getIdPoint() {
        return idPoint;
    }

    public void setIdPoint(int idPoint) {
        this.idPoint = idPoint;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
