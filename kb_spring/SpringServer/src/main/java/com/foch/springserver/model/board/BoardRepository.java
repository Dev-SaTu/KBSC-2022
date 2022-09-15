package com.foch.springserver.model.board;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, String>  {

	@Transactional
	@Query(value = "SELECT * FROM Board WHERE title like %:title%", nativeQuery = true)
	List<Board> getBoards();
	
}
