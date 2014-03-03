/**
 * 
 */
package fiusac.ia1.jarras;

/**
 * @author david
 *
 */
public class JarraException extends Exception {

	public Jarra jarra;
	public String msg;
	/**
	 * 
	 */
	public JarraException(Jarra jarra) {
		this.jarra = jarra;
	}

	/**
	 * @param message
	 */
	public JarraException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public JarraException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public JarraException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public JarraException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
