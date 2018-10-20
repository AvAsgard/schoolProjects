import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class JukeboxHeroEC {

	private static void displayMenu() {
		System.out.println("****************************");
		System.out.println();
		System.out.println("(L)oad catalog");
		System.out.println("(S)earch catalog");
		System.out.println("(A)nalyse catalog");
		System.out.println("(P)rint catalog");
		System.out.println("(Q)uit");
		System.out.println();
	}

	private static void loadCatalog(ArrayList<Song> sl, Scanner kbd) {
		System.out.println("Load Catalog. . .");
		System.out.println("Please enter a filename: ");
		String fileName = kbd.nextLine();
		File file = new File(fileName);
		Scanner fileScanner = null;
		
		try {
			fileScanner = new Scanner(file);
			sl.clear();

			while (fileScanner.hasNextLine()) {
				String catalogLine = fileScanner.nextLine();
				Scanner lineScan = new Scanner(catalogLine);
				lineScan.useDelimiter(",");

				String artist = lineScan.next();
				String album = lineScan.next();
				String title = lineScan.next();
				int duration = lineScan.nextInt();

				Song songLine = new Song(title, artist, album, duration);
				sl.add(songLine);
				lineScan.close();
			}
			System.out.println("Successfully loaded " + sl.size() + " songs!");
		} catch (Exception e) {
			System.out.println("Unable to open file: " + fileName);
		}
	}

	private static void printCatalog(ArrayList<Song> sl) {
		for (Song s : sl) {
			System.out.println(s.toString());
		}
	}

	private static void searchCatalog(ArrayList<Song> sl, Scanner kbd) {
		System.out.println("Please enter the search query: ");
		String searchQuery = kbd.nextLine();
		ArrayList<Song> searchResults = new ArrayList<Song>();
		for (Song s : sl) {
			if (s.getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
				searchResults.add(s);
			}
		}

		System.out.println("Found " + searchResults.size() + " matches.");
		System.out.println("-------------------------");
		printCatalog(searchResults);
	}

	private static void analyseCatalog(ArrayList<Song> sl) {
		ArrayList<String> titlesList = new ArrayList<String>();
		ArrayList<String> artistList = new ArrayList<String>();
		ArrayList<String> albumList = new ArrayList<String>();
		int playTimeSum = 0;
		for (Song s : sl) {
			if (!artistList.contains(s.getArtist())) {
				artistList.add(s.getArtist());
			}
			if (!albumList.contains(s.getAlbum())) {
				albumList.add(s.getAlbum());
			}
			if (!titlesList.contains(s.getTitle())) {
				titlesList.add(s.getTitle());
			}
			playTimeSum = playTimeSum + s.getPlayTime();
		}
		System.out.println("Number of Artists: " + artistList.size());
		System.out.println("Number of Albums: " + albumList.size());
		System.out.println("Number of Songs: " + titlesList.size());
		System.out.println("Catalog Playtime: " + playTimeSum);
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		ArrayList<Song> songList = new ArrayList<Song>();

		displayMenu();

		boolean running = true;
		while (running == true) {
			System.out.println("Please enter a command (press 'm' for Menu): ");
			String response = new String(kbd.nextLine());
			if (response.toLowerCase().equals("m")) {
				displayMenu();
			} else if (response.toLowerCase().equals("l")) {
				loadCatalog(songList, kbd);
			} else if (response.toLowerCase().equals("s")) {
				searchCatalog(songList, kbd);
			} else if (response.toLowerCase().equals("a")) {
				analyseCatalog(songList);
			} else if (response.toLowerCase().equals("p")) {
				printCatalog(songList);
			} else if (response.toLowerCase().equals("q")) {
				System.out.println("The shows over, goodbye!");
				running = false;
			}
		}
		kbd.close();
	}
}
