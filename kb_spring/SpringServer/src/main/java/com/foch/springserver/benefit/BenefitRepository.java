package com.foch.springserver.benefit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends CrudRepository<Benefit, String>  {
    
}
