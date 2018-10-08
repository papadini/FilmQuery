package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public FilmQueryApp() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();

	}

//  private void test() throws SQLException {
//    Film film = db.getFilmById(1);
//    Actor actor = db.getActorById(1);
//   
//    List<Film> filmKeyword = db.getFilmByKeyword("l");
//    for (Film film2 : filmKeyword) {
//		System.out.println(film2);
//	}

//    System.out.println(film);
//    System.out.println(actor);
//  }

	private void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {
		boolean exit = false;
		while (exit != true) {
			menu();
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the film id you would like to get info on.");
				int filmID = input.nextInt();
				Film film = db.getFilmById(filmID);
				if (film != null) {
					System.out.println(film);
				} else {
					System.out.println("There is no film with that id");
				}
				break;

			case 2:
				System.out.println("Enter keyword to search films by.");
				String keyword = input.next();
				List<Film> filmKeyword = db.getFilmByKeyword(keyword);
				if (filmKeyword.size() != 0) {
					for (Film film2 : filmKeyword) {
						System.out.println(film2);
					}
				} else {
					System.out.println("There is no film with that id");

				}

				break;
			case 3: exit = true;
				break;

			default:
				System.out.println("Invalid Option");
			}
		}

	}

	public void menu() {
		for (int i = 0; i < 10; i++) {
			System.out.print("\uD83C\uDFA6");
		}
		System.out.println();
		System.out.println("1) search by id");
		System.out.println("2) search by keyword");
		System.out.println("3) Exit");
		System.out.println("Enter your choice");
		for (int i = 0; i < 10; i++) {
			System.out.print("\uD83C\uDFA6");
		}

	}

}
