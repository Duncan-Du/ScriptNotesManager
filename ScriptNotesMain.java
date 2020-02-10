import java.util.*;
import java.io.*;

public class ScriptNotesMain {
	public static final String SCRIPT_FILE = "pseudonym.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Welcome to ScriptNotesManager!");
		System.out.println();
		
		List<String> scriptNotes = new LinkedList<>();
		Scanner input = new Scanner(new File(SCRIPT_FILE));
		
		while(input.hasNextLine()) {
			scriptNotes.add(input.nextLine());
		}
		
		input = new Scanner(System.in);
		ScriptNotes notes = new ScriptNotes(scriptNotes);
		
		boolean done = false;
		while (!done) {
			if (asksForScene(input)) {
				System.out.println("What is the name of the scene?");
				notes.findScene(input.nextLine());
			} else {
				System.out.println("What is the name of the shot?");
				notes.findShot(input.nextLine());
			}
			System.out.println("Enter Q to quit, anything else to continues.");
			if (input.nextLine().equalsIgnoreCase("q")) {
				done = true;
			}
		}

	}
	
	public static boolean asksForScene(Scanner input) {
		while (true) {
			System.out.println("Would you like to search for a scene or a shot?");
			String s = input.nextLine();
			if (s.equalsIgnoreCase("scene")) {
				return true;
			} else if (s.equalsIgnoreCase("shot")){
				return false;
			}
		}
	}

}
