package org.mz.spring.annotation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class ImageValidator implements ConstraintValidator<IsValidImage,MultipartFile> {

	private String fileName;
	private long fileSize;

	@Override
	public void initialize(IsValidImage validImage) {
		this.fileName=validImage.fileName();
		this.fileSize=validImage.fileSize();
	}

	@Override
	public boolean isValid(MultipartFile  multipartFile, ConstraintValidatorContext context) {

		if(multipartFile==null||multipartFile.isEmpty()){
			return false;
		}
		else{
			String fileNameOriginal=multipartFile.getOriginalFilename();
			String[] nameSplit=fileNameOriginal.split(Pattern.quote("."));
			String extension=nameSplit[1];
			long size=multipartFile.getSize();
			if(extension.matches(fileName) && (size<=fileSize)){
				return true;
			}
			else{
				return false;
			}
		}
	}
}
