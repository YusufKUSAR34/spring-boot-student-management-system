package com.sms.studentManageSystem.Repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.sms.studentManageSystem.Entity.Student;


public interface IStudentRepository extends JpaRepository<Student,Long> {

	
}
