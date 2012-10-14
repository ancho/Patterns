package core;

import org.junit.Test;

import core.Document.State;
import core.state.AddedDocumentState;
import core.state.EndDocumentState;
import core.state.ModifiedDocumentState;
import core.state.NewDocumentState;

public class DocumentContextNewDocumentTest extends DocumentContextTest {

	@Test
	public void revertDoesNotChangeDocumentStatusOnNewDocument() throws Exception {
		createDocumentContext();
		
		documentContext.revert();
		
		assertDocumentStateAndInternalState(NewDocumentState.class, State.NEW);
	}

	@Test
	public void commitDoesNotChangeDocumentStatusOnNewDocument() throws Exception {
		createDocumentContext();
		
		documentContext.commit();
		
		assertDocumentStateAndInternalState(NewDocumentState.class, State.NEW);
	}

	@Test
	public void deleteChangesDocumentStatusToEndOnNewDocument() throws Exception {
		createDocumentContext();
		
		documentContext.delete();
		
		assertDocumentStateAndInternalState(EndDocumentState.class, State.END);
	}

	@Test
	public void saveChangesDocumentStatusToModifiedIfFileExistsOnNewDocument() throws Exception {
		
		new DocumentMockUtil(document).mockFileExists(true);
		createDocumentContext();
		
		documentContext.save();
		
		assertDocumentStateAndInternalState(ModifiedDocumentState.class, State.MODIFIED);
	}

	@Test
	public void saveChangesDocumentStatusToAddedIfFileDoesNotExistOnNewDocument() throws Exception {
		
		new DocumentMockUtil(document).mockFileExists(false);
		createDocumentContext();
		
		documentContext.save();

		assertDocumentStateAndInternalState(AddedDocumentState.class, State.ADDED);
	}


}
