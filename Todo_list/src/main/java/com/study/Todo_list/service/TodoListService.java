package com.study.Todo_list.service;

import com.study.Todo_list.Dto.insertTodoListReqDto;
import com.study.Todo_list.Dto.insertTodoListRespDto;
import com.study.Todo_list.entity.TodoList;
import com.study.Todo_list.repository.TodoListRepository;

public class TodoListService {
	private TodoListRepository todoListRepository;
	private static TodoListService instance;
	
	private TodoListService() {
		todoListRepository = TodoListRepository.getInstance();
	}
	
	public static TodoListService getInstance() {
		if(instance == null) {
			instance = new TodoListService();
		}
		return instance;
	}
	public insertTodoListRespDto addList(insertTodoListReqDto dto) {
		TodoList list = dto.toTodoList();
		return list.toDto(todoListRepository.addTodoList(list));
	}
}
