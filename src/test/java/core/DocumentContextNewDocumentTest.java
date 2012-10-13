package core;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.Test;

import core.Document.State;
import core.state.AddedDocumentState;
import core.state.ModifiedDocumentState;
import core.state.NewDocumentState;

public class DocumentContextNewDocumentTest extends DocumentContextTest {

	@Test
	public void revertDoesNotChangeDocumentStatusOnNewDocument() throws Exception {
		createDocumentContext();
		
		documentContext.revert();
		
		assertThat( documentContext.getDocumentState(), is( instanceOf( NewDocumentState.class )));
		assertThat( document.getState(), is( State.NEW ));
	}
	
	@Test
	public void commitDoesNotChangeDocumentStatusOnNewDocument() throws Exception {
		createDocumentContext();
		
		documentContext.commit();
		
		assertThat( documentContext.getDocumentState(), is( instanceOf( NewDocumentState.class )));
		assertThat( document.getState(), is( State.NEW ));
	}

	@Test
	public void deleteChangesDocumentStatusToEndOnNewDocument() throws Exception {
		createDocumentContext();
		
		documentContext.delete();
		
		assertThat( documentContext.getDocumentState(), nullValue() );
		assertThat( document.getState(), is( State.END ));
	}

	@Test
	public void saveChangesDocumentStatusToModifiedIfFileExistsOnNewDocument() throws Exception {
		
		new DocumentMockUtil(document).mockFileExists(true);
		createDocumentContext();
		
		documentContext.save();
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(ModifiedDocumentState.class)) );
		assertThat( document.getState(), is( State.MODIFIED ));
	}

	@Test
	public void saveChangesDocumentStatusToAddedIfFileDoesNotExistOnNewDocument() throws Exception {
		
		new DocumentMockUtil(document).mockFileExists(false);
		createDocumentContext();
		
		documentContext.save();
		
		assertThat( documentContext.getDocumentState(), is(instanceOf(AddedDocumentState.class)) );
		assertThat( document.getState(), is( State.ADDED ));
	}


}
