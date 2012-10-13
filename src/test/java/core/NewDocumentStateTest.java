package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import core.Document.State;
import core.state.DocumentState;
import core.state.NewDocumentState;

public class NewDocumentStateTest {

	private Document document;
	private DocumentState newDocumentState;
	
	@Before
	public void setUp() {
		document = new Document();
		newDocumentState = new NewDocumentState();
	}

	@Test
	public void revertDoesNotChangeDocumentsState() {
		
		newDocumentState.revert( document );
		
		assertThat( document.getState(), is( State.NEW ) );
	}

	
	@Test
	public void commitDoesNotChangeState() throws Exception {
		
		newDocumentState.commit(document);
		
		assertThat( document.getState(), is(State.NEW) );
	}

	@Test
	public void deleteChangesStateToEnd() throws Exception {
		
		newDocumentState.delete( document );
		
		assertThat( document.getState(), is(State.END) );
	}

	@Test
	public void saveChangesStateToModifiedIfFileExists() throws Exception {

		new DocumentMockUtil(document).mockFileExists( true );

		newDocumentState.save( document );
		
		assertThat( document.getState(), is(State.MODIFIED) );
	}
	
	@Test
	public void saveChangesStateToAddedIfFileDoesNotExist() throws Exception {
		
		new DocumentMockUtil(document).mockFileExists( false );
		
		newDocumentState.save( document );
		
		assertThat( document.getState(), is(State.ADDED) );
	}


}
