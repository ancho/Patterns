package core;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Document.State;
import core.state.ModifiedDocumentState;

public class DocumentContextDeletedDocumentTest extends DocumentContextTest {

	@Test
	public void revertChangesDocumentStateToModified() throws Exception {
		document.setState(State.DELETED);
		createDocumentContext();
		
		documentContext.revert();
		
		assertDocumentStateAndInternalState(ModifiedDocumentState.class, State.MODIFIED);
	}
}
