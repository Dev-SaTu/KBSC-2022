package com.foch.springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foch.springserver.model.board.Board;
import com.foch.springserver.model.board.BoardDao;

@RestController
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	@GetMapping(value = "/board/")
	public Board findBoard(@Param("letterNum") int letterNum) {
		
		return boardDao.find("");
		
	}
	
	@PostMapping(value = "/board/write")
	public Board writeBoard(@RequestBody Board board) {
		
		return boardDao.save(board);
		
	}
	
}
