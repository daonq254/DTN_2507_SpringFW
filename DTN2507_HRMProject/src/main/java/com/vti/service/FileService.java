package com.vti.service;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import com.vti.utils.FileManager;

@Service
public class FileService implements IFileService {
	@Autowired
	private IAccountRepository accountRepository;
	private FileManager fileManager = new FileManager();

	private String linkFolder = "G:\\My Drive\\1. DNQ_VTI\\9. BACKEND CHUYÊN SÂU\\3. Spring FW\\2. TL TH DAONQ\\LAB_25_Upload File\\File_Demo\\Upload";

	@Override
	public String upLoadImage(MultipartFile image, short id) throws IllegalStateException, IOException {
		String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(image.getOriginalFilename());
//		Lưu ảnh vào thư mục trên Backend
		String path = linkFolder + "\\" + nameImage;
		fileManager.createNewMultiPartFile(path, image);

//		Lưu tên ảnh vào DB
		Account account = accountRepository.getById(id);
		account.setPathImage(nameImage);
		accountRepository.save(account);

		return path;
	}

}
