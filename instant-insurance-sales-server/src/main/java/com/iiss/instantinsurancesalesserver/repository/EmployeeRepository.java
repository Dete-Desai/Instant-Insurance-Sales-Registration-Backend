package com.iiss.instantinsurancesalesserver.repository;

import com.iiss.instantinsurancesalesserver.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

    public boolean existsByFirstNameAndLastName(String firstNAme, String lastName);

    public boolean existsById(int id);
}
