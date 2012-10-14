package core.state;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

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
		
		assertThat(document.getState(), is(State.END));
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
		fail();
	}
	
	@Test
	public void deleteShouldThrowException() {
		Document document = new Document();
		document.setState(State.END);
		DocumentState endDocumentState = new EndDocumentState();
		
		thrown.expect(IllegalOperationException.class);
		thrown.expectMessage( startsWith("Operation nicht erlaubt"));
		thrown.expectMessage("Endzustand");
		
		endDocumentState.delete( document );
		fail();
	}
	
	@Test
	public void saveShouldThrowException() {
		Document document = new Document();
		document.setState(State.END);
		DocumentState endDocumentState = new EndDocumentState();
		
		thrown.expect(IllegalOperationException.class);
		thrown.expectMessage( startsWith("Operation nicht erlaubt"));
		thrown.expectMessage("Endzustand");
		
		endDocumentState.save( document );
		fail();
	}

}
