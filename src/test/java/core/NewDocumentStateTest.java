package core;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.io.File;

import org.junit.Test;

public class NewDocumentStateTest {

	@Test
	public void revertDoesNotChangeDocumentsState() {
		Document document = new Document();
		NewDocumentState newDocumentState = new NewDocumentState();
		
		newDocumentState.revert( document );
		
		assertThat( document.getState(), is( State.NEW ) );
	}

	@Test
	public void saveChangesStateToModifiedIfFileExists() throws Exception {
		Document document = new Document();
		NewDocumentState newDocumentState = new NewDocumentState();

		File file = mock( File.class );
		when( file.exists() ).thenReturn( true );
		document.setFile( file );

		newDocumentState.save( document );
		
		assertThat( document.getState(), is(State.MODIFIED) );
	}
	
	@Test
	public void saveChangesStateToAddedIfFileDoesNotExist() throws Exception {
		Document document = new Document();
		NewDocumentState newDocumentState = new NewDocumentState();
		
		File file = mock( File.class );
		when( file.exists() ).thenReturn( false );
		document.setFile( file );
		
		newDocumentState.save( document );
		
		assertThat( document.getState(), is(State.ADDED) );
	}

}
