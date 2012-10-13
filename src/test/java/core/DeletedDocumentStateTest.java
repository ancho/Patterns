package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import core.Document.State;
import core.state.DeletedDocumentState;
import core.state.DocumentState;

public class DeletedDocumentStateTest {

	@Test
	public void revertChangesStateToModified() {
		
		Document document = new Document();
		document.setState( State.DELETED );
		DocumentState deletedDocumentState = new DeletedDocumentState();
		
		deletedDocumentState.revert(document);
		
		assertThat( document.getState(), is( State.MODIFIED ) );
	}

}
