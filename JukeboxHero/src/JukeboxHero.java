import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class JukeboxHero {
	public static void main(String[] args) {
		final String DELIMITERS = ",";

		System.out.println("****************************");
		System.out.println();
		System.out.println("(L)oad catalog");
		System.out.println("(S)earch catalog");
		System.out.println("(A)nalyse catalog");
		System.out.println("(P)rint catalog");
		System.out.println("(Q)uit");
		System.out.println();

		Scanner kbd = new Scanner(System.in);
		ArrayList<Song> songList = new ArrayList<Song>();

		boolean running = true;
		while (running == true) {
			System.out.println("Please enter a command (press 'm' for Menu): ");
			String response = new String(kbd.nextLine());
			if (response.toLowerCase().equals("m")) {
				System.out.println("****************************");
				System.out.println();
				System.out.println("(L)oad catalog");
				System.out.println("(S)earch catalog");
				System.out.println("(A)nalyse catalog");
				System.out.println("(P)rint catalog");
				System.out.println("(Q)uit");
				System.out.println();
			} else if (response.toLowerCase().equals("l")) {
				System.out.println("Load Catalog. . .");
				System.out.println("Please enter a filename: ");
				String fileName = kbd.nextLine();
				File file = new File(fileName);
				Scanner fileScanner = null;
				try {
					fileScanner = new Scanner(file);
					songList = new ArrayList<Song>();

					while (fileScanner.hasNextLine()) {
						String catalogLine = fileScanner.nextLine();
						Scanner lineScan = new Scanner(catalogLine);
						lineScan.useDelimiter(DELIMITERS);

						String artist = lineScan.next();
						String album = lineScan.next();
						String title = lineScan.next();
						int duration = lineScan.nextInt();

						Song songLine = new Song(title, artist, album, duration);
						songList.add(songLine);
						lineScan.close();
					}
					System.out.println("Successfully loaded " + songList.size() + " songs!");
				} catch (Exception e) {
					System.out.println("Unable to open file: " + fileName);
				}

			} else if (response.toLowerCase().equals("s")) {
				System.out.println("Please enter the search query: ");
				String searchQuery = kbd.nextLine();
				ArrayList<Song> searchResults = new ArrayList<Song>();
				for (Song s : songList) {
					if (s.getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
						searchResults.add(s);
					}
				}

				System.out.println("Found " + searchResults.size() + " matches.");
				System.out.println("-------------------------");
				for (Song s : searchResults) {
					System.out.println(s.toString());
				}

			} else if (response.toLowerCase().equals("a")) {
				ArrayList<String> titlesList = new ArrayList<String>();
				ArrayList<String> artistList = new ArrayList<String>();
				ArrayList<String> albumList = new ArrayList<String>();
				int playTimeSum = 0;
				for (Song s : songList) {
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

			} else if (response.toLowerCase().equals("p")) {
				for (Song s : songList) {
					System.out.println(s.toString());
				}

			} else if (response.toLowerCase().equals("q")) {
				System.out.println("The shows over, goodbye!");
				running = false;
			}
		}
		kbd.close();
	}
}
