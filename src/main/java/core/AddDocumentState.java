package core;

public class AddDocumentState {

	public void revert(Document document) {
		document.setState( State.NEW );
	}

}
