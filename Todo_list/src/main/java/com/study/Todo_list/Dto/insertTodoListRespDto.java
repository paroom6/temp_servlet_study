package com.study.Todo_list.Dto;


import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class insertTodoListRespDto { //입력후 서버로 돌려줄 객체
	private int todo_id;
	private String todo_content;
	private String todo_summary;
	private Date todo_date;
	private String todo_priority;
	private int successCount;
	
}
