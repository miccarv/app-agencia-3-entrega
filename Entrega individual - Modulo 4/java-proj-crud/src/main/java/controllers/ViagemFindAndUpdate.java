package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ViagemDao;
import model.Viagem;

/**
 * Servlet implementation class ClienteFindAndUpdate
 */
@WebServlet("/ViagemUpdate")
public class ViagemFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViagemFindAndUpdate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int viagemId = Integer.parseInt(request.getParameter("viagemId"));
		Viagem viagem = ViagemDao.findByPk(viagemId);

		request.setAttribute("viagem", viagem);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formViagemUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Viagem viagem = new Viagem();

		viagem.setId(Integer.parseInt(request.getParameter("id")));
		viagem.setDestination(request.getParameter("destination"));
		viagem.setDate(request.getParameter("date"));
		viagem.setDuration(request.getParameter("duration"));
		viagem.setEmail(request.getParameter("email"));

		ViagemDao.update(viagem);

		ViagemCreateAndFind viagemCreateAndFind = new ViagemCreateAndFind();
		viagemCreateAndFind.doGet(request, response);
	}

}
