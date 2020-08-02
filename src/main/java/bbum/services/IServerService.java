package bbum.services;

/**
 * Interface for services that can be applied by the server
 * @author shaharb
 *
 * @param <T>
 */
public interface IServerService<T> {
	public T apply();
}
