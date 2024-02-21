package com.study.product.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.study.product.dao.ProductDao;
import com.study.product.dto.insertProductReqDto;
import com.study.product.utils.RequestUtil;
import com.study.product.vo.Product;


@WebServlet("/user")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertProductServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		insertProductReqDto reqDto = insertProductReqDto.builder().build();
//		Product product = Product.builder().build();
		try {
			reqDto = RequestUtil.convertJsonData(request, insertProductReqDto.class);		
		} catch ( Exception e) {
			Map<String, Object> errorMap = new HashMap<>();
			System.out.println(123);
			errorMap.put("errorMasseage","정보를 정확히 입력하세요.");
			response.setStatus(400);
			response.setContentType("application/json");
			response.getWriter().println(gson.toJson(errorMap));
			return;
		}
		System.out.println(reqDto);
		ProductDao dao = ProductDao.getInstance();
		int result = dao.addProduct(reqDto);
		if(result == 0) {
			Map<String, Object> errorMap = new HashMap<>();
			errorMap.put("errorMasseage","등록되지 않았습니다.");
			
			response.setStatus(400);
			response.setContentType("application/json");
			response.getWriter().println(gson.toJson(errorMap));
			return;
		}
		Map<String, Object> Map = new HashMap<>();
		Map.put("Masseage","등록완료.");

		response.setStatus(201);
		response.setContentType("application/json");
		response.getWriter().println(gson.toJson(Map));
	}

}
