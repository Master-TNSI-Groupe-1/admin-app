package com.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Site implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_site")
    private Integer id;

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
    @JsonProperty
    private boolean isEnabled;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Location> locationList;

    @OneToOne(mappedBy = "site")
    @JsonIgnore
    private Users userOwner;

    public Site() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.id = idSite;
    }

    public Users getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(Users userOwner) {
        this.userOwner = userOwner;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
