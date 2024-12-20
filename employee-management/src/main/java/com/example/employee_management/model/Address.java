package com.example.employee_management.model;

// Importing JPA annotations for database mapping
import jakarta.persistence.*;

/**
 * The Address class represents an entity that will be stored in a database.
 * It contains information about an address such as house number, street area, city, country, phone, and email.
 * The class uses Jakarta Persistence API (JPA) to map this object to a database table.
 */

@Entity  // Marks this class as a JPA entity, meaning it will be mapped to a table in the database
public class Address {


    @Id  // Marks this field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates the ID value (typically by the database)
    private Long id;  // Unique identifier for each address

    // Fields representing different components of an address
    private String houseNo;
    private String streetArea;
    private String city;
    private String country;
    private String phone;
    private String email;

    /**
     * Getter method for the 'id' field.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for the 'id' field.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for the 'houseNo' field.
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * Setter method for the 'houseNo' field.
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }


    public String getStreetArea() {
        return streetArea;
    }

    public void setStreetArea(String streetArea) {
        this.streetArea = streetArea;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

}
