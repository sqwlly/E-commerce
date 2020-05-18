package com.ecommerce.demo.service;

import com.ecommerce.demo.Repository.FileRepository;
import com.ecommerce.demo.model.UpLoadFile;
import org.springframework.beans.factory.annotation.Autowired;

public class FileService {
    @Autowired
    FileRepository fileRepository;

    void save(UpLoadFile upLoadFile) {
        fileRepository.save(upLoadFile);
    }

    void delete(UpLoadFile upLoadFile) {
        fileRepository.delete(upLoadFile);
    }

    UpLoadFile findFileById(String ID) {
        return fileRepository.findById(ID).get();
    }
}
