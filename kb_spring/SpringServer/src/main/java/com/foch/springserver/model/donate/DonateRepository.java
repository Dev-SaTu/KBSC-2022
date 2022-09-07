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

    @Modifying
    @Transactional
    @Query(value = "select * from store where location like %:location% order by rand() limit 5", nativeQuery = true)
    List<Store> searchStoresWithLocation(@Param("location")String location);
}


