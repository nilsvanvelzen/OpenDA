package org.openda.exchange;

import org.openda.interfaces.IExchangeItem;
import org.openda.interfaces.IGeometryInfo;
import org.openda.interfaces.IQuantityInfo;
import org.openda.interfaces.ITimeInfo;
import org.openda.utils.MyObservable;

/**
 * Simple exchangeItem for String data. You can add a listener in eg the IDataObject
 * to take action on changes.
 * 
 * @author verlaanm
 *
 */
public class IntExchangeItem extends MyObservable implements IExchangeItem{
	private int value;
	private String id;
	private Role role=Role.InOut;
	private IQuantityInfo quantityInfo;
	
	public IntExchangeItem(String id, Role role, int value){
		this.value = value;
		this.role = role;
		this.id = id;
	}
	
	public IntExchangeItem(String id, Role role){
		this(id, role, 0);
	}
	
	
	public Role getRole() {
		return this.role;
	}

	
	public String getId() {
		return this.id;
	}

	
	public String getDescription() {
		return this.id;
	}

	
	public void copyValuesFromItem(IExchangeItem sourceItem) {
		ValueType sourceType=sourceItem.getValuesType();
		if(sourceType==ValueType.intType){
			this.value=(Integer)sourceItem.getValues();
			this.notifyObservers();
		}
	}

	
	public ITimeInfo getTimeInfo() {
		return null;
	}

	
	public IQuantityInfo getQuantityInfo() {
		return this.quantityInfo;
	}
	
	public void setQuantityInfo(IQuantityInfo quantityInfo){
		this.quantityInfo=quantityInfo;
		this.notifyObservers();
	}

	
	public IGeometryInfo getGeometryInfo() {
		return null;
	}

	
	public ValueType getValuesType() {
		return ValueType.intType;
	}

	
	public Object getValues() {
		return this.value;
	}

	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value=value;
		this.notifyObservers();
	}
	
	/*
	 * =======================================================================
	 * The following methods are due to the old interface and will be removed
	 * later.
	 * =======================================================================
	 */
	
	
	@SuppressWarnings("rawtypes")
	
	@Deprecated public Class getValueType() {
		return String.class;
	}

	
	@Deprecated public double[] getTimes() {
		return null;
	}

	
	@Deprecated public void setTimes(double[] times) {
		throw new UnsupportedOperationException("setTimes method make no sense for a IntExchangeItem");		
	}

	
	@Deprecated public void setValuesAsDoubles(double[] values) {
		throw new UnsupportedOperationException("setValuesAsDoubles method make no sense for a IntExchangeItem");		
	}

	
	@Deprecated public double[] getValuesAsDoubles() {
		throw new UnsupportedOperationException("getValuesAsDoubles method make no sense for a IntExchangeItem");
	}

	
	@Deprecated public void axpyOnValues(double alpha, double[] axpyValues) {
		throw new UnsupportedOperationException("axpy method make no sense for a IntExchangeItem");
	}

	
	@Deprecated public void multiplyValues(double[] multiplicationFactors) {
		throw new UnsupportedOperationException("multiplyValues method make no sense for a IntExchangeItem");
	}

	
	@Deprecated public void setValues(Object values) {
		if(values instanceof Integer){
			this.value = (Integer) values;
			this.notifyObservers();
		}else{
			throw new UnsupportedOperationException("Can only set values for an Integer object");
		}
	}

}
