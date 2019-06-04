package com.project.calc.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.calc.entity.Data;

@Repository
public interface DataDAO extends JpaRepository<Data, Long> {

}
