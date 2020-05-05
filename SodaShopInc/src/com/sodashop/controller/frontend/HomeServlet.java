package com.sodashop.controller.frontend;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> adminLogin

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD

@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String homepage = "frontend/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
		dispatcher.forward(request, response);
	}

	

=======
import com.sodashop.controller.Base;
import com.sodashop.dao.CategoryDAO;
import com.sodashop.entity.Category;

@WebServlet("")
public class HomeServlet extends Base {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//display the categories of soda
				CategoryDAO categoryDao = new CategoryDAO(entityManager);
				//get list of category objects
				List<Category> listCategory = categoryDao.listAll();
				//set it to attribute
				request.setAttribute("listCategory", listCategory);
		String homepage = "frontend/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
		dispatcher.forward(request, response); 
	}

>>>>>>> adminLogin
}
