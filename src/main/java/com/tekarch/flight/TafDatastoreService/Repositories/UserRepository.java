package com.tekarch.flight.TafDatastoreService.Repositories;

import com.tekarch.flight.TafDatastoreService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}