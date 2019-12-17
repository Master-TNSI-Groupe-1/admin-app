package com.application.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Site {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_site")
    private Integer idSite;

    @Basic
    @Column(length = 50)
    private String name;

    @Basic
    @Column(name = "url_image", length = 100)
    private String urlImage;

    @Basic
    @Column(length = 30)
    private String city;

    @Basic
    @Column(name = "is_enabled")
    private boolean isEnabled;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Location> locationList;

    @OneToOne(mappedBy = "site")
    private Users userOwner;

    public Site() {}

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public void setIdSite(Integer idSite) {
        this.idSite = idSite;
    }

    public Users getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(Users userOwner) {
        this.userOwner = userOwner;
    }
}
