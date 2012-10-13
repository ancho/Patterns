package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import core.Document.State;
import core.state.DocumentState;
import core.state.ModifiedDocumentState;

public class ModifiedDocumentStateTest {

	private Document document;
	private DocumentState modifiedDocumentState;
	
	@Before
	public void setUp() {
		document = new Document();
		document.setState( State.MODIFIED );
		modifiedDocumentState = new ModifiedDocumentState();
	}

	@Test
	public void revertChangesStateToAdded() throws Exception {
		
		modifiedDocumentState.revert(document);
		
		assertThat( document.getState(), is( State.ADDED ) );
	}
	
	@Test
	public void commitChangesStateToEnd() throws Exception {
		
		modifiedDocumentState.commit(document);
		
		assertThat( document.getState(), is( State.END ) );
	}

	@Test
	public void deleteChangesStateToDeleted() {
		
		modifiedDocumentState.delete( document );
		
		assertThat( document.getState(), is( State.DELETED ) );
	}

	@Test
	public void saveDoesNotChangeState() {
		
		modifiedDocumentState.save( document );
		
		assertThat( document.getState(), is( State.MODIFIED ) );
	}
}
