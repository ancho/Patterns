package core.state;

import core.Document;
import core.Document.State;

public class ModifiedDocumentState implements DocumentState {

	@Override
	public void revert(Document document) {
		//TODO: Execute command here
		document.setState( State.NEW );
	}

	@Override
	public void commit(Document document) {
		//TODO: Execute command here
		document.setState( State.END );
	}

	@Override
	public void delete(Document document) {
		//TODO: Execute command here
		document.setState( State.DELETED );
	}

	@Override
	public void save(Document document) {
		//Nothing todo here
	}

}
