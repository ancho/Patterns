package core;

import java.io.File;

public class Document {

	private State state;
	private File file;
	
	public Document() {
		this.state = State.NEW;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return this.state;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}

}
