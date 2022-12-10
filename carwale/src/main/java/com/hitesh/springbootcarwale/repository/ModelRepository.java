package com.hitesh.springbootcarwale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hitesh.springbootcarwale.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

}
