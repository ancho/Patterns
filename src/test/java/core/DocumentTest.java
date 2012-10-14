package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import core.state.NewDocumentState;

public class DocumentTest {

	@Test
	public void newDocumentsInternalStateMapsToNewDocumentState() {
		Document document = new Document();
		assertThat( document.getDocumentState(), is( NewDocumentState.class));
	}

}
