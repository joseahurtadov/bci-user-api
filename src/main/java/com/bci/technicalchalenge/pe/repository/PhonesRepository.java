package com.bci.technicalchalenge.pe.repository;

import com.bci.technicalchalenge.pe.entity.Phones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends CrudRepository<Phones, Long> {

}
