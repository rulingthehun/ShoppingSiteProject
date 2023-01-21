package entity;

import enums.City;

public class Address {
    private String description;
    private City city;
    private String zipCode;

    public Address(String description, City city, String zipCode) {
        this.description = description;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
