package com._concept.Gobank.repository;

import com._concept.Gobank.model.UserAdmin;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAdmin, Long> {
}
