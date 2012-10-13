package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class NewDocumentStateTest {

	@Test
	public void revertDoesNotChangeDocumentsState() {
		Document document = new Document();
		NewDocumentState newDocumentState = new NewDocumentState();
		
		newDocumentState.revert( document );
		
		assertThat( document.getState(), is( State.NEW ) );
	}

	@Test
	public void saveChangesStateToModifiedIfFileExists() throws Exception {
		Document document = new Document();
		NewDocumentState newDocumentState = new NewDocumentState();
		
		newDocumentState.save( document );
		
		assertThat( document.getState(), is(State.MODIFIED) );
	}
}
