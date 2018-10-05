package com.skilldistillery.filmquery.database;

import java.util.List;
import java.sql.*;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private final String user = "student";
    private final String pass = "student";
    private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

  @Override
  public Film getFilmById(int filmId) throws SQLException {
	  
	  Film film = null;
	  String sql = "select id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features " + 
	  		"  from film where id = ?";
	  Connection conn = DriverManager.getConnection(URL, user, pass);
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1,filmId);
	  ResultSet filmResult = stmt.executeQuery();
	  if (filmResult.next()) {
	    film = new Film();
	    
	    film.setId(filmResult.getInt( "id" ));
	    film.setTitle(filmResult.getString( "title" ));
	    film.setDescription(filmResult.getString( "description" ));
	    film.setReleaseYear(filmResult.getInt( "release_year" ));
	    film.setLanguageId(filmResult.getInt( "language_id" ));
	    film.setRentalDuration(filmResult.getInt( "rental_duration" ));
	    film.setRentalRate(filmResult.getDouble( "rental_rate" ));
	    film.setLength(filmResult.getInt( "length" ));
	    film.setReplacementCost( filmResult.getDouble( "replacement_cost" ));
	    film.setRating(filmResult.getString( "rating" ));
	    film.setSpecialFeature(filmResult.getString( "special_features" ));
	    
	    
	    
	  }
	  filmResult.close();
	  stmt.close();
	  conn.close();
	  return film;
	}
    
  

@Override
public Actor getActorById(int actorId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Actor> getActorsByFilmId(int filmId) {
	// TODO Auto-generated method stub
	return null;
}

}
