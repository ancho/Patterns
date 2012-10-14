package core;

import org.junit.Test;

import core.Document.State;
import core.state.DeletedDocumentState;
import core.state.EndDocumentState;
import core.state.ModifiedDocumentState;
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
	
	@Test
	public void deleteChangesDocumentStateToDeleted() throws Exception {
		document.setState( State.MODIFIED );
		createDocumentContext();
		
		documentContext.delete();
		
		assertDocumentStateAndInternalState(DeletedDocumentState.class, State.DELETED);
	}

	@Test
	public void saveDoesNotChangeDocumentState() throws Exception {
		document.setState( State.MODIFIED );
		createDocumentContext();
		
		documentContext.save();
		
		assertDocumentStateAndInternalState(ModifiedDocumentState.class, State.MODIFIED);
	}

}
