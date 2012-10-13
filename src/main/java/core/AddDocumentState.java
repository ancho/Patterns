package core;

public class AddDocumentState implements DocumentState {

	/* (non-Javadoc)
	 * @see core.DocumentState#revert(core.Document)
	 */
	@Override
	public void revert(Document document) {
		document.setState( State.NEW );
	}

	/* (non-Javadoc)
	 * @see core.DocumentState#commit(core.Document)
	 */
	@Override
	public void commit(Document document) {
		document.setState( State.END );
	}

	/* (non-Javadoc)
	 * @see core.DocumentState#delete(core.Document)
	 */
	@Override
	public void delete(Document document) {
		document.setState( State.END );
	}

	/* (non-Javadoc)
	 * @see core.DocumentState#save(core.Document)
	 */
	@Override
	public void save(Document document) {
		
	}

}
