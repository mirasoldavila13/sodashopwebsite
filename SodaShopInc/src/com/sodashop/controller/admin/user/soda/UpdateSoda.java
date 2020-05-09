package com.sodashop.controller.admin.user.soda;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodashop.controller.Base;
import com.sodashop.service.SodaServ;

@WebServlet("/admin/update_soda")
@MultipartConfig(
		fileSizeThreshold = 1024 * 10,	// 10 KB
		maxFileSize = 1024 * 300,		// 300 KB
		maxRequestSize = 1024 * 1024	// 1 MB 
)
public class UpdateSoda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public UpdateSoda() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SodaServ sodaServ = new SodaServ(request, response);
		sodaServ.updateSoda();
	}

}
