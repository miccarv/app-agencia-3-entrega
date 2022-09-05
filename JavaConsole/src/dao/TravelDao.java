package dao;

import dto.TravelDtoMetadata;
import model.Travel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TravelDao {
	private static String sql;
	private final Connection connection;

	public TravelDao(Connection connection) {
		this.connection = connection;
	}

	public void create(Travel travel) {
		sql = "INSERT INTO %s VALUES (?, ?, ?, ?)";
		sql = String.format(sql, TravelDtoMetadata.tableName);

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setString(1, travel.getDestiny());
			preparedStatement.setString(2, travel.getDate());
			preparedStatement.setString(3, travel.getDuration());
			preparedStatement.setString(4, travel.getId());

			int result = preparedStatement.executeUpdate();
			System.out.printf("[LOG] Insert travel in database. Result: %s", result);

		} catch (SQLException e) {
			System.out.printf("[ERROR] Don't insert travel in database. Message:\n%s", e.getMessage());
		}
	}

	public List<Travel> findAll() {
		sql = "SELECT * FROM %s";
		sql = String.format(sql, TravelDtoMetadata.tableName);

		try {
			Statement statement = this.connection.createStatement();
			var result = statement.executeQuery(sql);
			List<Travel> travels = new ArrayList<>();

			while (result.next()) {
				Travel travel = new Travel();
				travel.setDestiny(result.getString(TravelDtoMetadata.destiny));
				travel.setDate(result.getString(TravelDtoMetadata.date));
				travel.setDuration(result.getString(TravelDtoMetadata.duration));
				travel.setId(result.getString(TravelDtoMetadata.id));
				travels.add(travel);
			}
			System.out.println("[LOG] Query all Travels in database.");
			return travels;

		} catch (SQLException e) {
			System.out.printf("[ERROR] Cant query all Travels in database. Message:\n%s", e.getMessage());
			return null;
		}
	}

	public List<Travel> findById(long travelId) {
		sql = "SELECT * FROM %s WHERE %s = ?";
		sql = String.format(sql, TravelDtoMetadata.tableName, TravelDtoMetadata.id);

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setLong(1, travelId);
			var result = preparedStatement.executeQuery();
			List<Travel> travels = new ArrayList<>();

			while (result.next()) {
				Travel travel = new Travel();
				travel.setDestiny(result.getString(TravelDtoMetadata.destiny));
				travel.setDate(result.getString(TravelDtoMetadata.date));
				travel.setDuration(result.getString(TravelDtoMetadata.duration));
				travel.setId(result.getString(TravelDtoMetadata.id));
				travels.add(travel);
			}

			System.out.println("[LOG] Query one travel in database.");
			return travels;

		} catch (SQLException e) {
			System.out.printf("[ERROR] Cant query one travel in database. Message:\n%s", e.getMessage());
			return null;
		}
	}

	public void delete(long travelId) {
		sql = "DELETE FROM %s WHERE %s = ?";
		sql = String.format(sql, TravelDtoMetadata.tableName, TravelDtoMetadata.id);

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setLong(1, travelId);
			preparedStatement.executeUpdate();
			System.out.println("[LOG] Successfully delete travel in database.");
		} catch (SQLException e) {
			System.out.printf("[ERROR] Cant delete travel in database. Message:\n%s", e.getMessage());
		}
	}

	public void update(Travel travel) {
		sql = "UPDATE %s " + "SET %s = ?, %s = ?, %s = ? " + "WHERE %s = ?";
		sql = String.format(sql, TravelDtoMetadata.tableName, TravelDtoMetadata.destiny, TravelDtoMetadata.date,
				TravelDtoMetadata.duration, TravelDtoMetadata.id);

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setString(1, travel.getDestiny());
			preparedStatement.setString(2, travel.getDate());
			preparedStatement.setString(3, travel.getDuration());
			preparedStatement.setString(4, travel.getId());
			preparedStatement.executeUpdate();
			System.out.println("[LOG] Successfully update travel in database.");
		} catch (SQLException e) {
			System.out.printf("[ERROR] Cant update travel in database. Message:\n%s", e.getMessage());
		}
	}
}
