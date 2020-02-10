//Duncan Du
public class Shot {
	private String scene;
	private String take;
	private String sound;
	
	// Constructs a new shot using three strings
	public Shot(String scene, String take, String sound) {
		this.scene = scene;
		this.take = take;
		this.sound = sound;
	}
	
	// Constructs a new shot using a single string in standard format
	public Shot(String info) {
		String[] data = info.split("-");
		if (data.length != 3) {
			throw new IllegalArgumentException();
		}
		scene = data[0];
		take = data[1];
		sound = data[2];
	}
	
	// Accessors
	public String getScene() {
		return scene;
	}
	
	public String getTake() {
		return take;
	}
	
	public String getSound() {
		return sound;
	}
	
	public String toString() {
		String result = "";
		result += "Scene: " + getScene() + "   ";
		result += "Take: " + getTake() + "\n";
		result += "Sound: " + getSound();
		return result;
	}
}
