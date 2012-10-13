package core;

import org.junit.Before;

public class DocumentContextTest {

	protected Document document;
	protected DocumentContext documentContext;
	
	@Before
	public void setUp(){
		document = new Document();
	}

	protected void createDocumentContext() {
		documentContext = DocumentContext.createDocumentContext(document);
	}
}
