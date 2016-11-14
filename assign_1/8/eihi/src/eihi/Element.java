package eihi;

public class Element {
	/** transaction id */
	final int tid ;   
	/** itemset utility */
	final int iutils;   
	/** remaining utility */
	int rutils; 
	
	public Element(int tid, int iutils, int rutils){
		this.tid = tid;
		this.iutils = iutils;
		this.rutils = rutils;
	}
}
