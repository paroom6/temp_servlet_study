package com.study.Todo_list.Dto;


import java.sql.Date;
import java.text.ParseException;

import com.study.Todo_list.entity.TodoList;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class insertTodoListReqDto {//입력 받은 객체
	private String 	todo_content;
	private String todo_summary;
	private String todo_date_str;
	private String todo_priority;
	private Date todo_date;
	public TodoList toTodoList() {
		todo_date = Date.valueOf(todo_date_str);
		return TodoList.builder()
				.todo_content(todo_content)
				.todo_summary(todo_summary)
				.todo_date(todo_date)
				.todo_priority(todo_priority)
				.build();
	}
}
