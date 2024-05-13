package org.crm.crmproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@Log4j2
public class UpDownController {

    @Value("org.crm.crmproject.upload.path}")   // import 시에 springframework 로 시작하는 value
    private String uploadPath;

    @Operation(summary = "POST 방식으로 파일 등록", description = "POST 방식으로 파일 등록")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestPart MultipartFile[] multipartFile) {

        log.info(multipartFile);

        for (MultipartFile UploadFile : multipartFile) {
            String uploadFileName = UploadFile.getOriginalFilename();

            File saveFile = new File(uploadPath + uploadFileName);

            try {
                // void transferTo(File dest) throws IOException 업로드한 파일 데이터를 지정한 파일에 저장
                UploadFile.transferTo(saveFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


//        if (uploadFileDTO.getFiles() != null) {
//            uploadFileDTO.getFiles().forEach(multipartFile -> {
//
//                String originalName = multipartFile.getOriginalFilename();
//                log.info(originalName);
//
//                String uuid = UUID.randomUUID().toString();
//
//                Path savePath = Paths.get(uploadPath, uuid + "_" + originalName);
//
//                try {
//                    multipartFile.transferTo(savePath); // 실제 파일 저장
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            });
//        }
//        return null;
    }
}
