package com.foch.springserver.model.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDao {

	@Autowired
    private BoardRepository repository;
	
	public Board find(String id) {
    	return repository.findById(id).get();
    }
	
    public Board save(Board board) {
    	return repository.save(board);
    }
    
    public void delete(String boardId) {
    	repository.delete(find(boardId));
    }
	
}
