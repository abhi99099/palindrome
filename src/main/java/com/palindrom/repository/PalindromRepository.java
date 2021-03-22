package com.palindrom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palindrom.model.Palindrom;

@Repository
public interface PalindromRepository extends CrudRepository<Palindrom, Long>{

	Palindrom findByName(String input);

}
