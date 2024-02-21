package com.study.Todo_list.entity;


import java.sql.Date;

import com.study.Todo_list.Dto.insertTodoListRespDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class TodoList {//기본 객체
	private int todo_id;
	private String todo_content;
	private String todo_summary;
	private Date todo_date;
	private String todo_priority;
	
	public insertTodoListRespDto toDto(int successCount) {
		return insertTodoListRespDto.builder()
								.todo_id(todo_id)
								.todo_content(todo_content)
								.todo_summary(todo_summary)
								.todo_date(todo_date)
								.todo_priority(todo_priority)
								.successCount(successCount)
								.build();
	}
}