package core.state;

import core.Document;
import core.IllegalOperationException;

public class EndDocumentState implements DocumentState {

	@Override
	public void revert(Document document) {
		throw new IllegalOperationException("Dies ist ein Endzustand");
	}

	@Override
	public void commit(Document document) {
		throw new IllegalOperationException("Dies ist ein Endzustand");
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
