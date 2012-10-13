package core;

public interface DocumentState {

	public abstract void revert(Document document);

	public abstract void commit(Document document);

	public abstract void delete(Document document);

	public abstract void save(Document document);

}