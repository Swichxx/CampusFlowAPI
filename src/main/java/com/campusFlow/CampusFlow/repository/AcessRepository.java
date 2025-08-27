package com.campusFlow.CampusFlow.repository;

import com.campusFlow.CampusFlow.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessRepository extends JpaRepository<Access, Long> {
}
