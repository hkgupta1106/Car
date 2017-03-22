
public class Toyota extends Car{
	
	Toyota(int id,String model,int price)
	{
		this.id=id;
		this.model=model;
		this.price=price;
		resaleValues= 0.8*price;
		carName="Toyota";
	}
}
