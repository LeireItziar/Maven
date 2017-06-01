package com.ipartek.formacion.leire.dal;

public class ProductoExistenteException extends RuntimeException {
	private static final long serialVersionUID = -7536930890973018777L;

	public ProductoExistenteException() {
		super();
	}

	public ProductoExistenteException(String message) {
		super(message);
	}

	public ProductoExistenteException(Throwable cause) {
		super(cause);
	}

	public ProductoExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductoExistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
