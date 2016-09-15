package jp.ne.ravisite.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BatchException extends RuntimeException{

	private Logger logger = LogManager.getLogger(BatchException.class);

	/**
	 * generate serialVersionUID
	 */
	private static final long serialVersionUID = 2250998780000016393L;

	public BatchException() {

	}

	/**
	 * メッセージ出力
	 * @param message
	 */
	public BatchException(String message) {
		super(message);
		logger.error(message);
	}

	/**
	 * スタックトレース出力
	 * @param cause
	 */
	public BatchException(Throwable cause) {
		super(cause);
		cause.printStackTrace();
		logger.error(cause);
	}

	/**
	 * メッセージ & スタックトレース出力
	 * @param message
	 * @param cause
	 */
	public BatchException(String message, Throwable cause) {
		super(cause);
		cause.printStackTrace();
		logger.error(message, cause);
	}

}
