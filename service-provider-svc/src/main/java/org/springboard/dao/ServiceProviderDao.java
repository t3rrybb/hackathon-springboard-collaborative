package org.springboard.dao;

import org.springboard.model.ServiceProvider;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServiceProviderDao {

    public List<ServiceProvider> getAll() {

        ServiceProvider p1 = new ServiceProvider();
        p1.setId("001");
        p1.setName("P1");

        ServiceProvider p2 = new ServiceProvider();
        p2.setId("002");
        p2.setName("P2");

        return Arrays.asList(p1, p2);
    }
}
