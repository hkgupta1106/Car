import java.util.*;
public class Customer {
	 String name;
	 int id;
	 ArrayList<Car> carList=new ArrayList<Car>();
	 
	 Customer(){}
	 
	Customer(int id,String name,Car car)
	{
		this.id=id;
		this.name=name;
		carList.add(car);
	}
	
	void initiallizer(Car car)
	{
		carList.add(car);
	}
	
	void displayCars()
	{
		Iterator<Car> itr=carList.iterator();
		while(itr.hasNext())
		{
			Car car=(Car)itr.next();  
		    System.out.println(car.carName+" "+car.id+" "+car.model+" "+car.price+" "+car.resaleValues);  
		}
	}
	
}