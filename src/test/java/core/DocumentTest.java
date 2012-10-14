package core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import core.Document.State;
import core.state.AddedDocumentState;
import core.state.DeletedDocumentState;
import core.state.EndDocumentState;
import core.state.ModifiedDocumentState;
import core.state.NewDocumentState;

public class DocumentTest {

	@Test
	public void newDocumentsInternalStateMapsToNewDocumentState() {
		Document document = new Document();
		assertThat( document.getDocumentState(), is( NewDocumentState.class));
	}
	
	@Test
	public void addedDocumentsInternalStateMapsToAddedDocumentState() {
		Document document = new Document();
		document.setState( State.ADDED );
		
		assertThat( document.getDocumentState(), is( AddedDocumentState.class));
	}
	
	@Test
	public void modifiedDocumentsInternalStateMapsToModifiedDocumentState() {
		Document document = new Document();
		document.setState( State.MODIFIED );
		
		assertThat( document.getDocumentState(), is( ModifiedDocumentState.class));
	}
	
	@Test
	public void deletedDocumentsInternalStateMapsToDeletedDocumentState() {
		Document document = new Document();
		document.setState( State.DELETED );
		
		assertThat( document.getDocumentState(), is( DeletedDocumentState.class));
	}
	
	@Test
	public void endedDocumentsInternalStateMapsToEndDocumentState() {
		Document document = new Document();
		document.setState( State.END );
		
		assertThat( document.getDocumentState(), is( EndDocumentState.class));
	}



}
