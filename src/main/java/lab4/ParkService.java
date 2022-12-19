package lab4;

import java.util.*;

public class ParkService {
	private Park park;
	public ParkService(Park park){
		this.park=park;
	}

	public List<Car> getCars(){

		return park.getCars();
	}

	public boolean addCar(Car car){
		return park.getCars().add(car);
	}

	public List<Car> sortByBrand(){
		List<Car> cars = new ArrayList<>();
		cars.addAll(park.getCars());
		Collections.sort(cars);
		return cars;
	}
	public List<Car> sortByMaxSpeed(){
		List<Car> cars = new ArrayList<>();
		cars.addAll(park.getCars());
		Collections.sort(cars,new MaxSpeedComparator());
		return cars;
	}
	public List<Car> clearPark(){
		List<Car> cars = new ArrayList<>();
		cars.addAll(park.getCars());
		Collection<Car> list = cars;
		list.clear();
		return cars;
	}
	public List<Car> findByOwner (String owner){
		List<Car> cars = new ArrayList<>();
		for(Car car : park.getCars()){
			if(car.getOwner().equals(owner))
				cars.add(car);
		}
		return cars;
	}
}