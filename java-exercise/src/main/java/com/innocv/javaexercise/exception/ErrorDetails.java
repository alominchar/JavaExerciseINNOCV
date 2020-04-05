package com.innocv.javaexercise.exception;

import java.util.Date;

/**
 * Class to specify the details of the error messages of the application
 * @author Abraham Lominchar
 *
 */
public class ErrorDetails {

	/**
	 * Variable timestamp for showing the date of the error
	 */
	private Date timestamp;
	
	/**
	 * Variable message for showing the message of the error
	 */
    private String message;
    
    /**
     * Variable details for showing the details of the error
     */
    private String details;
    
    /**
     * Constructor with all the parameters
     * @param timestamp The timestamp to initialize
     * @param message The message to initialize
     * @param details The details to initialize
     */
    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	
}
