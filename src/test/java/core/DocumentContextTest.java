package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import core.Document.State;
import core.state.AddedDocumentState;
import core.state.DeletedDocumentState;
import core.state.ModifiedDocumentState;
import core.state.NewDocumentState;

public class DocumentContextTest {

	@Test
	public void createDocumentContextForNewDocumentWithNewDocumentState() {
		Document document = new Document();
		DocumentContext documentContext = DocumentContext.createDocumentContext( document );
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(NewDocumentState.class)));
	}
	
	@Test
	public void createDocumentContextForAddedDocumentWithAddedDocumentState() {
		Document document = new Document();
		document.setState( State.ADDED );
		
		DocumentContext documentContext = DocumentContext.createDocumentContext( document );
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(AddedDocumentState.class)));
	}
	
	@Test
	public void createDocumentContextForModifiedDocumentWithModifiedDocumentState() {
		Document document = new Document();
		document.setState( State.MODIFIED );
		
		DocumentContext documentContext = DocumentContext.createDocumentContext( document );
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(ModifiedDocumentState.class)));
	}
	
	@Test
	public void createDocumentContextForDeletedDocumentWithDeletedDocumentState() {
		Document document = new Document();
		document.setState( State.DELETED );
		
		DocumentContext documentContext = DocumentContext.createDocumentContext( document );
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(DeletedDocumentState.class)));
	}

}
