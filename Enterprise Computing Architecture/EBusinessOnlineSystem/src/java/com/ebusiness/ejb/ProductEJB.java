package com.ebusiness.ejb;

import com.ebusiness.model.Game;
import com.ebusiness.model.Movie;
import com.ebusiness.model.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.TypedQuery;

@Stateless
public class ProductEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "EBusinessOnlineSystemPU")
    private EntityManager em; // EntityManager Object

    // ======================================
    // =           Public Methods           =
    // ======================================
    //Create a movie entry to database
    public Movie createMovie(Movie movie) {
        em.persist(movie);
        return movie;
    }

    //This method used to find movies by Title
    public List<Movie> findMovieByTitle(String title) {
        TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
        //set the title parameter
        query.setParameter("title", title.toUpperCase());
        return query.getResultList();
    }

    //This method used to find movie by given id
    public Movie findMovieById(long id) {
        TypedQuery<Movie> query = em.createNamedQuery("Movie.findById", Movie.class);
        //set the id parameter 
        query.setParameter("id", id);
        //getting movies by given id
        List<Movie> movies = query.getResultList();
        if (movies.isEmpty()) {
            return null;
        } else {
            return movies.get(0);
        }
    }

    //This method used to find game by id
    public Game findGameById(long id) {
        TypedQuery<Game> query = em.createNamedQuery("Game.findById", Game.class);
        //set the id parameter
        query.setParameter("id", id);
        //getting games by given id
        List<Game> games = query.getResultList();
        if (games.isEmpty()) {
            return null;
        } else {
            return games.get(0);
        }
    }

    //This method used to find all games that exists in database
    public List<Game> findGames() {
        TypedQuery<Game> query = em.createNamedQuery("Game.findAllGames", Game.class);
        return query.getResultList();
    }

    //This method create a game in database
    public Game createGame(Game game) {
        em.persist(game);
        return game;
    }

    //This method used to find games by Title
    public List<Game> findGameByTitle(String title) {
        TypedQuery<Game> query = em.createNamedQuery("Game.findByTitle", Game.class);
        //set the title parameter
        query.setParameter("title", title.toUpperCase());
        return query.getResultList();
    }

    //This method used to find all products
    public List<Product> findProducts() {
        Query query = em.createNamedQuery("Product.findAllProduct");
        return query.getResultList();
    }

    //This method is used to find all movies
    public List<Movie> findMovies() {
        TypedQuery<Movie> query = em.createNamedQuery("Movie.findAllMovies", Movie.class);
        return query.getResultList();
    }

    //this method is used to update the product quantity
    public void updateProductQuantity(long id, long quantity) {
        Product product = (Product) em.find(Product.class, id);
        //update product stock
        product.setStockNumber(quantity);
    }

}
