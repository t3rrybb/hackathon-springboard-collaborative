package org.springboard.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springboard.model.ServiceProvider;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface ServiceProviderDao extends CrudRepository<ServiceProvider, String> {

    Optional<ServiceProvider> findById(String id);

    List<ServiceProvider> findAll();

    List<ServiceProvider> findByActive(Boolean status);

}
