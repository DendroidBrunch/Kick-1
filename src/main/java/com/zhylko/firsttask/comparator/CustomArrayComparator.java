package com.zhylko.firsttask.comparator;

import java.util.Comparator;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.service.impl.CustomArrayServiceImpl;

public enum CustomArrayComparator implements Comparator<CustomArray>{
	BY_ID{
		public int compare(CustomArray customArray1, CustomArray customArray2) {
			return Long.compare(customArray1.getCustomArrayId(), customArray2.getCustomArrayId());
		}
	},
	BY_FIRST_ELEMENT{
		public int compare(CustomArray customArray1, CustomArray customArray2) {
			int result;
			try {
				result = Integer.compare(customArray1.get(0), customArray2.get(0));
			} catch (CustomArrayException e) {
				result = 0; 
			}
			return result;
		}
	},
	BY_LENGTH{
		public int compare(CustomArray customArray1, CustomArray customArray2) {
			return Integer.compare(customArray1.getLength(), customArray2.getLength());
		}
	},
	BY_SUM{
		public int compare(CustomArray customArray1, CustomArray customArray2) {
			int result;
			CustomArrayServiceImpl service = new CustomArrayServiceImpl();
			try {
				int sum1 = service.countSum(customArray1).get();
				int sum2 = service.countSum(customArray2).get();
				result = Integer.compare(sum1, sum2);
			} catch (CustomArrayException e) {
				result = 0; 
			}
			return result;
		}
	}
}
