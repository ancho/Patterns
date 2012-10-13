package core.state;

import core.Document;
import core.Document.State;

public class DeletedDocumentState implements DocumentState {

	@Override
	public void revert(Document document) {
		document.setState( State.MODIFIED );
	}

	@Override
	public void commit(Document document) {
		document.setState(State.END);
	}

	@Override
	public void delete(Document document) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Document document) {
		// TODO Auto-generated method stub

	}

}
