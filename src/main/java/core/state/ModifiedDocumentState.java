package core.state;

import core.Document;
import core.Document.State;

public class ModifiedDocumentState implements DocumentState {

	@Override
	public void revert(Document document) {
		document.setState( State.ADDED );
	}

	@Override
	public void commit(Document document) {
		document.setState( State.END );
	}

	@Override
	public void delete(Document document) {
		document.setState( State.DELETED );
	}

	@Override
	public void save(Document document) {

	}

}
