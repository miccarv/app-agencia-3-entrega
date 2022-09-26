package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlCon;
import model.Viagem;

public class ViagemDao implements CRUD1 {

	private static Connection connection = MySqlCon.createConnection();
	private static String sql;

	public static void create(Viagem viagem) {
		sql = "INSERT INTO destination VALUES (null, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, viagem.getDestination());
			preparedStatement.setString(2, viagem.getDate());
			preparedStatement.setString(3, viagem.getDuration());
			preparedStatement.setString(4, viagem.getEmail());

			preparedStatement.executeUpdate();

			System.out.println("--correct insert on database");

		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}
	}

	public static void delete(int viagemId) {
		sql = "DELETE FROM destination WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, viagemId);
			preparedStatement.executeUpdate();

			System.out.println("--correct delete on destination");

		} catch (SQLException e) {
			System.out.println("--incorrect delete on destination. " + e.getMessage());
		}
	}

	public static List<Viagem> find(String search) {

		sql = String.format("SELECT * FROM destination WHERE email like '%s%%'", search);
		List<Viagem> viagens = new ArrayList<Viagem>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Viagem viagem = new Viagem();

				viagem.setId(resultSet.getInt("id"));
				viagem.setDestination(resultSet.getString("destination"));
				viagem.setEmail(resultSet.getString("email"));
				viagem.setDuration(resultSet.getString("duration"));
				viagem.setDate(resultSet.getString("date"));

				viagens.add(viagem);

			}

			System.out.println("--correct find in destination");
			return viagens;

		} catch (SQLException e) {
			System.out.println("--incorrect find in destination. " + e.getMessage());
			return null;
		}

	}

	public static Viagem findByPk(int viagemId) {
		sql = String.format("SELECT * FROM destination WHERE id = %d ", viagemId);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Viagem viagem = new Viagem();

			while (resultSet.next()) {
				viagem.setId(resultSet.getInt("id"));
				viagem.setDestination(resultSet.getString("destination"));
				viagem.setEmail(resultSet.getString("email"));
				viagem.setDate(resultSet.getString("date"));
				viagem.setDuration(resultSet.getString("duration"));
			}

			System.out.println("--correct find by pk destination");
			return viagem;

		} catch (SQLException e) {

			System.out.println("--incorrect find by pk destination. " + e.getMessage());
			return null;
		}
	}

	public static void update(Viagem viagem) {
		sql = "UPDATE destination SET destination=?, date=?, duration=?, email=? WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, viagem.getDestination());
			preparedStatement.setString(2, viagem.getDate());
			preparedStatement.setString(3, viagem.getDuration());
			preparedStatement.setString(4, viagem.getEmail());
			preparedStatement.setInt(5, viagem.getId());

			preparedStatement.executeUpdate();

			System.out.println("--correct update on database");

		} catch (SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());
		}
	}
}
