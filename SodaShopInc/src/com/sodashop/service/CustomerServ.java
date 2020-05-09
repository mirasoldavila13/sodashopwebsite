package com.sodashop.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sodashop.dao.CategoryDAO;
import com.sodashop.dao.CustomerDAO;
import com.sodashop.dao.OrderDAO;
import com.sodashop.dao.ReviewDAO;
import com.sodashop.entity.Customer;

public class CustomerServ {
	private CustomerDAO customerDAO;
	private ReviewDAO reviewDAO;
	private OrderDAO orderDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public CustomerServ(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		// this is the instance of UserDAO class
		customerDAO = new CustomerDAO();
	}
	public void listCustomers(String message) throws ServletException, IOException {
		List<Customer> listCustomer = customerDAO.listAll();		
		request.setAttribute("listCustomer", listCustomer);
		String listPage = "customer_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	
	public void listCustomers() throws ServletException, IOException {
		listCustomers(null);
	}
	
	public void createCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerDAO.findByEmail(email);
	

			if (existCustomer != null) {
				String message = "Could not create new customer: the email "
						+ email + " is already registered by another customer.";
				listCustomers(message);
				
			} else {
				Customer newCustomer = new Customer();
				updateCustomerFieldsFromForm(newCustomer);
				customerDAO.create(newCustomer);
				
				String message = "New customer has been created successfully.";
				listCustomers(message);
			}
	}

	private void updateCustomerFieldsFromForm(Customer customer) {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipCode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		
		if (email != null && !email.equals("")) {
			customer.setEmail(email);
		}
		
		customer.setFullname(fullName);
		
		if (password != null && !password.equals("")) {
			customer.setPassword(password);
		}
		
		customer.setPhone(phone);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setZipcode(zipCode);
		customer.setCountry(country);		
	}

 	public void registerCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerDAO.findByEmail(email);
		String message = "";
		
		if (existCustomer != null) {
			message = "Could not register. The email "
					+ email + " is already registered by another customer.";
			message = "frontend/message.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(message);
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		} else {
			
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromForm(newCustomer);			
			customerDAO.create(newCustomer);
			
			message = "You have registered successfully! Thank you.<br/>";	
			String messagePage = "frontend/message.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		}
		
		
		
	}	
	
	public void editCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDAO.get(customerId);
		
		if (customer == null) {
			String message = "Could not find customer with ID " + customerId;
			RequestDispatcher dispatcher = request.getRequestDispatcher(message);
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("customer", customer);	
			String displayPage ="customer_form.jsp";

			RequestDispatcher dispatcher = request.getRequestDispatcher(displayPage);
			dispatcher.forward(request, response);
		}		
	}

	public void updateCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("customerId"));
		String email = request.getParameter("email");
		
		Customer customerByEmail = customerDAO.findByEmail(email);
		String message = null;
		
		if (customerByEmail != null && customerByEmail.getCustomerId() != customerId) {
			message = "Could not update the customer ID " + customerId
					+ "because there's an existing customer having the same email.";
			
		} else {
			
			Customer customerById = customerDAO.get(customerId);
			updateCustomerFieldsFromForm(customerById);
			
			customerDAO.update(customerById);
			
			message = "The customer has been updated successfully.";
		}
		
		listCustomers(message);
	}

	public void deleteCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDAO.get(customerId);
		
		if (customer != null) {
			long reviewCount = reviewDAO.countByCustomer(customerId);
			
			if (reviewCount > 0) {
				String message = "Could not delete customer with ID " + customerId
						+ " because he/she posted reviews for books.";
				RequestDispatcher dispatcher = request.getRequestDispatcher(message);
				dispatcher.forward(request, response);
			} else {
				long orderCount = orderDAO.countByCustomer(customerId);
				
				if (orderCount > 0) {
					String message = "Could not delete customer with ID " + customerId 
							+ " because he/she placed orders.";
					RequestDispatcher dispatcher = request.getRequestDispatcher(message);
					dispatcher.forward(request, response);
				} else {
					customerDAO.delete(customerId);			
					String message = "The customer has been deleted successfully.";
					listCustomers(message);
				}
			}
		} else {
			String message = "Could not find customer with ID " + customerId + ", "
					+ "or it has been deleted by another admin";
			RequestDispatcher dispatcher = request.getRequestDispatcher(message);
			dispatcher.forward(request, response);		
			
		}
		
	}

	public void showLogin() throws ServletException, IOException {
		String loginPage ="frontend/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
		dispatcher.forward(request, response);
	}

	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer = customerDAO.checkLogin(email, password);
		if(customer == null) {
			String message = "Login failed";
			request.setAttribute("message", message);
			showLogin();
		}
		else {
			request.getSession().setAttribute("loggedCustomer", customer);
			showCustomerProfile();

		}
			
		
	}
	
	public void showCustomerProfile() throws ServletException, IOException {
		String profilePage ="frontend/customer_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(profilePage);
		dispatcher.forward(request, response);
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		String editPage ="frontend/customer_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		updateCustomerFieldsFromForm(customer);
		customerDAO.update(customer);
		showCustomerProfile();
		
	}
}
