package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form................");
	}

//	@PostMapping("/uploadFormAction")
//	public void uploadFormPost(MultipartFile uploadFile, Model model) {
//		log.info("file Name : " + uploadFile.getOriginalFilename());
//		log.info("file Size : " + uploadFile.getSize());
//
//		String uploadFolder = "C://upload//temp";
//
//		File saveFile = new File(uploadFolder, uploadFile.getOriginalFilename());
//
//		try {
//			uploadFile.transferTo(saveFile);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@PostMapping("/uploadAjaxAction")
	public ResponseEntity<List<AttachFileDTO>> uploadFormPost(MultipartFile[] uploadFile, Model model) {
		List<AttachFileDTO> list = new ArrayList<AttachFileDTO>();
		
		String uploadFolder = "C:\\upload\\temp";
		String uploadFolderPath = getFolder();

		// 년/월/일 폴더의 생성
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartFile : uploadFile) {

			AttachFileDTO attachDTO = new AttachFileDTO();
			
			log.info("-------------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());

			String uploadFileName = multipartFile.getOriginalFilename();

			attachDTO.setFileName(uploadFileName);
			// 중복 방지를 위한 UUID 적용
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;

//			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			File saveFile = new File(uploadPath, uploadFileName);

			try {
				multipartFile.transferTo(saveFile); // 파일 업로드 실행
				
				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);
				
				// 이미지 파일 체크
				if (checkImageType(saveFile)) {
					attachDTO.setImage(true);
					
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

					// Thumbnailator는 InputStream과 java.io.File 객체를 이용해서 파일을 생성할 수 있고, 뒤에 사이즈에 대한 부분을 파라미터로 witdh와 height를 지정할 수 있음
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

					thumbnail.close();
				}
				list.add(attachDTO);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		
		return new ResponseEntity<List<AttachFileDTO>>(list, HttpStatus.OK);
	}

	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}

	private String getFolder() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
