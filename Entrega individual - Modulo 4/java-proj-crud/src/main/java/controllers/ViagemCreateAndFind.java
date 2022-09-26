package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ViagemDao;
import model.Viagem;

@WebServlet("/ViagemCreateAndFind")
public class ViagemCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViagemCreateAndFind() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String search = request.getParameter("search");

		if (search == null) {
			search = "";
		}

		List<Viagem> viagens = ViagemDao.find(search);

		request.setAttribute("viagens", viagens);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("listaViagens.jsp");
		resquesDispatcher.forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Viagem viagem = new Viagem();

		viagem.setDestination(request.getParameter("destination"));
		viagem.setDate(request.getParameter("date"));
		viagem.setDuration(request.getParameter("duration"));
		viagem.setEmail(request.getParameter("email"));

		ViagemDao.create(viagem);

		doGet(request, response);
	}

}
