package org.springboard.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Set;

public class ServiceProvider {

    @JsonDeserialize
    private String id;
    @JsonDeserialize
    private String name;

    @JsonDeserialize
    private String description;

    @JsonDeserialize
    private String website;

    @JsonDeserialize
    private String email;

    @JsonDeserialize
    private String phone;

    @JsonDeserialize
    private Set<String> services;

    @JsonDeserialize
    private Boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<String> getServices() {
        return services;
    }

    public void setServices(Set<String> services) {
        this.services = services;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
