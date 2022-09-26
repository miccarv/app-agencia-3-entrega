import dao.ClientDao;
import dao.TravelDao;
import database.Database;
import model.Client;
import model.Travel;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

	public static void printClients(List<Client> clients) throws ParseException {
		out.println("---------------------------------");
		for (var client : clients) {
			out.println("Id: " + client.getId() + "\nNome: " + client.getFullName() + "\nEmail: " + client.getEmail()
					+ "\nEndereço: " + client.getAddress() + "\nEstado: " + client.getState());
			out.println("---------------------------------");
		}
	}

	public static void readPropsOfClient(Scanner scanner, Client client) throws ParseException {
		out.println("Informe o nome do Cliente: ");
		client.setFullName(scanner.next());
		out.println("Informe o email do Cliente: ");
		client.setEmail(scanner.next());
		out.println("Informe a senha do Cliente: ");
		client.setPassword(scanner.next());
		out.println("Informe o endereço do Cliente: ");
		client.setAddress(scanner.next());
		out.println("Informe o estado do Cliente: ");
		client.setState(scanner.next());
		client.setState(scanner.next());
	}

	public static long readIdOfClient(Scanner scanner) {
		out.println("Informe o ID do Cliente: ");
		return scanner.nextLong();
	}

	public static void printTravels(List<Travel> travels) throws ParseException {
		out.println("---------------------------------");
		for (var travel : travels) {
			out.println("\nDestino: " + travel.getDestiny() + "\nData: " + travel.getDate() + "\nDuração: "
					+ travel.getDuration() + "\nID Cliente: " + travel.getId());
			out.println("---------------------------------");
		}
	}

	public static void readPropsOfTravel(Scanner scanner, Travel travel) throws ParseException {
		out.println("Informe o destino desejado: ");
		travel.setDestiny(scanner.next());
		out.println("Informe a data da viagem (dd/mm/yyyy): ");
		travel.setDate(scanner.next());
		out.println("Informe a duração da viagem: ");
		travel.setDuration(scanner.next());
		out.println("Informe o ID do Cliente: ");
		travel.setId(scanner.next());
		travel.setId(scanner.next());
	}

	public static String readIdOfTravel(Scanner scanner) {
		out.println("Informe o ID do Cliente: ");
		return scanner.next();
	}

	public static int menu(Scanner scanner) {
		out.println("CLIENTES: \n" + "[1] - Consultar Todos os Registros\n" + "[2] - Inserir Registro\n"
				+ "[3] - Consultar Registro por ID\n" + "[4] - Deletar Registro por ID\n"
				+ "[5] - Atualizar registro por ID\n");
		out.println("---------------------------------");
		out.println("VIAGENS: \n" + "[6] - Consultar Todos os Registros\n" + "[7] - Inserir Registro\n"
				+ "[8] - Consultar Registro por ID\n" + "[9] - Deletar Registro por ID\n"
				+ "[10] - Atualizar registro por ID\n" + "[0] - Encerrar Programa");
		return scanner.nextInt();
	}

	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(in);
		ClientDao clientDao = new ClientDao(Database.createConnection());
		TravelDao travelDao = new TravelDao(Database.createConnection());

		out.println("------ ACESSO AO BANCO DE DADOS ------");
		var option = menu(scanner);

		while (option > 0 && option < 11) {
			switch (option) {
			case 1:
				printClients(clientDao.findAll());
				option = menu(scanner);
				break;
			case 2:
				Client client = new Client();
				readPropsOfClient(scanner, client);
				clientDao.create(client);
				option = menu(scanner);
				break;
			case 3:
				printClients(clientDao.findByPk(readIdOfClient(scanner)));
				option = menu(scanner);
				break;
			case 4:
				clientDao.delete(readIdOfClient(scanner));
				option = menu(scanner);
				break;
			case 5:
				Client clientToUpdate = new Client();
				clientToUpdate.setId(readIdOfClient(scanner));
				readPropsOfClient(scanner, clientToUpdate);
				clientDao.update(clientToUpdate);
				option = menu(scanner);
				break;
			case 6:
				printTravels(travelDao.findAll());
				option = menu(scanner);
				break;
			case 7:
				Travel travel = new Travel();
				readPropsOfTravel(scanner, travel);
				travelDao.create(travel);
				option = menu(scanner);
				break;
			case 8:
				printTravels(travelDao.findById(readIdOfClient(scanner)));
				option = menu(scanner);
				break;
			case 9:
				travelDao.delete(readIdOfClient(scanner));
				option = menu(scanner);
				break;
			case 10:
				Travel travelToUpdate = new Travel();
//				travelToUpdate.setId(readIdOfTravel(scanner));
				readPropsOfTravel(scanner, travelToUpdate);
				travelDao.update(travelToUpdate);
				option = menu(scanner);
				break;
			}
		}
	}
}
