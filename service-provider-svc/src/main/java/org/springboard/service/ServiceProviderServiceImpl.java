package org.springboard.service;

import org.springboard.dao.ServiceProviderDao;
import org.springboard.model.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.mail.SimpleEmail;

import java.util.List;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    @Autowired
    private ServiceProviderDao dao;
    @Override
    public List<ServiceProvider> getAllProviders() {
        return dao.getAll();
    }
    
    @Override
    public void sendEmail(String msg, String to) {
        try {
            SimpleEmail mail = new SimpleEmail();
            mail.setMsg(msg);
            mail.setHostName("local");
            mail.setFrom("tsc-login-otp@no-reply.com");
            mail.addTo(to);
            mail.send();
        } catch (Exception exception) {
            System.err.println("Mail send failed to " + to);
        }
        
    }
}
