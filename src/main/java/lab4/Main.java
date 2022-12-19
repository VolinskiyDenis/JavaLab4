package lab4;

public class Main {
	public static void main(String[] args){
		Park park = new Park();
		park.createCars();
		try{
			park.validate();
		}catch(IllegalArgumentException e){
			System.out.println(e.getStackTrace());
		}
	}
}
