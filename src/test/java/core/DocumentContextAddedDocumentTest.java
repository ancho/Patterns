package core;

import org.junit.Test;

import core.Document.State;
import core.state.EndDocumentState;
import core.state.NewDocumentState;

public class DocumentContextAddedDocumentTest extends DocumentContextTest {

	@Test
	public void revertChangesDocumentStateToNew() {
		document.setState(State.ADDED);
		createDocumentContext();
		
		documentContext.revert();
		
		assertDocumentStateAndInternalState(NewDocumentState.class, State.NEW);
	}
	
	@Test
	public void commitChangesDocumentStateToEnd() {
		document.setState(State.ADDED);
		createDocumentContext();
		
		documentContext.commit();
		
		assertDocumentStateAndInternalState(EndDocumentState.class, State.END);
	}


}
