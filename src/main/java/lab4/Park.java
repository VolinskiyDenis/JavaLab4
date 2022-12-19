package lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;

public class Park {
	private List<Car> cars;

	public List<Car> getCars(){
		return cars;
	}
	Park(){
		cars = new ArrayList<>();
	}
	Park(List<Car> cars){
		this.cars = cars;
	}

	public List<Car> createCars(){
		cars.add(new Car.Builder(null, "AA0000AA", "X6", 270)
				.setColor("red")
				.setHolder("Evgen Zaliznyak")
				.buidl());
		cars.add(new Car.Builder(Brand.Mercedes_Benz, "AO6009AB", "Vito", 280)
				.setColor("yellow")
				.setHolder("Ivan Semenyak")
				.buidl());
		cars.add(new Car.Builder(Brand.Audi, "AA4792BO", "A6", 260)
				.setColor("gray")
				.setCurrentSpeed(20)
				.setHolder("Denis Volinskiy")
				.buidl());
		return cars;
	}

	public void validate(){
		// create  default validator
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		// create set of instances constraints
		Set<ConstraintViolation<Car>> constraintViolations1 = validator.validate(cars.get(0));
		Set<ConstraintViolation<Car>> constraintViolations2 = validator.validate(cars.get(1));
		Set<ConstraintViolation<Car>> constraintViolations3 = validator.validate(cars.get(2));
		// union sets
		Set<ConstraintViolation<Car>> constraintViolations = mergeSet(mergeSet(constraintViolations1, constraintViolations2), constraintViolations3);
		for(ConstraintViolation constraintViolation : constraintViolations){
			// get name
			String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
			// get message
			System.out.println(fieldName + " " + constraintViolation.getMessage());
			throw new IllegalArgumentException();
		}
	}
	public static <T> Set<T> mergeSet(Set<T> a, Set<T> b){
		HashSet<T> hashSet = new HashSet<T>();
		hashSet.addAll(a);
		hashSet.addAll(b);
		return hashSet;
	}
}