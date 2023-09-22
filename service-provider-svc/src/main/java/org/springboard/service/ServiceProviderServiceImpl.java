package org.springboard.service;

import org.springboard.dao.MailModelDAO;
import org.springboard.dao.ServiceProviderDao;
import org.springboard.model.MailModel;
import org.springboard.model.ServiceProviderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.mail.SimpleEmail;
import java.util.Objects;

import java.util.List;
import java.util.Random;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    @Autowired
    private ServiceProviderDao serviceProviderDao;

    @Autowired
    private MailModelDAO mailModelDAO;

    @Override
    public List<ServiceProviderModel> getAllServiceProviders() {
        return serviceProviderDao.findAll();
    }

    @Override
    public ServiceProviderModel findServiceProviderById(String id) {
        return serviceProviderDao.findById(id).orElse(null);
    }

    @Override
    public ServiceProviderModel updateServiceProviderById(ServiceProviderModel newServiceProviderInfo, String id) {
        var oldServiceProviderInfo = findServiceProviderById(id);
        if(Objects.isNull(oldServiceProviderInfo)) return addServiceProvider(newServiceProviderInfo);
        var updatedParticipantInfo = oldServiceProviderInfo.updateServiceProvider(newServiceProviderInfo);
        return addServiceProvider(updatedParticipantInfo);
    }

    @Override
    public ServiceProviderModel deleteServiceProviderById(String id) {
        var serviceProvider = serviceProviderDao.findById(id);
        if(serviceProvider.isPresent()){
            serviceProvider.get().setActive(false);
            serviceProviderDao.save(serviceProvider.get());
            return serviceProvider.get();
        }
        return null;
    }

    @Override
    public ServiceProviderModel addServiceProvider(ServiceProviderModel serviceProvider) {
        return serviceProviderDao.save(serviceProvider);
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

    public void addMailModel(MailModel mailModel) {
        mailModelDAO.save(mailModel);
    }
    

    public MailModel findMailModelByMailId(String mailId) {
        return mailModelDAO.findByMailId(mailId).orElse(null);
    }

    @Override
    public String generateOtpAndSave(String mailId) {
        var existingMailModel = findMailModelByMailId(mailId);
        var newOtp = generateOTP(6);
        var stringBuilder = new StringBuilder();
        if (Objects.nonNull(existingMailModel)) {
            existingMailModel.setOtp(newOtp);
            addMailModel(existingMailModel);
            stringBuilder.append("mail id already exists hence regenerated OTP");
        } else {
            MailModel mailModel = new MailModel(mailId, newOtp);
            addMailModel(mailModel);
            stringBuilder.append("new OTP generated successfully");
        }
        sendEmail(newOtp, mailId);
        return stringBuilder.toString();
    }

    @Override
    public String validateOtpAndDelete(String mailId, String otp) {
        var mailModel = findMailModelByMailId(mailId);
        var stringBuilder = new StringBuilder();
        if (Objects.nonNull(mailModel) && otp.equals(mailModel.getOtp())) {
            stringBuilder.append("ACCEPTED");
            mailModel.setOtp("");
            addMailModel(mailModel);
        }
        return stringBuilder.toString();
    }

    public String generateOTP(int len) {
        String numbers = "0123456789";

        Random random = new Random();
        char[] otp = new char[len];
        for (int i = 0; i < len; i++) {
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return new String(otp);
    }
}
