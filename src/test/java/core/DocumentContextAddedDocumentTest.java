package core;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Document.State;
import core.state.NewDocumentState;

public class DocumentContextAddedDocumentTest extends DocumentContextTest {

	@Test
	public void revertChangesDocumentStatusToNew() {
		document.setState(State.ADDED);
		createDocumentContext();
		
		documentContext.revert();
		
		assertDocumentStateAndInternalState(NewDocumentState.class, State.NEW);
	}

}
