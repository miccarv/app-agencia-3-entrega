package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ViagemDao;

/**
 * Servlet implementation class ClienteDelete
 */
@WebServlet("/ViagemDelete")
public class ViagemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViagemDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int viagemId = Integer.parseInt(request.getParameter("viagemId"));
		ViagemDao.delete(viagemId);

		ViagemCreateAndFind viagemCreateAndFind = new ViagemCreateAndFind();
		viagemCreateAndFind.doGet(request, response);

	}

}
