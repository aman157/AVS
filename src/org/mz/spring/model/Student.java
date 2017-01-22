package org.mz.spring.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.mz.spring.annotation.IsValidImage;
import org.springframework.web.multipart.MultipartFile;

public class Student extends StudentFinder{
	@NotEmpty
	@Size(min=3,max=20)
	@Pattern(regexp = "^[a-zA-Z]+")
	private String name;

	@NotNull
	private Integer rollNumber;

	@NotNull
	@Range(min=0, max=100)
	private Integer physicsMarks;

	@NotNull
	@Range(min=0, max=100)
	private Integer chemistryMarks;

	@NotNull
	@Range(min=0, max=100)
	private Integer mathsMarks;

	@IsValidImage(fileName = "jpg|JPG|PNG|png", fileSize = 900000)
	private MultipartFile file;
	
	private String fileName;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}
	public Integer getPhysicsMarks() {
		return physicsMarks;
	}
	public void setPhysicsMarks(Integer physicsMarks) {
		this.physicsMarks = physicsMarks;
	}
	public Integer getChemistryMarks() {
		return chemistryMarks;
	}
	public void setChemistryMarks(Integer chemistryMarks) {
		this.chemistryMarks = chemistryMarks;
	}
	public Integer getMathsMarks() {
		return mathsMarks;
	}
	public void setMathsMarks(Integer mathsMarks) {
		this.mathsMarks = mathsMarks;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}