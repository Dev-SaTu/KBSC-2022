package com.foch.springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foch.springserver.model.board.Board;
import com.foch.springserver.model.board.BoardDao;

@RestController
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	@GetMapping(value = "/board/{letterNum}")
	public Board findBoard(@PathVariable("letterNum") String letterNum) {
		
		return boardDao.find(letterNum);
		
	}
	
	@PostMapping(value = "/board/write")
	public Board writeBoard(@RequestBody Board board) {
		
		return boardDao.save(board);
		
	}
	
}
