package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;

@WebServlet("/ClienteRemove")
public class ClienteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClienteDelete() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		ClienteDao.delete(clienteId);

		ClienteCreateFind clienteCreateFind = new ClienteCreateFind();
		clienteCreateFind.doGet(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
