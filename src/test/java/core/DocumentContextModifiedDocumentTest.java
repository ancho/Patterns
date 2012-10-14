package core;

import org.junit.Test;

import core.Document.State;
import core.state.EndDocumentState;
import core.state.NewDocumentState;

public class DocumentContextModifiedDocumentTest extends DocumentContextTest{

	@Test
	public void revertChangesDocumentStateToNew() throws Exception {
		document.setState( State.MODIFIED );
		createDocumentContext();
		
		documentContext.revert();
		
		assertDocumentStateAndInternalState(NewDocumentState.class, State.NEW);
	}
	
	@Test
	public void commitChangesDocumentStateToEnd() throws Exception {
		document.setState( State.MODIFIED );
		createDocumentContext();
		
		documentContext.commit();
		
		assertDocumentStateAndInternalState(EndDocumentState.class, State.END);
	}

}
