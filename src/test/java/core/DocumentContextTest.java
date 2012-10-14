package core;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;

import core.Document.State;

public class DocumentContextTest {

	protected Document document;
	protected DocumentContext documentContext;

	@Before
	public void setUp() {
		document = new Document();
	}

	protected void createDocumentContext() {
		documentContext = DocumentContext.createDocumentContext(document);
	}

	protected void assertDocumentStateAndInternalState(Class<?> classname, State state) {
		assertThat(documentContext.getDocumentState(), is(instanceOf(classname)));
		assertThat(document.getState(), is(state));
	}
}
