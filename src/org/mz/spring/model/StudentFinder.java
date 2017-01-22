package org.mz.spring.model;

import org.hibernate.validator.constraints.Range;

public class StudentFinder{
	@Range(min=0, max=100)
	private Integer physicsMarks2;

	@Range(min=0, max=100)
	private Integer chemistryMarks2;

	@Range(min=0, max=100)
	private Integer mathMarks2;

	private String physicsOperator;
	private String chemistryOperator;
	private String mathsOperator;

	public Integer getPhysicsMarks2() {
		return physicsMarks2;
	}
	public void setPhysicsMarks2(Integer physicsMarks2) {
		this.physicsMarks2 = physicsMarks2;
	}
	public Integer getChemistryMarks2() {
		return chemistryMarks2;
	}
	public void setChemistryMarks2(Integer chemistryMarks2) {
		this.chemistryMarks2 = chemistryMarks2;
	}
	public Integer getMathMarks2() {
		return mathMarks2;
	}
	public void setMathMarks2(Integer mathMarks2) {
		this.mathMarks2 = mathMarks2;
	}
	public String getPhysicsOperator() {
		return physicsOperator;
	}
	public void setPhysicsOperator(String physicsOperator) {
		this.physicsOperator = physicsOperator;
	}
	public String getChemistryOperator() {
		return chemistryOperator;
	}
	public void setChemistryOperator(String chemistryOperator) {
		this.chemistryOperator = chemistryOperator;
	}
	public String getMathsOperator() {
		return mathsOperator;
	}
	public void setMathsOperator(String mathsOperator) {
		this.mathsOperator = mathsOperator;
	}
}