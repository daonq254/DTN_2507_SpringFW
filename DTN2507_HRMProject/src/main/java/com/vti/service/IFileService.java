package com.vti.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

	String upLoadImage(MultipartFile image, short id) throws IllegalStateException, IOException;

}
