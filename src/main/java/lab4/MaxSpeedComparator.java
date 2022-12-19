package lab4;

import java.util.Comparator;

public class MaxSpeedComparator implements Comparator<Car> {
	@Override
	public int compare(Car car1,Car car2){
		return car1.getMaxSpeed()-car2.getMaxSpeed();
	}
}
