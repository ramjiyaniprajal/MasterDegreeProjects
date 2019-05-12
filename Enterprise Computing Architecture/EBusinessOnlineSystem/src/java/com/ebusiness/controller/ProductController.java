package com.ebusiness.controller;

import com.ebusiness.ejb.ProductEJB;
import com.ebusiness.model.Game;
import com.ebusiness.model.Movie;
import com.ebusiness.model.Product;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

@Named(value = "productController")
@ManagedBean
@RequestScoped
public class ProductController {

    // ======================================
    // =             Attributes             =
    // ======================================
    @EJB
    private ProductEJB productEJB; //Product EJB Object

    private Game game = new Game(); //Used to handle Game
    private Movie movie = new Movie(); //Used to handle Movie
    private List<Product> productList = new ArrayList<Product>(); //List of products
    private List<Movie> movieList = new ArrayList<Movie>(); // List of movies
    private List<Game> gameList = new ArrayList<Game>(); //List of games
    private int totalProductCount = 0; // total no of products

    // ======================================
    // =           Public Methods           = 
    // ======================================
    //This method used to create a movie
    public String doCreateMovie() {
        //Create a movie
        movie = productEJB.createMovie(movie);
        //get all the movies
        movieList = productEJB.findMovies();
        if (movieList != null) {
            //Set the total no of movies
            totalProductCount = movieList.size();
        }
        return "listMovies.xhtml";
    }

    //This method is used to search the movie by given title
    public String doSearchMovie() {
        //get movies by given movie title
        movieList = productEJB.findMovieByTitle(movie.getTitle());
        if (movieList != null) {
            //Set the total no of movies
            totalProductCount = movieList.size();
        }
        return "searchMovie.xhtml";
    }

    //Getter method for Movie
    public Movie getMovie() {
        return movie;
    }

    //Setter method for Movie
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    //This method returns all products
    public List<Product> getProductList() {
        // productList = productEJB.findProducts();
        return productList;
    }

    //This method returns total number of movies or games
    public int getTotalProducts() {
        return totalProductCount;
    }

    //Get all product from database
    public List<Product> getAllProducts() {
        productList = productEJB.findProducts();
        if (productList != null) {
            //Update the total product count
            totalProductCount = productList.size();
        }
        return productList;
    }

    //load all the movies from database
    public String onLoadMovies() {
        movieList = productEJB.findMovies();
        if (movieList != null) {
            //update the total number of movie counts
            totalProductCount = movieList.size();
        }
        return "listMovies.xhtml";
    }

    //This method used to navigate detail view of selected product
    public String productDetailsPage(long id, String productType) {
        
        //checking the product type
        if ("unknown".equalsIgnoreCase(productType)) {
            movie = productEJB.findMovieById(id);
            if (movie != null) {
                productType = "movie";
            } else {
                productType = "game";
            }
        }
        return "productDetails.xhtml?productId=" + id + "&productType=" + productType;
    }

    //This method used to find product by given productid and product type
    public void productById(long productId, String productType) {
        if ("Movie".equalsIgnoreCase(productType)) {
            movie = productEJB.findMovieById(productId);
        } else {
            game = productEJB.findGameById(productId);
        }

    }

    //This method used to create a game
    public String doCreateGame() {
        //Crating game record
        game = productEJB.createGame(game);
        //get updated game list from database
        gameList = productEJB.findGames();
        if (productList != null) {
            //Update the total number of games
            totalProductCount = gameList.size();
        }
        return "listGames.xhtml";
    }

    //this method used to search game by title
    public String doSearchGame() {
        //fetching games by game title
        gameList = productEJB.findGameByTitle(game.getTitle());
        if (gameList != null) {
            //update the total game count;
            totalProductCount = gameList.size();
        }
        return "searchGame.xhtml";
    }

    //Get current game object
    public Game getGame() {
        return game;
    }

    //Set current game object
    public void setGame(Game game) {
        this.game = game;
    }

    //load all the games in game list
    public String onLoadGames() {
        gameList = productEJB.findGames();
        if (gameList != null) {
            totalProductCount = gameList.size();
        }
        return "listGames.xhtml";
    }
    
    //Get movie list  
    public List<Movie> getMovieList() {
        return movieList;
    }

    //get Game list
    public List<Game> getGameList() {
        return gameList;
    }

}
