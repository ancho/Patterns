package core.state;

import core.Document;
import core.Document.State;

public class NewDocumentState implements DocumentState{

	public void revert(Document document) {
		//Nothing todo here
	}

	public void save(Document document) {
		//TODO: Execute command here
		if ( document.getFile().exists() ){
			document.setState( State.MODIFIED );
		}
		else {
			document.setState( State.ADDED );
		}
	}

	public void delete(Document document) {
		//TODO: Execute command here
		document.setState( State.END );
	}

	@Override
	public void commit(Document document) {
		//Nothing todo here		
	}
	
}
