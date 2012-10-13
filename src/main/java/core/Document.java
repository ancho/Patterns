package core;

import java.io.File;

import core.state.*;

public class Document {

	public enum State {
		NEW( new NewDocumentState() ),
		MODIFIED( new ModifiedDocumentState() ),
		ADDED( new AddedDocumentState() ),
		DELETED( new DeletedDocumentState() ),
		END( null );
		
		DocumentState documentState;
		
		private State(DocumentState documentState) {
			this.documentState = documentState;
		}
		
		public DocumentState getDocumentState() {
			return this.documentState;
		}
		
	}
	
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
	
	//TODO implement getDocumentState

}
