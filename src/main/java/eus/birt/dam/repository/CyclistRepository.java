package eus.birt.dam.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eus.birt.dam.domain.Cyclist;

public interface CyclistRepository extends JpaRepository<Cyclist, Long>{
	
}