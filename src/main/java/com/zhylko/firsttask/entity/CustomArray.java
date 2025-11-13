package com.zhylko.firsttask.entity;

import java.util.Arrays;

import com.zhylko.firsttask.exception.CustomArrayException;

public class CustomArray  {
	private long customArrayID;
	private int[] array;
	
	private CustomArray() {
	}
	
	public long getCustomArrayID() {
		return customArrayID;
	}
	
	public int getLength() {
		if(array == null) return -1;
		return array.length;
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
		return ret;
	}
	
	public static CustomArrayBuilder newCustomArrayBuilder() {
		return new CustomArray().new CustomArrayBuilder();
	}
	public class CustomArrayBuilder{

		private CustomArrayBuilder() {
		}
		
		public CustomArrayBuilder setCustomArrayID(long ID) {
			CustomArray.this.customArrayID = ID;
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
		
		public CustomArray build() {
			if(array == null) {
				array = new int[0];
			}
			return CustomArray.this;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		result = prime * result + (int) (customArrayID ^ (customArrayID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomArray other = (CustomArray) obj;
		if (!Arrays.equals(array, other.array))
			return false;
		if (customArrayID != other.customArrayID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomArray [customArrayID=");
		builder.append(customArrayID);
		builder.append(", array=");
		builder.append(Arrays.toString(array));
		builder.append("]");
		return builder.toString();
	}
}