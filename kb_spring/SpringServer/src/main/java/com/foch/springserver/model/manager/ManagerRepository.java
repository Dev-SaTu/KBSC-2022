package com.foch.springserver.model.manager;

import com.foch.springserver.model.store.Store;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ManagerRepository extends CrudRepository<Store, String> {

    @Transactional
    @Query(value = "select * from manager order by updated_dt desc limit 1", nativeQuery = true)
    Manager getPoint();

    @Transactional
    @Query(value = "select * from manager order by updated_dt", nativeQuery = true)
    List<Manager> getManagers();

    @Modifying
    @Transactional
    @Query(value = "update manager set point = :point where ", nativeQuery = true)
    void changePoint(@Param("point")int point);
}


