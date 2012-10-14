package core.state;

import static org.hamcrest.Matchers.startsWith;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import core.Document;
import core.Document.State;
import core.IllegalOperationException;

public class EndDocumentStateTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void revertShouldThrowException() {
		Document document = new Document();
		document.setState(State.END);
		DocumentState endDocumentState = new EndDocumentState();
		
		thrown.expect(IllegalOperationException.class);
		thrown.expectMessage( startsWith("Operation nicht erlaubt"));
		thrown.expectMessage("Endzustand");
		
		endDocumentState.revert( document );
	}
	
	@Test
	public void commitShouldThrowException() {
		Document document = new Document();
		document.setState(State.END);
		DocumentState endDocumentState = new EndDocumentState();
		
		thrown.expect(IllegalOperationException.class);
		thrown.expectMessage( startsWith("Operation nicht erlaubt"));
		thrown.expectMessage("Endzustand");
		
		endDocumentState.commit( document );
	}
	
	


}
