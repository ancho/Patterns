package core;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import core.Document.State;
import core.state.AddedDocumentState;
import core.state.DeletedDocumentState;
import core.state.ModifiedDocumentState;
import core.state.NewDocumentState;

public class DocumentContextCreationTest extends DocumentContextTest{

	@Test
	public void createDocumentContextForNewDocumentWithNewDocumentState() {
		createDocumentContext();
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(NewDocumentState.class)));
	}
	
	@Test
	public void createDocumentContextForAddedDocumentWithAddedDocumentState() {
		document.setState( State.ADDED );
		
		createDocumentContext();
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(AddedDocumentState.class)));
	}
	
	@Test
	public void createDocumentContextForModifiedDocumentWithModifiedDocumentState() {
		document.setState( State.MODIFIED );
		
		createDocumentContext();
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(ModifiedDocumentState.class)));
	}
	
	@Test
	public void createDocumentContextForDeletedDocumentWithDeletedDocumentState() {
		document.setState( State.DELETED );
		
		createDocumentContext();
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(DeletedDocumentState.class)));
	}
}
