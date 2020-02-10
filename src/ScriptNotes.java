// Duncan Du
// This class manages a collection of script notes.
import java.util.*;

public class ScriptNotes {
	private Map<String, List<Shot>> notes;
	
	// Constructs new ScriptNotes using a list in standard format
	public ScriptNotes(List<String> list) {
		notes = new TreeMap<>();
		for (String line : list) {
			String[] parts = line.split(":");
			if (parts.length != 2) {
				throw new IllegalArgumentException();
			}
			String pageNumber = parts[0];
			String[] shots = parts[1].split("\\|");
			List<Shot> shotsOnPage = new LinkedList<>();
			for (String shot : shots) {
				shotsOnPage.add(new Shot(shot));
			}
			notes.put(pageNumber, shotsOnPage);
		}
	}
	
	public void findShot(String shotName) {
		String[] parts = shotName.split("-");
		if (parts.length != 2) {
			throw new IllegalArgumentException();
		}
		String sceneName = parts[0];
		String takeNumber = parts[1];
		
		for (String page : notes.keySet()) {
			for (Shot shot : notes.get(page)) {
				if (sceneName.equalsIgnoreCase(shot.getScene()) && 
						takeNumber.equalsIgnoreCase(shot.getTake())) {
					System.out.println("On page " + page + ":");
					System.out.println(shot);
				}
			}
		}
				
	}
	
	public void findScene(String sceneName) {
		for (String page : notes.keySet()) {
			for (Shot shot : notes.get(page)) {
				if (sceneName.equalsIgnoreCase(shot.getScene())) {
					System.out.println("On page " + page + ":");
					System.out.println(shot);
					System.out.println();
				}
			}
		}
	}
}
