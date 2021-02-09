package com.hcl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.entity.JunitEntity;
import com.hcl.repository.JunitRepository;


@Service
public class JunitServiceImpl implements JunitService {
	@Autowired
	private JunitRepository repository;

	@Override
	public JunitEntity update(JunitEntity user) {
		return repository.save(user);
	}

	@Override
	public Optional<JunitEntity> findByUsername(String userid) {
		return repository.findByUsername(userid);
	}

	@Override
	public boolean existsByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return repository.existsByUsernameAndPassword(username, password);
	}

	@Override
	public Optional<JunitEntity> findById(int userid) {
		return repository.findById(userid);
	}
}
