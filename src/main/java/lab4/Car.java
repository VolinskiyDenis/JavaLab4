package lab4;
import javax.validation.constraints.*;

public class Car implements Comparable<Car>{
	/**
	 * plateNumber looks like AA0000BB
	 * plateNumber and model are required fields,
	 * rest fields are optionally
	 */
	@NotNull(message = "must be not null")
	 private final Brand brand;
	@Pattern(regexp = "[A-Z]{2}[0-9]{4}[A-Z]{2}", message = "must start from 2 letters four numbers and 2 letters")
	 private String plateNumber;
	 private final String model;
	@Pattern(regexp = "red|blue|gray|white|black|yellow|green|silver|brown|orange|beige|purple|gold", message = "must be a color")
	 private String color;
	@Max(value = 420, message = "max speed is 420")
	 private final int maxSpeed;
	@Min(value = 0, message = "speed is a positive value")
	 private int currentSpeed;
	@NotEmpty
	@NotNull(message = "must be not null")
	 private String holder;

	/**
	 * below there are static class Builder which contains two required fields and four optional
	 */
	public static class Builder {

		private Brand brand;
		private String plateNumber;
		private String model;
		private String color = "white";
		private int maxSpeed;
		private int currentSpeed = 0;
		private String holder;

		/**
		 * @param brand		  is car brand
		 * @param plateNumber is car identifier which doesn't repeat.
		 * @param model       is car model.
		 * @param maxSpeed 	  is car max speed getting from technical characteristics
		 *                    all parameters are required.
		 */
		public Builder(Brand brand, String plateNumber, String model, int maxSpeed){
			this.brand = brand;
			this.plateNumber = plateNumber;
			this.model = model;
			this.maxSpeed = maxSpeed;
			this.holder = holder;

		}

		/**
		 * @param color is a car color
		 * @return the same object Builder class
		 */

		public Builder setColor(String color){
			this.color = color;
			return this;
		}

		/**
		 * @param currentSpeed is a variable of current speed of car and equals zero at initializing
		 * @return the same object Builder class
		 */

		public Builder setCurrentSpeed(int currentSpeed){
			this.currentSpeed = currentSpeed;
			return this;
		}

		/**
		 * @param holder is car owner
		 * @return the same object Builder class
		 */
		public Builder setHolder(String holder){
			this.holder = holder;
			return this;
		}

		/**
		 * this method call constructor outer class
		 *
		 * @return instance our class
		 */
		public Car buidl(){
			return new Car(this);
		}
	}

	/**
	 * @param builder give values to the instance
	 */
	public Car(Builder builder){
		brand = builder.brand;
		plateNumber = builder.plateNumber;
		model = builder.model;
		color = builder.color;
		maxSpeed = builder.maxSpeed;
		currentSpeed = builder.currentSpeed;
		holder = builder.holder;
	}

	public String getPlateNumber(){
		return plateNumber;
	}

	public int getMaxSpeed(){
		return maxSpeed;
	}


	/**
	 * method increases value of currentSpeed value
	 */

	public void gas(int value) throws RuntimeException{
		if(currentSpeed + value > maxSpeed){
			throw new RuntimeException();
		}
		currentSpeed = currentSpeed + value;
		//System.out.println("Прискорюємось до " + getCurrentSpeed() + " КМ/год");
	}

	/**
	 * method decrease value of currentSpeed value
	 */

	public void brake(int value) throws RuntimeException{
		if(currentSpeed - value < 0){
			throw new RuntimeException();
		}
		currentSpeed = currentSpeed - value;
		//System.out.println("Уповільнюємось до " + getCurrentSpeed() + " КМ/год");
	}


	/**
	 * needs for watching at the instance
	 *
	 * @return string with all instance fields
	 */

	public String toString(){
		return "Марка: " + brand + "\tМодель: " + model + "\tКолір: " + color + "\tМакс. Швидкість: " + maxSpeed + "\tВласник: " + holder + "\tПоточна швидкість: " + currentSpeed;
	}

	public String getOwner(){
		return holder;
	}


	/**
	 * needs for HashMap and others
	 *
	 * @return integer
	 */

	public int hashCode(){
		return 31 * (plateNumber != null ? 0 : plateNumber.hashCode());
	}

	/**
	 * check that the instances match each other
	 *
	 * @param obj is a one of matching instances. The another call this method
	 * @return true if the instances are equal and false if not
	 */

	public boolean equals(Object obj){
		if(obj == null || obj.getClass() != this.getClass()) return false;
		else if(obj == this) return true;
		Car car = (Car) obj;
		return plateNumber == car.plateNumber || (plateNumber != null && plateNumber.equals(car.plateNumber));
	}

	@Override
	public int compareTo(Car c){
		return this.brand.compareTo(c.brand);
	}
}