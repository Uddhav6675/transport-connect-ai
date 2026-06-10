package com.transport.tms.load.domain.repository;

import com.transport.tms.load.domain.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoadRepository extends JpaRepository<Load, UUID> {

}
