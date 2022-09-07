package com.foch.springserver.model.donate;

import com.foch.springserver.model.store.Store;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DonateRepository extends CrudRepository<Store, String> {

    @Transactional
    @Query(value = "select * from Donate order by timestamp limit 1 desc", nativeQuery = true)
    int getPoint();

    @Modifying
    @Transactional
    @Query(value = "update donate set point = :point where ", nativeQuery = true)
    void changePoint(@Param("point")int point);
}


