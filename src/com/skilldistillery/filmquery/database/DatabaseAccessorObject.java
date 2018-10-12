package com.skilldistillery.filmquery.database;

import java.util.ArrayList;
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
		Actor actor = null;
		String sql = "select film.id, title, description, release_year, language.name, rental_duration, rental_rate, length, replacement_cost,"
				+ " rating, special_features, actor.id, actor.first_name, actor.last_name "
				+ "  from film join language on film.language_id = language.id "
				+ "join film_actor on film.id = film_actor.film_id "  
				+ "  join actor on actor.id = film_actor.actor_id "
				+ "where film.id = ?";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet filmResult = stmt.executeQuery();
		if (filmResult.next()) {
			film = new Film();
			actor = new Actor();
			

			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setLanguage(filmResult.getString("language.name"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("replacement_cost"));
			film.setRating(filmResult.getString("rating"));
			film.setSpecialFeature(filmResult.getString("special_features"));
			actor.setId( filmResult.getInt( "actor.id" ));
			actor.setFirstName(filmResult.getString( "actor.first_name" ));
			actor.setLastName(filmResult.getString( "actor.last_name" ));
			
			

		}
		filmResult.close();
		stmt.close();
		conn.close();
		return film;
	}

	public List<Film> getFilmByKeyword(String keyword) throws SQLException {
		List<Film> films = new ArrayList<>();
		Film film = null;
		Actor actor = null;
		String sql = "select film.id, title, description, release_year, language.name, rental_duration, rental_rate, length, replacement_cost,"
				+ " rating, special_features, actor.id, actor.first_name, actor.last_name "
				+ "  from film join language on film.language_id = language.id "
				+ "join film_actor on film.id = film_actor.film_id "  
				+ "  join actor on actor.id = film_actor.actor_id "
				+ "where title like ? or description like ?";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, keyword + "%");
		stmt.setString(2, "%"+ keyword + "%");
		ResultSet filmResult = stmt.executeQuery();
		while (filmResult.next()) {
			film = new Film();
			actor = new Actor();
			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setLanguage(filmResult.getString("language.name"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("replacement_cost"));
			film.setRating(filmResult.getString("rating"));
			film.setSpecialFeature(filmResult.getString("special_features"));
			actor.setId( filmResult.getInt( "actor.id" ));
			actor.setFirstName(filmResult.getString( "actor.first_name" ));
			actor.setLastName(filmResult.getString( "actor.last_name" ));
			//film.setActor(setActor(actor));

			films.add(film);

		}
		filmResult.close();
		stmt.close();
		conn.close();
		return films;

	}
	


	@Override
	public Actor getActorById(int actorId) throws SQLException {
		Actor actor = null;
		String sql = "select id, first_name, last_name from actor where  id = ?";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor();

			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
		}
		actorResult.close();
		stmt.close();
		conn.close();
		return actor;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

}
