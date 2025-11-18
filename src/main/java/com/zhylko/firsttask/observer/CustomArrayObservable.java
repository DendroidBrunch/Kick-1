package com.zhylko.firsttask.observer;

public interface CustomArrayObservable {

	void addCustomArrayObserver(CustomArrayObserver observer);
	void removeCustomArrayObserver();
	void notifyCustomArrayObserver();
}
