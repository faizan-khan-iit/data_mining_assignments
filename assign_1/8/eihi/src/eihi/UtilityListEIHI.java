package eihi;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a UtilityList as used by the HUI-Miner algorithm.
 *
 * @see AlgoHUIMiner
 * @see Element
 */
public class UtilityListEIHI {

	// the last item of the itemset represented by this utility list
	public Integer item;
	// the sum of iutil values of D
	public int sumIutilsD = 0;
	// the sum of rutil values  of D
	public int sumRutilsD = 0;
	 
	// the sum of iutil values of D'
	public int sumIutilsDP = 0;
	// the sum of rutil values of D'
	public int sumRutilsDP = 0;
	
	// the list of elements in this utility list
	public List<Element> elementsD = new ArrayList<Element>();
	public List<Element> elementsDP = new ArrayList<Element>();

	/**
	 * Constructor
	 * @param item the last item of the itemset represented by this utility list
	 */
	public UtilityListEIHI(Integer item) {
		super();
		this.item = item;
	}

	/**
	 * Method to add an element to this utility list and update the sums at the same time.
	 * @param element the element to be added
	 * @param firstTIDOfDP the tid of the first transaction of DP
	 */
	public void addElementD(Element element/*, int firstTIDOfDP*/){
		sumIutilsD += element.iutils;
		sumRutilsD += element.rutils;
		elementsD.add(element);
	}
	
	/**
	 * Method to add an element to this utility list and update the sums at the same time.
	 * @param element the element to be added
	 * @param firstTIDOfDP the tid of the first transaction of DP
	 */
	public void addElementDP(Element element/*, int firstTIDOfDP*/){
			sumIutilsDP += element.iutils;
			sumRutilsDP += element.rutils;
			elementsDP.add(element);
	}

	public void switchDPtoD() {
		sumIutilsD += sumIutilsDP;
		sumIutilsDP = 0;
		sumRutilsD += sumRutilsDP;
		sumRutilsDP = 0;
		elementsD.addAll(elementsDP);
		elementsDP.clear();
	}
}
