package com.sms.studentManageSystem.Service;

import java.util.List;

import com.sms.studentManageSystem.Entity.Student;

public interface IStudentService {
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
}
