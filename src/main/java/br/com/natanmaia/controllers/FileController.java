package br.com.natanmaia.controllers;

import br.com.natanmaia.data.vo.UploadFileResponseVO;
import br.com.natanmaia.services.FileStorageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Api(tags = "FileEndPoint")
@RestController
@RequestMapping("api/v1/file")
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("uploadFile")
    public UploadFileResponseVO uploadFile(@RequestParam("file") MultipartFile file){

        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/v1/file/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponseVO(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }
}
