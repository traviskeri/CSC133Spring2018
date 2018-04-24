package com.mycompany.a2;

public class Flag extends Fixed{
	
	private int sequenceNumber;
	private String name = "Flag";
	
	/**
	 * This is the constructor for Flag it calls the constructor for Fixed to set the fields that can not be changed
	 * then sets the rest of the fields
	 * @param sequenceNumber int
	 * @param size int
	 * @param color int
	 * @param x float
	 * @param y float
	 */
	public Flag(int sequenceNumber, int size, int color, int x, int y) {
		super(x, y, color, size);
		this.sequenceNumber = sequenceNumber;
	}
	
	/**
	 * This method overrides the toString method in Fixed
	 * It addes the name and the flags sequence number then calls super.toString to add on the rest of the information
	 * @return String
	 */
	@Override
	public String toString() {
		String rv;
		rv = name + super.toString() + " seqNum=" + this.getSequenceNumber();
		return rv;
	}
	
	/**
	 * This method overrides the setColor method because it is not allowed to change color
	 */
	@Override
	public void setColor(int color) {}

	/**
	 * This method returns the sequence number of the flag.
	 * @return int
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * This method sets the sequence number of the flag
	 * @param sequenceNumber int 
	 */
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
}
