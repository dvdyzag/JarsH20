/**
 * 
 */
package fiusac.ia1.jarras;

/**
 * @author david
 *
 */
public class JarraVacioException extends JarraException {

	/**
	 * @param jarra
	 */
	public JarraVacioException(Jarra jarra) {
		super(jarra);
		this.msg = "Vacio";
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public JarraVacioException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public JarraVacioException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public JarraVacioException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public JarraVacioException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
