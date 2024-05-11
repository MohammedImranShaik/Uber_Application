package com.uber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uber.entity.UberEntity;

@Repository
public interface UberJpaRepository extends JpaRepository<UberEntity, Integer> {

	UberEntity findByEmail(String email);

}
