package org.mz.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mz.spring.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImpl{

	private JdbcTemplate jdbcTemplate;

	public void addStudent(Student student){
		String sql="insert into markssheet(rollno,name,physics,chemistry,maths,user_pic_file_name)"+"values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql,student.getRollNumber(),student.getName(),student.getPhysicsMarks(),student.getChemistryMarks(),student.getMathsMarks(),student.getFileName());
	}

	public List<Student> getAllStudents(){
		String sql="select * from markssheet";
		return jdbcTemplate.query(sql,new StudentMapper());
	}
	public static final class StudentMapper implements RowMapper<Student>{
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			int rollNumber=Integer.parseInt(rs.getString(1));
			int physicsMarks=Integer.parseInt(rs.getString(3));
			int chemistryMarks=Integer.parseInt(rs.getString(4));
			int mathsMarks=Integer.parseInt(rs.getString(5));
			Student student=new Student();
			student.setRollNumber(rollNumber);
			student.setName(rs.getString(2));
			student.setPhysicsMarks(physicsMarks);
			student.setChemistryMarks(chemistryMarks);
			student.setMathsMarks(mathsMarks);
			return student;
		}

	}

	public List<Student> searchStudentRecord(Student student) {
		String name=student.getName();
		Integer rollno=student.getRollNumber();
		Integer physicsMarks=student.getPhysicsMarks();
		Integer chemistryMarks=student.getChemistryMarks();
		Integer mathsMarks=student.getMathsMarks();
		String physicsOperator=student.getPhysicsOperator();
		String chemistryOperator=student.getChemistryOperator();
		String mathsOperator=student.getMathsOperator();
		Integer physicsBetween=student.getPhysicsMarks2();
		Integer chemistryBetween=student.getChemistryMarks2();
		Integer mathsBetween=student.getMathMarks2();

		StringBuilder stringBuilderSearchQuery=new StringBuilder("select * from markssheet where");
		if(!name.isEmpty()){
			stringBuilderSearchQuery.append(" name= '");
			stringBuilderSearchQuery.append(name);
			stringBuilderSearchQuery.append("' and ");
		}
		if(rollno!=null){
			stringBuilderSearchQuery.append(" rollno= '");
			stringBuilderSearchQuery.append(rollno);
			stringBuilderSearchQuery.append("' and ");
		}
		if(physicsMarks != null){
			if(physicsOperator.equals("between")){
				stringBuilderSearchQuery.append(" physics ");
				stringBuilderSearchQuery.append(" between ");
				stringBuilderSearchQuery.append(physicsMarks);
				stringBuilderSearchQuery.append(" and ");
				stringBuilderSearchQuery.append(physicsBetween);
				stringBuilderSearchQuery.append(" and ");
			}
			else{
				stringBuilderSearchQuery.append(" physics ");
				stringBuilderSearchQuery.append(physicsOperator);
				stringBuilderSearchQuery.append(physicsMarks );
				stringBuilderSearchQuery.append(" and ");

			}
		}
		if(chemistryMarks != null){
			if(physicsOperator.equals("between")){
				stringBuilderSearchQuery.append(" chemistry ");
				stringBuilderSearchQuery.append(" between ");
				stringBuilderSearchQuery.append(chemistryMarks);
				stringBuilderSearchQuery.append(" and ");
				stringBuilderSearchQuery.append(chemistryBetween);
				stringBuilderSearchQuery.append(" and ");
			}
			else{
				stringBuilderSearchQuery.append(" chemistry ");
				stringBuilderSearchQuery.append(chemistryOperator);
				stringBuilderSearchQuery.append(chemistryMarks );
				stringBuilderSearchQuery.append(" and ");
			}
		}
		if(mathsMarks != null){
			if(physicsOperator.equals("between")){
				stringBuilderSearchQuery.append(" maths ");
				stringBuilderSearchQuery.append(" between ");
				stringBuilderSearchQuery.append(mathsMarks);
				stringBuilderSearchQuery.append(" and ");
				stringBuilderSearchQuery.append(mathsBetween);
				stringBuilderSearchQuery.append(" and ");
			}
			else{
				stringBuilderSearchQuery.append(" maths ");
				stringBuilderSearchQuery.append(mathsOperator);
				stringBuilderSearchQuery.append(mathsMarks);
				stringBuilderSearchQuery.append(" and ");
			}
		}
		String sql=stringBuilderSearchQuery.substring(0, stringBuilderSearchQuery.length()-5);
		return jdbcTemplate.query(sql,new StudentMapper());
	}

	public String deleteStudent(int studentRoll) {
		String sql="DELETE FROM markssheet WHERE rollno="+studentRoll;
		jdbcTemplate.execute(sql);
		return "success";
	}

	public void updateStudent(Student student) {
		String sql="UPDATE markssheet SET name='"+student.getName()+"',physics="+student.getPhysicsMarks()+",chemistry="+student.getChemistryMarks()+",maths="+student.getMathsMarks()+" WHERE rollno="+student.getRollNumber();
		jdbcTemplate.execute(sql);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
