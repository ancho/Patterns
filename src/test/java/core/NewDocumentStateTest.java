package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class NewDocumentStateTest {

	private Document document;
	private NewDocumentState newDocumentState;
	
	@Before
	public void setUp() {
		document = new Document();
		newDocumentState = new NewDocumentState();
	}

	@Test
	public void revertDoesNotChangeDocumentsState() {
		
		newDocumentState.revert( document );
		
		assertThat( document.getState(), is( State.NEW ) );
	}

	@Test
	public void saveChangesStateToModifiedIfFileExists() throws Exception {

		mockFileExists( true );

		newDocumentState.save( document );
		
		assertThat( document.getState(), is(State.MODIFIED) );
	}

	
	@Test
	public void saveChangesStateToAddedIfFileDoesNotExist() throws Exception {
		
		mockFileExists(false);
		
		newDocumentState.save( document );
		
		assertThat( document.getState(), is(State.ADDED) );
	}
	
	@Test
	public void deleteChangesStateToEnd() throws Exception {
		
		newDocumentState.delete( document );
		
		assertThat( document.getState(), is(State.END) );
	}

	private void mockFileExists(boolean exists) {
		File file = mock( File.class );
		when( file.exists() ).thenReturn( exists );
		document.setFile( file );
	}

}
