package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class AddDocumentStateTest {

	@Test
	public void revertChangesStateToNew() {
		Document document = new Document();
		document.setState( State.ADDED );
		AddDocumentState addDocumentState = new AddDocumentState();
		
		addDocumentState.revert( document );
		
		assertThat( document.getState(), is( State.NEW ) );
	}
	
	@Test
	public void commitChangesStateToEnd() {
		Document document = new Document();
		document.setState( State.ADDED );
		AddDocumentState addDocumentState = new AddDocumentState();
		
		addDocumentState.commit( document );
		
		assertThat( document.getState(), is( State.END ) );
	}
	
	@Test
	public void deleteChangesStateToEnd() {
		Document document = new Document();
		document.setState( State.ADDED );
		AddDocumentState addDocumentState = new AddDocumentState();
		
		addDocumentState.delete( document );
		
		assertThat( document.getState(), is( State.END ) );
	}



}
