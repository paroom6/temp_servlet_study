package com.study.Todo_list.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.Todo_list.Dto.insertTodoListReqDto;
import com.study.Todo_list.Dto.insertTodoListRespDto;
import com.study.Todo_list.service.TodoListService;
import com.study.Todo_list.util.RequestUtil;
import com.study.Todo_list.util.ResponseEntity;

/**
 * Servlet implementation class insertTodoListServlet
 */
@WebServlet("/todoList/addition")
public class insertTodoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TodoListService todoListService;
    public insertTodoListServlet() {
        super();
        todoListService = TodoListService.getInstance();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		insertTodoListReqDto dto = RequestUtil.ofJson(request, insertTodoListReqDto.class);
		insertTodoListRespDto insertTodoListRespDto = todoListService.addList(dto);
		System.out.println(insertTodoListRespDto.toString());
		
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("data",dto);
		ResponseEntity.ofJson(response, responseMap , 201);
		return;
		
	}

}
