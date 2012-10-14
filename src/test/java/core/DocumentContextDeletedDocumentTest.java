package core;

import org.junit.Before;
import org.junit.Test;

import core.Document.State;
import core.state.EndDocumentState;
import core.state.ModifiedDocumentState;

public class DocumentContextDeletedDocumentTest extends DocumentContextTest {

	@Before
	public void setUp(){
		super.setUp();
		document.setState(State.DELETED);
		createDocumentContext();
	}

	@Test
	public void revertChangesDocumentStateToModified() throws Exception {
	
		documentContext.revert();
		
		assertDocumentStateAndInternalState(ModifiedDocumentState.class, State.MODIFIED);
	}
	
	@Test
	public void commitChangesDocumentStateToEnd() throws Exception {
		
		documentContext.commit();
		
		assertDocumentStateAndInternalState(EndDocumentState.class, State.END);
	}

}
