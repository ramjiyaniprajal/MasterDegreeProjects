import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class MovieApplication extends JFrame implements ActionListener {

	private Menu movieDataMenu; // used to handle movie data
	private Menu distributorsMenu; // used to handle distributors menu
	private Menu activitiesMenu; //used to handle activities menu
	private Menu exitMenu; // used to handle exit menu
	private MenuBar menuBar; // used to handle menu bar
	private JPanel mainPanel; // used to main panel
	private JTextArea displayArea; // display text area to view result
	private MenuItem readDataMenuItem; //used to handle read menu
	private MenuItem saveDataMenuItem; // used to handle save item
	private MenuItem listMoviesMenuItem; // used to handle movie item
	private MenuItem sortMoviesByNameMenuItem; // used to handle sort movie menus.
	private MenuItem searchMoviesByTicketPriceMenuItem; // used to handle movie tickets per price
	private MenuItem detailsMenuItem; // used to indicate detain menu
	private MenuItem exitMenuItem; // used to exit menu functionality
	private ArrayList<Movie> movieArrayList = new ArrayList<Movie>(); // to handle movie array list

	private void loadApp() {

		// Set the title property to Frame
		this.setTitle("Movie Data Processing Application");
		// Set the size of frame
		this.setSize(1000, 600);
		//Set the default call the exit function
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialize the Menubar.
		menuBar = new MenuBar();
		// create movie data.
		movieDataMenu = createMenu("Movie Data");
		
		//creating read data menu and add to Movie data
		readDataMenuItem = createMenuItem("Read Data");
		readDataMenuItem.addActionListener(this);
		movieDataMenu.add(readDataMenuItem);
		
		//creating save data menu and add to Movie data
		saveDataMenuItem = createMenuItem("Save Data");
		saveDataMenuItem.addActionListener(this);
		movieDataMenu.add(saveDataMenuItem);

		// Adding movie data menu to menu bar
		menuBar.add(movieDataMenu);

		//Creating and Adding distributors menu and details menu into menu bar
		distributorsMenu = createMenu("Distributors");
		detailsMenuItem = createMenuItem("Details");
		detailsMenuItem.addActionListener(this);
		distributorsMenu.add(detailsMenuItem);
		menuBar.add(distributorsMenu);

		//Creating Activities menu.
		activitiesMenu = createMenu("Activities");

		// Creating list movies menu item and add to activities menu
		listMoviesMenuItem = createMenuItem("List Movies");
		listMoviesMenuItem.addActionListener(this);
		activitiesMenu.add(listMoviesMenuItem);

		// Creating and adding sort movies by Name menu item to activities menu
		sortMoviesByNameMenuItem = createMenuItem("Sort Movies By Name");
		sortMoviesByNameMenuItem.addActionListener(this);
		activitiesMenu.add(sortMoviesByNameMenuItem);

		// Creating and adding Search movie by ticket price menu item to activities menu
		searchMoviesByTicketPriceMenuItem = createMenuItem("Search Movie by Ticket Price");
		searchMoviesByTicketPriceMenuItem.addActionListener(this);
		activitiesMenu.add(searchMoviesByTicketPriceMenuItem);

		//Adding activities menu bar to menu bar
		menuBar.add(activitiesMenu);

		//Creating and adding exit menu item and menu bar.
		exitMenu = createMenu("Exit");
		exitMenuItem = createMenuItem("Exit");
		exitMenuItem.addActionListener(this);
		exitMenu.add(exitMenuItem);
		menuBar.add(exitMenu);
		
		// Creating display area panel
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createTitledBorder("Display Area"));
		mainPanel.setBorder(BorderFactory.createTitledBorder("Display Area"));
		
		// Creating text area to display text content
		displayArea = new JTextArea("", 30, 80);
		this.getContentPane().add(displayArea, BorderLayout.CENTER);
		displayArea.setLayout(new GridLayout(0, 1, 0, 0));
		displayArea.setEditable(false);
		// Creating and adding scroll panel to the display area
		JScrollPane jScrollPane1 = new JScrollPane(displayArea);
		jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		mainPanel.add(jScrollPane1);

		this.setMenuBar(menuBar);
		this.add(mainPanel);
		this.setVisible(true);
	}

	// Method to create menu.
	private Menu createMenu(String menuDesc) {
		Menu menu = new Menu(menuDesc);
		return menu;
	}

	//Method to create a menu item.
	private MenuItem createMenuItem(String menuDesc) {
		MenuItem menuItem = new MenuItem(menuDesc);
		return menuItem;
	}

	// Constructor to load application
	public MovieApplication() {
		loadApp();
	}
	//Main method to run program
	public static void main(String ar[]) {
		// Creating object of this class
		MovieApplication movieApplication = new MovieApplication();

	}

	// This method performs actions according to events happen on UI.
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == readDataMenuItem) {
			//Action performed when read data menu item is selected.
			try {
				movieArrayList = readMovieDetails();
				displayArea.setText("Sucessfully Read File!");
			} catch (FileNotFoundException e) {
				displayArea.setText("Error occured while reading File!");
				e.printStackTrace();
			}

		} else if (ae.getSource() == saveDataMenuItem) {
			//Action performed when save data menu item is selected.
			if (createMovieFile(movieArrayList)) {
				displayArea.setText("Successfully Created File!");
			} else {
				displayArea.setText("Failed Created File!");
			}

		} else if (ae.getSource() == detailsMenuItem) {
			//Action performed when details menu item is selected.
			displayDistributors();
		} else if (ae.getSource() == listMoviesMenuItem) {
			//Action performed when list movie menu item is selected.
			displayAllMovies(movieArrayList);
		} else if (ae.getSource() == sortMoviesByNameMenuItem) {
			//Action performed when sort movies by name menu item is selected.
			long startTime = System.currentTimeMillis();
			sortByMovieNames(movieArrayList);
			long stopTime = System.currentTimeMillis();
		    long elapsedTime = stopTime - startTime;
		    System.out.println(elapsedTime);
		    System.out.println("Sort Time :"+elapsedTime);
			displayAllMovies(movieArrayList);
		} else if (ae.getSource() == searchMoviesByTicketPriceMenuItem) {
			//Action performed when search menu by ticket price menu item is selected.
			String ticketStr = JOptionPane.showInputDialog(this, "Enter movie ticket for searching");
			// validation for ticket price search
			if (ticketStr != null && ticketStr.trim().length() > 0) {
				try{
					Double.valueOf(ticketStr);
				} catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Please valid ticket price for Search!",
							"Error Mesage", JOptionPane.WARNING_MESSAGE);
					ticketStr = JOptionPane.showInputDialog(this, "Enter movie ticket for searching");
				}
				if (Double.valueOf(ticketStr) < 2) {
					JOptionPane.showMessageDialog(null, "Please enter 2 or more ticket price for Search!",
							"Error Mesage", JOptionPane.WARNING_MESSAGE);
					ticketStr = JOptionPane.showInputDialog(this, "Enter movie ticket for searching");
				}
				// displaying result from search.
				long startTime = System.currentTimeMillis();
			    ArrayList<Movie> searchMovieByTicketPriceList = searchMovieByTicketPrice(Double.valueOf(ticketStr));
			    long stopTime = System.currentTimeMillis();
			    long elapsedTime = stopTime - startTime;
			    System.out.println("Search Time :"+elapsedTime);
			    displayAllMovies(searchMovieByTicketPriceList);

			} else {
				// Show error message when get invalid input
				JOptionPane.showMessageDialog(null, "Please enter valid Input ticket price!", "Error Mesage",
						JOptionPane.WARNING_MESSAGE);
			}
		} else if (ae.getSource() == exitMenuItem) {
			// Validation on Exit.
			if (JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				// yes option
				System.exit(0);
			} else {
				// no option
			}
		}
	}

	// This method provide search by movie ticket using Linear Search Algorithm
	private ArrayList<Movie> searchMovieByTicketPrice(double ticketPrice) {
		ArrayList<Movie> movieList = new ArrayList<Movie>();

		for (Movie mv : movieArrayList) {
			if (mv.getTicketPrice() == ticketPrice) {
				movieList.add(mv);
			}
		}
		return movieList;
	}

	// This method used to sort movies by Insertion Sort algorithm
	private void sortByMovieNames(ArrayList<Movie> movieArrayList) {
		int i, j;
		Movie key;
		// Implementation of Insertion sort algorithm
		for (j = 1; j < movieArrayList.size(); j++) {
			key = movieArrayList.get(j);
			i = j - 1;
			while (i >= 0) {
				if (key.getMovieName().compareTo(movieArrayList.get(i).getMovieName()) > 0) {
					break;
				}
				movieArrayList.set(i + 1, movieArrayList.get(i));
				i--;
			}
			movieArrayList.set(i + 1, key);
		}
	}

	// this method used to read movie data from static file
	private ArrayList<Movie> readMovieDetails() throws FileNotFoundException {
		ArrayList<Movie> list = new ArrayList<Movie>();
		Movie movie = null;
		Scanner scan;
		try {
			scan = new Scanner(new File("E:\\WS\\CQU_WS\\T2Assignment2\\src\\MovieData.txt"));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line != null && line.contains(",")) {
					String[] strArray = line.split(",");
					movie = new Movie();
					movie.setMovieName(strArray[0].trim());
					movie.setLeadActor(strArray[1].trim());
					movie.setLeadActress(strArray[2].trim());
					movie.setTheaterName(strArray[3].trim());
					movie.setTicketPrice(Double.valueOf(strArray[4].trim()));
					list.add(movie);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception occured while reading movie data file");
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	// this method create a movie data file by giving movie array list.
	private boolean createMovieFile(ArrayList<Movie> movieArrayList) {

		File file = null;
		FileWriter writer = null;
		try {
			file = new File("E:\\WS\\CQU_WS\\T2Assignment2\\src\\NewMovieData.txt");
			// Create the file
			file.createNewFile();

			// Write Content
			writer = new FileWriter(file);
			for (Movie movie : movieArrayList) {
				writer.write(movie.getMovieName() + ", " + movie.getTheaterName() + ", "
						+ String.valueOf(movie.getTicketPrice()) + "\n");
			}
			writer.append("Total Number of Movies: " + movieArrayList.size());

		} catch (IOException e) {
			System.out.println("Exception Occured while writing file!");
			e.printStackTrace();
			return false;
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println("Exception occured while closing file!");
				e.printStackTrace();
			}
		}
		return true;
	}
	
	// this method used to display movie data given in array list.
	private void displayAllMovies(ArrayList<Movie> movieArrayList) {
		StringBuffer sb = new StringBuffer();

		if (movieArrayList != null && movieArrayList.size() > 0) {
			sb.append(formatString("   Movie Name") + "");
			sb.append(formatString("Lead Actor") + "");
			sb.append(formatString("Lead Actress") + "");
			sb.append(formatString("Theater Name") + "");
			sb.append("Ticket Price\n");
			sb
					.append("==================================================================================================================");
			sb.append("\n");
			for (Movie movie : movieArrayList) {
				sb.append("   " + formatString(movie.getMovieName()) + "" + formatString(movie.getLeadActor()) + ""
						+ formatString(movie.getLeadActress()) + "" + formatString(movie.getTheaterName()) + ""
						+ formatString("$" + movie.getTicketPrice()) + "\n");
			}
			sb
					.append("==================================================================================================================");
		} else {
			sb.append("There is no Record!");
		}

		displayArea.setText(sb.toString());
		displayArea.setCaretPosition(0);
	}

	// this method display static distributors to display area 
	private void displayDistributors() {
		StringBuffer sb = new StringBuffer();
		sb.append(formatString("   Name") + "");
		sb.append(formatString("Address") + "\t");
		sb.append("Phone\n");
		sb
				.append("==================================================================================================================");
		sb.append("\n");
		sb.append("   " + formatString("Jonh Smith") + "" + formatString("Unit 12/897 Burke Rd,Canturbury VIC 3052")
				+ "" + formatString("+61 223 234 444") + "\n");
		sb.append("   " + formatString("Helena Yi") + "" + formatString("212 Hawthorn Rd,Hawthorn VIC 3126") + ""
				+ formatString("+61 323 594 909") + "\n");
		sb.append("   " + formatString("Yuping Wang") + "" + formatString("Unit 3/12 Moon Rd,Clayton VIC 3212") + ""
				+ formatString("+61 212 999 321") + "\n");
		sb.append("   " + formatString("Meet Jordan") + "" + formatString("01/A Railway Rd,Brighton VIC 4012") + ""
				+ formatString("+61 565 445 088") + "\n");

		sb
				.append("==================================================================================================================");
		displayArea.setText(sb.toString());
		displayArea.setCaretPosition(0);
	}

	// this method help to create proper text alignment on display area.
	private String formatString(Object obj) {
		String updatedText = obj.toString();
		for (int i = obj.toString().length(); i < 30; i++) {
			updatedText += " ";
		}
		return updatedText + "\t";
	}

}
