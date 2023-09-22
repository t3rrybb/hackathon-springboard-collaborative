package org.springboard.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class S3FileServiceImpl implements S3FileService {

    @Value("${bucketName}")
    private String bucketName;

    @Autowired
    AmazonS3 amazonS3;

    public String saveFile(MultipartFile multipartFile, String serviceProviderName) {
        int count = 0;
        int maxTries = 3;
        deleteFile(serviceProviderName);
        while(true) {
            try {
                File file = convertMultiPartToFile(multipartFile);
                PutObjectResult putObjectResult = amazonS3.putObject(bucketName, serviceProviderName, file);
                System.out.println("Object hash : " + putObjectResult.getContentMd5());
                return amazonS3.getUrl(bucketName, serviceProviderName).toString();
            } catch (IOException e) {
                if (++count == maxTries) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public byte[] downloadFile(String serviceProviderName) {
        S3Object object = amazonS3.getObject(bucketName, serviceProviderName);
        S3ObjectInputStream objectContent = object.getObjectContent();
        try {
            return IOUtils.toByteArray(objectContent);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
    public String deleteFile(String serviceProviderName) {
        amazonS3.deleteObject(bucketName, serviceProviderName);
        return "File deleted";
    }
}
