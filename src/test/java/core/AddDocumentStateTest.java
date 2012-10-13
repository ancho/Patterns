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

}
