package com.hcl.service;

import java.util.Optional;

import com.hcl.entity.JunitEntity;

public interface JunitService {
	public JunitEntity update(JunitEntity user);
	public Optional<JunitEntity> findByUsername(String userid);
	public Optional<JunitEntity> findById(int userid);
	public boolean existsByUsernameAndPassword(String username,String password);
}
