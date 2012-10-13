package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import core.Document.State;
import core.state.AddedDocumentState;
import core.state.DeletedDocumentState;
import core.state.ModifiedDocumentState;
import core.state.NewDocumentState;

public class DocumentContextTest {

	private Document document;
	private DocumentContext documentContext;
	
	@Before
	public void setUp(){
		document = new Document();
	}

	//----------TEST Creation by Documents State-------------------------------------------------------------
	@Test
	public void createDocumentContextForNewDocumentWithNewDocumentState() {
		createDocumentContext();
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(NewDocumentState.class)));
	}
	
	@Test
	public void createDocumentContextForAddedDocumentWithAddedDocumentState() {
		document.setState( State.ADDED );
		
		createDocumentContext();
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(AddedDocumentState.class)));
	}
	
	@Test
	public void createDocumentContextForModifiedDocumentWithModifiedDocumentState() {
		document.setState( State.MODIFIED );
		
		createDocumentContext();
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(ModifiedDocumentState.class)));
	}
	
	@Test
	public void createDocumentContextForDeletedDocumentWithDeletedDocumentState() {
		document.setState( State.DELETED );
		
		createDocumentContext();
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(DeletedDocumentState.class)));
	}
	
	//----------TEST User interaction with new Document--------------------------------------------------

	@Test
	public void revertDoesNotChangeDocumentStatusOnNewDocument() throws Exception {
		createDocumentContext();
		
		documentContext.revert();
		
		assertThat( documentContext.getDocumentState(), is( instanceOf( NewDocumentState.class )));
		assertThat( document.getState(), is( State.NEW ));
	}
	
	@Test
	public void commitDoesNotChangeDocumentStatusOnNewDocument() throws Exception {
		createDocumentContext();
		
		documentContext.commit();
		
		assertThat( documentContext.getDocumentState(), is( instanceOf( NewDocumentState.class )));
		assertThat( document.getState(), is( State.NEW ));
	}

	@Test
	public void deleteChangesDocumentStatusToEndOnNewDocument() throws Exception {
		createDocumentContext();
		
		documentContext.delete();
		
		assertThat( documentContext.getDocumentState(), nullValue() );
		assertThat( document.getState(), is( State.END ));
	}


	private void createDocumentContext() {
		documentContext = DocumentContext.createDocumentContext(document);
	}
}
