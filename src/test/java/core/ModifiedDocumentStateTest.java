package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import core.Document.State;
import core.state.DocumentState;
import core.state.ModifiedDocumentState;

public class ModifiedDocumentStateTest {

	@Test
	public void saveDoesNotChangeState() {
		Document document = new Document();
		document.setState( State.MODIFIED );
		DocumentState modifiedDocumentState = new ModifiedDocumentState();
		
		modifiedDocumentState.save( document );
		
		assertThat( document.getState(), is( State.MODIFIED ) );
	}

}
