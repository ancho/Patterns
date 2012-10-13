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
	public void saveDoesNotChangeState() {
		
		modifiedDocumentState.save( document );
		
		assertThat( document.getState(), is( State.MODIFIED ) );
	}
	
	@Test
	public void deleteChangesStateToDeleted() {
		
		modifiedDocumentState.delete( document );
		
		assertThat( document.getState(), is( State.DELETED ) );
	}
	

}
