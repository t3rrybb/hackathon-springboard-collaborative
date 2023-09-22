package org.springboard.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;
import java.util.Set;

@DynamoDBTable(tableName="service-provider")
public class ServiceProviderModel {

    private String id;
    private String name;

    private String description;

    private String website;

    private String email;

    private String phone;

    private Set<String> services;

    private Boolean active;

    private String consentFormURL;

    public ServiceProviderModel() {
    }

    public ServiceProviderModel(String id, String name, String description,
                                String website, String email, String phone,
                                Set<String> services, Boolean active, String consentFormURL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.website = website;
        this.email = email;
        this.phone = phone;
        this.services = services;
        this.active = active;
        this.consentFormURL = consentFormURL;
    }

    public ServiceProviderModel(String name, String description,
                                String website, String email, String phone,
                                Set<String> services, Boolean active, String consentFormURL) {
        this.name = name;
        this.description = description;
        this.website = website;
        this.email = email;
        this.phone = phone;
        this.services = services;
        this.active = active;
        this.consentFormURL = consentFormURL;
    }

    public ServiceProviderModel updateServiceProvider(ServiceProviderModel serviceProvider) {
        if(Objects.nonNull(serviceProvider.getName()))
            this.name = serviceProvider.getName();

        if(Objects.nonNull(serviceProvider.getDescription()))
            this.description = serviceProvider.getDescription();

        if(Objects.nonNull(serviceProvider.getWebsite()))
            this.website = serviceProvider.getName();

        if(Objects.nonNull(serviceProvider.getEmail()))
            this.email = serviceProvider.getEmail();

        if(Objects.nonNull(serviceProvider.getPhone()))
            this.phone = serviceProvider.getPhone();

        if (Objects.nonNull(serviceProvider.getServices())){
            if(Objects.nonNull(this.services)){
                this.services.addAll(serviceProvider.getServices());
            }else{
                this.services = serviceProvider.getServices();
            }
        }

        if(Objects.nonNull(serviceProvider.getActive()))
            this.active = serviceProvider.getActive();

        if (Objects.nonNull(serviceProvider.getConsentFormURL())) {
            this.consentFormURL = serviceProvider.getConsentFormURL();
        }

        return this;
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @DynamoDBAttribute
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @DynamoDBAttribute
    public Set<String> getServices() {
        return services;
    }

    public void setServices(Set<String> services) {
        this.services = services;
    }

    @DynamoDBAttribute
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @DynamoDBAttribute
    public String getConsentFormURL() {
        return consentFormURL;
    }

    public void setConsentFormURL(String consentFormURL) {
        this.consentFormURL = consentFormURL;
    }
}
