package core.state;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import core.Document;
import core.Document.State;
import core.state.DeletedDocumentState;
import core.state.DocumentState;

public class DeletedDocumentStateTest {

	
	private Document document;
	private DocumentState deletedDocumentState;

	@Before
	public void setUp() {
		document = new Document();
		document.setState( State.DELETED );
		deletedDocumentState = new DeletedDocumentState();
	}
	
	@Test
	public void revertChangesStateToModified() {
		
		deletedDocumentState.revert(document);
		
		assertThat( document.getState(), is( State.MODIFIED ) );
	}
	
	@Test
	public void commitChangesStateToEnd() {
		
		deletedDocumentState.commit(document);
		
		assertThat( document.getState(), is( State.END ) );
	}
	
	@Test
	public void deleteDoesNotChangeState() {
		
		deletedDocumentState.delete(document);
		
		assertThat( document.getState(), is( State.DELETED ) );
	}
	
	@Test
	public void saveDoesNotChangeState() {
		
		deletedDocumentState.save(document);
		
		assertThat( document.getState(), is( State.DELETED ) );
	}



}
