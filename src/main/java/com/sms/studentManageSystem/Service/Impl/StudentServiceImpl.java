package com.sms.studentManageSystem.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.studentManageSystem.Entity.Student;
import com.sms.studentManageSystem.Repository.IStudentRepository;
import com.sms.studentManageSystem.Service.IStudentService;

@Service
public class StudentServiceImpl  implements IStudentService{
    
	 private IStudentRepository studentRepository;
	 
	 @Autowired
	public StudentServiceImpl(IStudentRepository studentRepository) {
	
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
	}
	

}
