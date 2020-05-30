package com.example.demo.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.SpringUser;

@EnableScan
public interface SpringUserRepository extends CrudRepository<SpringUser, String> {
	List<SpringUser> findByLastName(String lastName);
}
