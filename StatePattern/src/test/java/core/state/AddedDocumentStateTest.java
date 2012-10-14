package core.state;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import core.Document;
import core.Document.State;
import core.state.AddedDocumentState;
import core.state.DocumentState;

public class AddedDocumentStateTest {

	private Document document;
	private DocumentState addDocumentState;
	
	@Before
	public void setUp() {
		document = new Document();
		document.setState( State.ADDED );
		addDocumentState = new AddedDocumentState();
	}

	@Test
	public void revertChangesStateToNew() {
		
		addDocumentState.revert( document );
		
		assertThat( document.getState(), is( State.NEW ) );
	}
	
	@Test
	public void commitChangesStateToEnd() {
		
		addDocumentState.commit( document );
		
		assertThat( document.getState(), is( State.END ) );
	}

	@Test
	public void deleteChangesStateToEnd() {
		
		addDocumentState.delete( document );
		
		assertThat( document.getState(), is( State.END ) );
	}

	@Test
	public void saveDoesNotChangeState() {
		
		addDocumentState.save( document );
		
		assertThat( document.getState(), is( State.ADDED ) );
	}


}
