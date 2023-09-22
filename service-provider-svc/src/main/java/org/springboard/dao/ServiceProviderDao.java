package org.springboard.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springboard.model.ServiceProviderModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface ServiceProviderDao extends CrudRepository<ServiceProviderModel, String> {

    Optional<ServiceProviderModel> findById(String id);

    List<ServiceProviderModel> findAll();

    ServiceProviderModel save(ServiceProviderModel serviceProvider);

    ServiceProviderModel findByName(String name);
}
