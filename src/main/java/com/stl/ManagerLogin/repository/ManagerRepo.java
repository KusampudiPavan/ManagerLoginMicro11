package com.stl.ManagerLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stl.ManagerLogin.model.Loginmodel;

public interface ManagerRepo extends JpaRepository<Loginmodel, String>{

}
