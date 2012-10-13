package core;

public class AddDocumentState {

	public void revert(Document document) {
		document.setState( State.NEW );
	}

	public void commit(Document document) {
		document.setState( State.END );
	}

	public void delete(Document document) {
		document.setState( State.END );
	}

	public void save(Document document) {
		
	}

}
