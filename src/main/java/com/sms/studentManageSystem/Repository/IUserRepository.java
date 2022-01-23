package com.sms.studentManageSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.studentManageSystem.Entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
      User findByEmail(String email);
}
