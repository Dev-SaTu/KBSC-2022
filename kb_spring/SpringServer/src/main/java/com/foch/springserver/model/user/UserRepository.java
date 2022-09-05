package com.foch.springserver.model.user;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    @Modifying
    @Transactional
    @Query(value = "update user set type = :type where user.id = :name", nativeQuery = true)
    void changeValue(@Param("name") String username, @Param("type") int type);

    @Modifying
    @Transactional
    @Query(value = "update user set point = :point where user.id = :id", nativeQuery = true)
    void changePoint(@Param("point") int point, @Param("id") String id);


    @Modifying
    @Transactional
    @Query(value = "update user set pw = :password where user.id = :id", nativeQuery = true)
    void changePw(@Param("password") String password, @Param("id") String id);
}
