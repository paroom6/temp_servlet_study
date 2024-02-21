package com.study.Todo_list.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.study.Todo_list.Dto.insertTodoListReqDto;

public class RequestUtil {
	public static <T> T ofJson(HttpServletRequest request, Class<T> classOfT) throws IOException {
		StringBuilder builder = new StringBuilder();
		String readData = null;
		Gson gson = new Gson();
		while ((readData = request.getReader().readLine()) != null) {
			builder.append(readData);
		}
		return gson.fromJson(builder.toString(), classOfT);
	}
}
