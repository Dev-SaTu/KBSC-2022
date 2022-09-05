package com.foch.springserver.welfare;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareRepository extends CrudRepository<Welfare, String>  {
    
}
