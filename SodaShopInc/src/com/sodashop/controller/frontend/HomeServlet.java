package com.sodashop.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.dao.CategoryDAO;
import com.sodashop.dao.SodaDAO;
import com.sodashop.entity.Category;
import com.sodashop.entity.Soda;

@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//display the categories of soda
				CategoryDAO categoryDao = new CategoryDAO();
				SodaDAO sodaDAO = new SodaDAO();
				List<Category> listCategory = categoryDao.listAll();
				List<Soda> listNewSoda = sodaDAO.listNewSoda();

				//set it to attribute
				request.setAttribute("listCategory", listCategory);
				request.setAttribute("listNewSoda", listNewSoda);
		String homepage = "frontend/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
		dispatcher.forward(request, response); 
	}

}
