package core;

import core.state.DocumentState;

public class DocumentContext {

	private DocumentState documentState;
	private Document document;

	private DocumentContext(Document document) {
		this.document = document;
	}
	
	public static DocumentContext createDocumentContext(Document document) {
		DocumentContext documentContext = new DocumentContext(document);
		documentContext.updateDocumentState();
		return documentContext;
	}


	private void setDocumentState(DocumentState documentState) {
		this.documentState = documentState;		
	}

	public DocumentState getDocumentState() {
		return this.documentState;
	}

	public void revert() {
		this.documentState.revert(this.document);
		updateDocumentState();
	}

	public void commit() {
	}

	public void delete() {
		this.documentState.delete(this.document);
		updateDocumentState();
	}


	public void save() {
		this.documentState.save(this.document);
		updateDocumentState();	
	}

	protected void updateDocumentState() {
		setDocumentState( this.document.getDocumentState() );
	}

}
