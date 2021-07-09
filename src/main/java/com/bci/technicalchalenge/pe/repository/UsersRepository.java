package com.bci.technicalchalenge.pe.repository;

import com.bci.technicalchalenge.pe.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends CrudRepository<Users, UUID> {

  Optional<List<Users>> findByEmail(String email);

}
