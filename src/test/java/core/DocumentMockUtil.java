package core;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;

public class DocumentMockUtil {
	private Document document;
	
	public DocumentMockUtil(Document document) {
		this.document = document;
	}

	public void mockFileExists(boolean exists) {
		File file = mock( File.class );
		when( file.exists() ).thenReturn( exists );
		document.setFile( file );
	}

}
