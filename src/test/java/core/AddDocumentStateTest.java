package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class AddDocumentStateTest {

	private Document document;
	private AddDocumentState addDocumentState;
	
	@Before
	public void setUp() {
		document = new Document();
		document.setState( State.ADDED );
		addDocumentState = new AddDocumentState();
	}

	@Test
	public void revertChangesStateToNew() {
		
		addDocumentState.revert( document );
		
		assertThat( document.getState(), is( State.NEW ) );
	}
	
	@Test
	public void commitChangesStateToEnd() {
		
		addDocumentState.commit( document );
		
		assertThat( document.getState(), is( State.END ) );
	}
	
	@Test
	public void deleteChangesStateToEnd() {
		
		addDocumentState.delete( document );
		
		assertThat( document.getState(), is( State.END ) );
	}

	@Test
	public void saveDoesNotChangeState() {
		
		addDocumentState.save( document );
		
		assertThat( document.getState(), is( State.ADDED ) );
	}


}
