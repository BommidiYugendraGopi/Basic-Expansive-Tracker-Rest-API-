package com.Vcube.ExpanceTrackerAPI.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Vcube.ExpanceTrackerAPI.module.Expance;
@Repository

public interface ExpanceRepo extends JpaRepository<Expance,Integer>{

}
