package com.hcl.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.entity.JunitEntity;

@Repository
public interface JunitRepository extends CrudRepository<JunitEntity, Integer> {
	Optional<JunitEntity> findByUsername(String username);

	boolean existsByUsernameAndPassword(String username, String Password);
}
