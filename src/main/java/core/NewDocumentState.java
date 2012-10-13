package core;

public class NewDocumentState implements DocumentState{

	public void revert(Document document) {
		
	}

	public void save(Document document) {
		if ( document.getFile().exists() ){
			document.setState( State.MODIFIED );
		}
		else {
			document.setState( State.ADDED );
		}
	}

	public void delete(Document document) {
		document.setState( State.END );
	}

	@Override
	public void commit(Document document) {
		
	}
	
}
