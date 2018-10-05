package com.skilldistillery.filmquery.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.*;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

  @Override
  public Film getFilmById(int filmId) {
	  Film film = null;
	  String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  stmt.setInt(1,filmId);
	  ResultSet filmResult = stmt.executeQuery();
	  if (filmResult.next()) {
	    film = new Film();
	    
	    film.setId(filmResult.getInt(id));
	    
	  }
	  //...
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
