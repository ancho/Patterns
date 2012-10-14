package core.state;

import core.Document;
import core.Document.State;

public class DeletedDocumentState implements DocumentState {

	@Override
	public void revert(Document document) {
		//TODO: Execute command here
		document.setState( State.MODIFIED );
	}

	@Override
	public void commit(Document document) {
		//TODO: Execute command here
		document.setState(State.END);
	}

	@Override
	public void delete(Document document) {
		//Nothing todo here
	}

	@Override
	public void save(Document document) {
		//Nothing todo here
	}

}
