package core;

import org.junit.Before;
import org.junit.Test;

import core.Document.State;
import core.state.AddedDocumentState;
import core.state.EndDocumentState;
import core.state.NewDocumentState;

public class DocumentContextAddedDocumentTest extends DocumentContextTest {

	@Before
	public void setUp(){
		super.setUp();
		document.setState(State.ADDED);
		createDocumentContext();
	}
	@Test
	public void revertChangesDocumentStateToNew() {
		
		documentContext.revert();
		
		assertDocumentStateAndInternalState(NewDocumentState.class, State.NEW);
	}
	
	@Test
	public void commitChangesDocumentStateToEnd() {
		
		documentContext.commit();
		
		assertDocumentStateAndInternalState(EndDocumentState.class, State.END);
	}
	
	@Test
	public void deleteChangesDocumentStateToEnd() {
		
		documentContext.delete();
		
		assertDocumentStateAndInternalState(EndDocumentState.class, State.END);
	}
	
	@Test
	public void saveDoesNotChangeDocumentState() {
		
		documentContext.save();
		
		assertDocumentStateAndInternalState(AddedDocumentState.class, State.ADDED);
	}




}
