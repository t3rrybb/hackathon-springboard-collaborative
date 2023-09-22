package org.springboard.service;

import org.springboard.dao.ServiceProviderDao;
import org.springboard.model.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    @Autowired
    private ServiceProviderDao dao;
    @Override
    public List<ServiceProvider> getAllProviders() {
        return dao.getAll();
    }
}
