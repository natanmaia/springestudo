package br.com.natanmaia.services;

import br.com.natanmaia.config.FileStorageConfig;
import br.com.natanmaia.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageConfig fileStorageConfig) {

        this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        }catch (Exception e){
            throw new FileStorageException("Could not create the directory where the upload files will be stored!", e);
        }
    }

    public String storeFile(MultipartFile multipartFile){
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        try {
            if (fileName.contains("..")){
                throw new FileStorageException("Sorry! FileName contains invalid path sequence. FileName: " + fileName);
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);

            Files.copy(multipartFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }catch (Exception e){
            throw new FileStorageException("Could not store file " + fileName + ". Please, try again!", e);
        }
    }
}
