package core;

import org.junit.Before;
import org.junit.Test;

import core.Document.State;
import core.state.DeletedDocumentState;
import core.state.EndDocumentState;
import core.state.ModifiedDocumentState;
import core.state.NewDocumentState;

public class DocumentContextModifiedDocumentTest extends DocumentContextTest{

	@Before
	public void setUp(){
		super.setUp();
		document.setState( State.MODIFIED );
		createDocumentContext();
	}
	
	@Test
	public void revertChangesDocumentStateToNew() throws Exception {
		
		documentContext.revert();
		
		assertDocumentStateAndInternalState(NewDocumentState.class, State.NEW);
	}
	
	@Test
	public void commitChangesDocumentStateToEnd() throws Exception {
		
		documentContext.commit();
		
		assertDocumentStateAndInternalState(EndDocumentState.class, State.END);
	}
	
	@Test
	public void deleteChangesDocumentStateToDeleted() throws Exception {
		
		documentContext.delete();
		
		assertDocumentStateAndInternalState(DeletedDocumentState.class, State.DELETED);
	}

	@Test
	public void saveDoesNotChangeDocumentState() throws Exception {
		
		documentContext.save();
		
		assertDocumentStateAndInternalState(ModifiedDocumentState.class, State.MODIFIED);
	}

}
