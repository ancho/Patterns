package core;

import org.junit.Before;
import org.junit.Test;

import core.Document.State;
import core.state.DeletedDocumentState;
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
	
	@Test
	public void deleteDoesNotChangeDocumentState() throws Exception {
		
		documentContext.delete();
		
		assertDocumentStateAndInternalState(DeletedDocumentState.class, State.DELETED);
	}
	
	@Test
	public void saveDoesNotChangeDocumentState() throws Exception {
		
		documentContext.save();
		
		assertDocumentStateAndInternalState(DeletedDocumentState.class, State.DELETED);
	}




}
