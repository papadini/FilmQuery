package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
  
  DatabaseAccessor db = new DatabaseAccessorObject();
  
  public FilmQueryApp () throws ClassNotFoundException {
	  Class.forName("com.mysql.jdbc.Driver");
  }

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    FilmQueryApp app = new FilmQueryApp();
    app.test();
//    app.launch();
   
  }

  private void test() {
    Film film = db.getFilmById(1);
    System.out.println(film);
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
    
  }

}
