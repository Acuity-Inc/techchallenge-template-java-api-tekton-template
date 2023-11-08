package com.acuity.templates.springboottemplate.repository;

import com.acuity.templates.springboottemplate.domain.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParentRepository extends JpaRepository<Parent, UUID> {
}
