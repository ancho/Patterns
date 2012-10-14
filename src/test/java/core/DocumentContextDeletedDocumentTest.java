package core;

import org.junit.Test;

import core.Document.State;
import core.state.EndDocumentState;
import core.state.ModifiedDocumentState;

public class DocumentContextDeletedDocumentTest extends DocumentContextTest {

	@Test
	public void revertChangesDocumentStateToModified() throws Exception {
		document.setState(State.DELETED);
		createDocumentContext();
		
		documentContext.revert();
		
		assertDocumentStateAndInternalState(ModifiedDocumentState.class, State.MODIFIED);
	}
	
	@Test
	public void commitChangesDocumentStateToEnd() throws Exception {
		document.setState(State.DELETED);
		createDocumentContext();
		
		documentContext.commit();
		
		assertDocumentStateAndInternalState(EndDocumentState.class, State.END);
	}

}
