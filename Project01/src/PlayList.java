
/**
 * CS 121 Project 1: Play List
 *
 * Takes user input in the form of three songs and then stores those songs as objects
 * Returns the user input for track length to find the average track length
 * Prints the three songs into a table to view a summary of the songs
 *
 * @author BSU CS 121 Instructors
 * @author Cameron Bentley
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlayList {
	public static void main(String[] args) {
		
		//Declaring variables as method types
		String title, artist, playTime, filePath, minutes, seconds;
		DecimalFormat decimal;
		int colon, integerPlayTime;
		double averagePlayTime;
		

		// New scanner object to read user input
		Scanner kbd = new Scanner(System.in);
		
		// User enters first song title
		System.out.println("Enter title: ");
		title = new String(kbd.nextLine()); // Asks the user for input

		// User enters the first artist
		System.out.println("Enter artist: ");
		artist = new String(kbd.nextLine()); // Asks the user for input

		// User enters a play time of the song
		System.out.println("Enter play time (mm:ss)");
		playTime = new String(kbd.nextLine()); // Asks the user for input

		// User enters the file path
		System.out.println("Enter file name: ");
		filePath = new String(kbd.nextLine()); // Asks the user for input

		System.out.println();

		// Code to parse the user input into substrings
		//For the first two digits
		//The "colon" character
		//The last two digits
		colon = playTime.indexOf(":");
		minutes = playTime.substring(0, colon);
		seconds = playTime.substring(colon + 1);

		// Exchanges the play time from a string to an integer
		integerPlayTime = (Integer.parseInt(minutes) * 60) + Integer.parseInt(seconds);

		// Code turns the user input for each parameter into a song object
		Song song1 = new Song(title, artist, integerPlayTime, filePath);

		// Code prints out the song object's respective parameters
		System.out.println("Title: " + song1.getTitle());
		System.out.println("Artist: " + song1.getArtist());
		System.out.println("Play time: " + song1.getPlayTime());
		System.out.println("File path: " + song1.getFilePath());
		
		//Space to make it easier to read
		System.out.println();

		// User enters second song title
		System.out.println("Enter title: ");
		title = new String(kbd.nextLine()); // Asks the user for input

		// User enters the second artist
		System.out.println("Enter artist: ");
		artist = new String(kbd.nextLine()); // Asks the user for input

		// User enters a play time of the song
		System.out.println("Enter play time (mm:ss)");
		playTime = new String(kbd.nextLine()); // Asks the user for input

		// User enters the file path
		System.out.println("Enter file name: ");
		filePath = new String(kbd.nextLine()); // Asks the user for input

		System.out.println();

		// Code to parse the user input into substrings
		//For the first two digits
		//The "colon" character
		//The last two digits
		colon = playTime.indexOf(":");
		minutes = playTime.substring(0, colon);
		seconds = playTime.substring(colon + 1);

		// Exchanges the play time from a string to an integer
		integerPlayTime = (Integer.parseInt(minutes) * 60) + Integer.parseInt(seconds);

		// Code turns the user input for each parameter into a song object
		Song song2 = new Song(title, artist, integerPlayTime, filePath);

		// Code prints out the song object's respective parameters
		System.out.println("Title: " + song2.getTitle());
		System.out.println("Artist: " + song2.getArtist());
		System.out.println("Play time: " + song2.getPlayTime());
		System.out.println("File path: " + song2.getFilePath());

		System.out.println();



		// User enters third song title
		System.out.println("Enter title: ");
		title = new String(kbd.nextLine()); // Asks the user for input

		// User enters the third artist
		System.out.println("Enter artist: ");
		artist = new String(kbd.nextLine()); // Asks the user for input

		// User enters a play time of the song
		System.out.println("Enter play time (mm:ss)");
		playTime = new String(kbd.nextLine()); // Asks the user for input

		// User enters the file path
		System.out.println("Enter file name: ");
		filePath = new String(kbd.nextLine()); // Asks the user for input

		System.out.println();

		// Code to parse the user input into substrings
		//For the first two digits
		//The "colon" character
		//The last two digits
		colon = playTime.indexOf(":");
		minutes = playTime.substring(0, colon);
		seconds = playTime.substring(colon + 1);

		// Exchanges the play time from a string to an integer
		integerPlayTime = (Integer.parseInt(minutes) * 60) + Integer.parseInt(seconds);

		// Code turns the user input for each parameter into a song object
		Song song3 = new Song(title, artist, integerPlayTime, filePath);

		// Code prints out the song object's respective parameters
		System.out.println("Title: " + song3.getTitle());
		System.out.println("Artist: " + song3.getArtist());
		System.out.println("Play time: " + song3.getPlayTime());
		System.out.println("File path: " + song3.getFilePath());

		System.out.println();


		// Object to find the average playTime of the three songs that we found above
		//Create a new object named "decimal" to adjust the format from our input to our output
		decimal = new DecimalFormat("0.##");
		averagePlayTime = ((double) song1.getPlayTime() + (double) song2.getPlayTime() + (double) song3.getPlayTime())
				/ 3.0;
		System.out.println("Average play time for songs: " + decimal.format(averagePlayTime));
		
		System.out.println();

		//Variables x,y,z declared to take the absolute value of the playTime from the user input to find closest value to 240 seconds
		int x = Math.abs(240 - song1.getPlayTime());
		int y = Math.abs(240 - song2.getPlayTime());
		int z = Math.abs(240 - song3.getPlayTime());
		
		//If statement comparing the different playTimes. The one with the smallest absolute value is closest to our value of 240 seconds
		if (x < y && x < z) {
			System.out.println("Song with play time closest to 240 secs is: " + song1.getTitle());
		} else if (y < z) {
			System.out.println("Song with play time closest to 240 secs is: " + song2.getTitle());
		} else {
			System.out.println("Song with play time closest to 240 secs is: " + song3.getTitle());
		}
		
		//Code to create the box for the table using string characters
		System.out.println("==============================================================================");
		System.out.println("Title			Artist			File Name		Play Time");
		System.out.println("==============================================================================");
		
		//Taking the playTime for each of our song values and putting that into a new variable
		x = song1.getPlayTime();
		y = song2.getPlayTime();
		z = song3.getPlayTime();

		//Nested If statement comparing the playTimes to each other so we can find the correct order
		//If song1 is < that song2 and song1 < song 3 we will print the song1 object first
		//Nested If if song2 < song3 and song1 < song3 we will print song2 object second then song3
		//In any other case we will print song3 second then song2
		if (x < y && x < z) {
			System.out.println(song1.toString());
			if (y < z) {
				System.out.println(song2.toString());
				System.out.println(song3.toString());
			} else {
				System.out.println(song3.toString());
				System.out.println(song2.toString());
			}
		}

		if (y < x && y < z) {
			System.out.println(song2.toString());
			if (x < z) {
				System.out.println(song1.toString());
				System.out.println(song3.toString());
			} else {
				System.out.println(song3.toString());
				System.out.println(song1.toString());
			}
		}

		if (z < x && z < y) {
			System.out.println(song3.toString());
			if (x < y) {
				System.out.println(song1.toString());
				System.out.println(song2.toString());
			} else {
				System.out.println(song2.toString());
				System.out.println(song1.toString());
			}
		}

		System.out.println("==============================================================================");
		
		//Closes the scanner object 'kbd'
		kbd.close();
	}

}