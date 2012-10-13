package core;

public class Document {

	private State state;
	
	public Document() {
		this.state = State.NEW;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return this.state;
	}

}
