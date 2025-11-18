package com.zhylko.firsttask.entity;

import java.util.Arrays;

import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.observer.CustomArrayObservable;
import com.zhylko.firsttask.observer.CustomArrayObserver;

public class CustomArray implements CustomArrayObservable{
	private long customArrayId;
	private int[] array;
	private CustomArrayObserver observer;
	
	private CustomArray() {
	}
	
	public long getCustomArrayId() {
		return customArrayId;
	}
	
	public int getLength() {
		return array.length;
	}
	
	public int[] getArray() {
		return array;
	}
	
	public int get(int index) throws CustomArrayException {
		if(index < 0 || index > array.length) {
			throw new CustomArrayException("Index out of bounds: " + index);
		}
		return array[index];
	}
	
	public int set(int index, int value)  throws CustomArrayException{
		if(index < 0 || index > array.length) {
			throw new CustomArrayException("Index out of bounds: " + index);
		}
		int ret = array[index];
		array[index] = value;
		
		CustomArray.this.notifyCustomArrayObserver();
		return ret;
	}
	
	public void setArray(int[] newArray) throws CustomArrayException{
		if(newArray == null) {
			throw new CustomArrayException("Array is not initialized");
		}
		
		array = Arrays.copyOf(newArray, newArray.length);
		CustomArray.this.notifyCustomArrayObserver();
	}
	
	@Override
	public void addCustomArrayObserver(CustomArrayObserver observer) {
		if(observer != null) {
			this.observer = observer;
		}
	}

	@Override
	public void removeCustomArrayObserver() {
		observer = null;
	}

	@Override
	public void notifyCustomArrayObserver() {
		if(observer != null) {
			observer.update(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		result = prime * result + (int) (customArrayId ^ (customArrayId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CustomArray other = (CustomArray) obj;
		if (!Arrays.equals(array, other.array)) {
			return false;
		}
		if (customArrayId != other.customArrayId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomArray [customArrayId=");
		builder.append(customArrayId);
		builder.append(", array=");
		builder.append(Arrays.toString(array));
		builder.append("]");
		return builder.toString();
	}
	
	public static CustomArrayBuilder newCustomArrayBuilder() {
		return new CustomArray().new CustomArrayBuilder();
	}
	
	public class CustomArrayBuilder{

		private CustomArrayBuilder() {
		}
		
		public CustomArrayBuilder setCustomArrayId(long id) {
			CustomArray.this.customArrayId = id;
			return this;
		}
		
		public CustomArrayBuilder setArray(int length) throws CustomArrayException {
			if(length < 0) {
				throw new CustomArrayException("Illegal array length: " + length);
			}
			CustomArray.this.array = new int[length];
			return this;
		}
		
		public CustomArrayBuilder setArray(int[] values) {
			CustomArray.this.array = Arrays.copyOf(values, values.length);
			return this;
		}
		
		public CustomArrayBuilder setArray(String[] values) {
			int length = values.length;
			int [] arrayValue = new int[length];
			for(int i = 0; i < length; i++) {
				arrayValue[i] = Integer.parseInt(values[i]);
			}
			CustomArray.this.array = Arrays.copyOf(arrayValue, length);
			return this;
		}
		
		public CustomArrayBuilder setObserver(CustomArrayObserver observer) {
			if(observer != null) {
				CustomArray.this.observer = observer;
			}
			return this;
		}
		
		public CustomArray build() {
			if(array == null) {
				array = new int[0];
			}
			CustomArray.this.notifyCustomArrayObserver();
			return CustomArray.this;
		}
	}
}