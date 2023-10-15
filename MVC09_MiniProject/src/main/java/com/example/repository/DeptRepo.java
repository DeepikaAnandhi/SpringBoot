package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Dept;

@Repository
public interface DeptRepo extends JpaRepository<Dept, Integer> {

	@Query("SELECT deptno from Dept")
	public List<Integer> fetchAllDeptNo();
}
