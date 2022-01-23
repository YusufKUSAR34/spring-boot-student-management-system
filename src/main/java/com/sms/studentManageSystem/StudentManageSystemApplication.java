package com.sms.studentManageSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sms.studentManageSystem.Entity.Student;
import com.sms.studentManageSystem.Repository.IStudentRepository;


@SpringBootApplication
public class StudentManageSystemApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManageSystemApplication.class, args);
	}
	
	  @Autowired
		 private IStudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		
	//	Student student1=new Student("Muhammed","KUŞAR","muhammed@gmail.com");
		//studentRepository.save(student1);
		
	}

}
