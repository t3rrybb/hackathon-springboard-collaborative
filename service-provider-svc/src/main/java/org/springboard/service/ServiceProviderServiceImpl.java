package org.springboard.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import org.springboard.dao.MailModelDAO;
import org.springboard.dao.ServiceProviderDao;
import org.springboard.model.MailModel;
import org.springboard.model.ServiceProviderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import com.amazonaws.regions.Regions;
import com.amazonaws.regions.Region;
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
    public ServiceProviderModel updateServiceProviderByName(String name, String consentFormUrl) {
        var existingServiceProviderModel = serviceProviderDao.findByName(name);
        if (Objects.nonNull(existingServiceProviderModel)) {
            existingServiceProviderModel.setConsentFormURL(consentFormUrl);
            return addServiceProvider(existingServiceProviderModel);
        } else {
            return null;
        }
    }

    @Override
    public void sendEmail(String msg, String to) {


        String FROM = "pojotav205@alvisani.com";
        String SUBJECT = "TSC Communication";
        String CONFIGSET = "ConfigSet";

        Destination destination = new Destination().withToAddresses(to);
        Content subject = new Content().withData(SUBJECT);
        Content bodyContent = new Content().withData(msg);
        Body body = new Body().withText(bodyContent);
        Message message = new Message().withSubject(subject).withBody(body);
        SendEmailRequest request = new SendEmailRequest().withSource(FROM).withDestination(destination).withMessage(message);
        try {
            AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient();
            client.setRegion(Region.getRegion(Regions.US_EAST_1));
            client.sendEmail(request);
        } catch (Exception e) {
            System.out.println("Unable to send email to " + to + " msg: " + msg + " : " + e.getMessage());
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
            //workaround for now
            /*existingMailModel.setOtp(newOtp);
            addMailModel(existingMailModel);
            stringBuilder.append("mail id already exists hence regenerated OTP");*/
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
            //mailModelDAO.delete(mailModel);
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
