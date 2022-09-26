package dao;

import java.util.List;

import model.Viagem;

public interface CRUD1 {

	public static void create(Viagem viagem) {
	};

	public static void delete(int viagemId) {
	};

	public static List<Viagem> find(String search) {
		return null;
	}

	public static Viagem findByPk(int viagemId) {
		return null;
	}

	public static void update(Viagem viagem) {
	}
}
