package core;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Document.State;
import core.state.NewDocumentState;

public class DocumentContextModifiedDocumentTest extends DocumentContextTest{

	@Test
	public void revertChangesDocumentStateToNew() throws Exception {
		document.setState( State.MODIFIED );
		createDocumentContext();
		
		documentContext.revert();
		
		assertDocumentStateAndInternalState(NewDocumentState.class, State.NEW);
	}
}
