package com.sodashop.controller.admin.category;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.sodashop.controller.admin.Base;
import com.sodashop.service.CategoryServ;
import com.sodashop.service.UserServ;
=======
import com.sodashop.controller.Base;
import com.sodashop.service.CategoryServ;
>>>>>>> adminLogin


@WebServlet("/admin/edit_category")
public class EditCategory extends Base {
	private static final long serialVersionUID = 1L;
 
    public EditCategory() {
       
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		CategoryServ categoryServ = new CategoryServ(entityManager,request, response);
		categoryServ.editCategory();
		
=======
			CategoryServ categoryServ = new CategoryServ(entityManager,request, response);
			categoryServ.editCategory();

>>>>>>> adminLogin
	}

}
