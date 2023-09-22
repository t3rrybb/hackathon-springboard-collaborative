package org.springboard.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3FileService {

    String saveFile(MultipartFile multipartFile, String serviceProviderName);

    byte[] downloadFile(String serviceProviderName);


    String deleteFile(String serviceProviderName);

}
