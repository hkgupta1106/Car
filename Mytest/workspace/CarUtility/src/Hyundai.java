
public class Hyundai extends Car{
	
	Hyundai(int id,String model,int price)
	{
		this.id=id;
		this.model=model;
		this.price=price;
		resaleValues= 0.4*price;
		carName="Hyundai";
	}
}
