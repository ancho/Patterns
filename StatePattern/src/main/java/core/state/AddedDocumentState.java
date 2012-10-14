package core.state;

import core.Document;
import core.Document.State;

//TODO rename to AddedDocumentState
public class AddedDocumentState implements DocumentState {

	/* (non-Javadoc)
	 * @see core.DocumentState#revert(core.Document)
	 */
	@Override
	public void revert(Document document) {
		//TODO: Execute command here
		document.setState( State.NEW );
	}

	/* (non-Javadoc)
	 * @see core.DocumentState#commit(core.Document)
	 */
	@Override
	public void commit(Document document) {
		//TODO: Execute command here
		document.setState( State.END );
	}

	/* (non-Javadoc)
	 * @see core.DocumentState#delete(core.Document)
	 */
	@Override
	public void delete(Document document) {
		//TODO: Execute command here		
		document.setState( State.END );
	}

	/* (non-Javadoc)
	 * @see core.DocumentState#save(core.Document)
	 */
	@Override
	public void save(Document document) {
		//Nothing to do here
	}

}
