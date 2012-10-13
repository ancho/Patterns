package core;

import core.state.DocumentState;

public class DocumentContext {

	private DocumentState documentState;

	private DocumentContext() {
	}
	
	public static DocumentContext createDocumentContext(Document document) {
		DocumentContext documentContext = new DocumentContext();
		documentContext.setDocumentState( document.getState().getDocumentState() );
		return documentContext;
	}


	private void setDocumentState(DocumentState documentState) {
		this.documentState = documentState;		
	}

	public DocumentState getDocumentState() {
		return this.documentState;
	}

}
