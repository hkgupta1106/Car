import java.util.*;

public class controller implements UserChoice {
	
	public static Scanner scanner=new Scanner(System.in);
	public static ArrayList<Customer> customerList=new ArrayList<Customer>();	
	
		 public static void main(String args[]){
			char a;
			int id=1;
				
			do
			{
			displaymenu();
			
			int option=scanner.nextInt();
			
			switch(option)
			{
			case ADD_CUSTOMER:{	addcustomer(id);							
						id++;
			}
			break;
			
			case ADD_CAR_TO_CUSTOMER: addcartocustomer();
			break;
			
			case LIST_OF_ALL_CUSTOMER: displayallcustomer();
			break;
			
			case LIST_OF_INDIVIDUAL_CUSTOMER: displayindividualcustomer();
			break;
			
			case GENERATE_PRIZES: generateprize();				
			break;
			
			default : System.exit(1);
			}
			System.out.println("do u want to continue y or n");
			a=scanner.next().charAt(0);
		}while(a=='Y'||a=='y');
			scanner.close();
		}
		 
	public static void addcustomer(int id)
	{
		System.out.println("enter name of the customer");
		String name=scanner.next();
		System.out.println("A. Toyota\n"+"B. Maruti\n"+"C. Hyundai\n"+"enter choice of car\n");
		char choice=scanner.next().charAt(0);
		switch(choice)
		{
		case TOYOTA:{
			System.out.println("enter id ,model ,price of the car:");
			int idOfCar=scanner.nextInt();
			String model=scanner.next();
			int price=scanner.nextInt();
			Toyota toyota=new Toyota(idOfCar,model,price);
			Customer customer=new Customer(id,name,toyota);
			customerList.add(customer);
		}
		break;
		case MARUTI:{
			System.out.println("enter id ,model ,price of the car:");
			int idOfCar=scanner.nextInt();
			String model=scanner.next();
			int price=scanner.nextInt();
			Maruti maruti=new Maruti(idOfCar,model,price);
			Customer customer=new Customer(id,name,maruti);
			customerList.add(customer);
		}
		break;
		case HYUNDAI:{
			System.out.println("enter id ,model ,price of the car:");
			int idOfCar=scanner.nextInt();
			String model=scanner.next();
			int price=scanner.nextInt();
			Hyundai hyundai=new Hyundai(idOfCar,model,price);
			Customer customer=new Customer(id,name,hyundai);
			customerList.add(customer);
		}
		break;
		}
	}
	
	public static void displaymenu()


	{
		System.out.println("1.Add new customer.");
		System.out.println("2.Add new car to an existing customer.");
		System.out.println("3.list of all cutomers with their cars.");
		System.out.println("4.list of an individual customer.");
		System.out.println("5.generate prizes for customer.");
		System.out.println("enter your opton:");
	}
    
	public static void addcartocustomer()
    {
    	System.out.println("enter id of the customer");
		int id1=scanner.nextInt();
		int i=0;
		Customer customer=new Customer();
		Iterator<Customer> itr=customerList.iterator();
		while(itr.hasNext())
		{
			customer=itr.next();
			if(id1==customer.id)
			break;
			i++;
		}
		if(i!=customerList.size())
		{
			System.out.println("A. Toyota\n"+"B. Maruti\n"+"C. Hyundai\n"+"enter choice of car\n");
			char choice=scanner.next().charAt(0);		
			switch(choice)
			{
			case TOYOTA:{
				System.out.println("enter id ,model ,price of the car:");
				int idOfCar=scanner.nextInt();
				String model=scanner.next();
				int price=scanner.nextInt();
				Toyota toyota=new Toyota(idOfCar,model,price);	
				customer.initiallizer(toyota);
			}
			break;
			case MARUTI:{
				System.out.println("enter id ,model ,price of the car:");
				int idOfCar=scanner.nextInt();
				String model=scanner.next();
				int price=scanner.nextInt();
				Maruti maruti=new Maruti(idOfCar,model,price);
				customer.initiallizer(maruti);
			}
			break;
			case HYUNDAI:{
				System.out.println("enter id ,model ,price of the car:");
				int idOfCar=scanner.nextInt();
				String model=scanner.next();
				int price=scanner.nextInt();
				Hyundai hyundai=new Hyundai(idOfCar,model,price);
				customer.initiallizer(hyundai);
			}
			break;
			}
		}
		else
		{
			System.out.println("enter valid customer id");
		}
    }
	
	public static void displayallcustomer()
	{

		Iterator<Customer> itr=customerList.iterator();  
		  while(itr.hasNext())
		  {  
			  Customer customer=(Customer)itr.next();  
			    System.out.println(customer.id+" "+customer.name);  
			    customer.displayCars();
		  }
	}

	public static void displayindividualcustomer()
	{
		int i=0;
		System.out.println("enter id of customer you want to see");
		int id1=scanner.nextInt();
        Iterator<Customer> itr=customerList.iterator();
        while(itr.hasNext())
        {
        	Customer customer=(Customer)itr.next();  
        	if(customer.id==id1)
        	{
        		System.out.println(customer.id+" "+customer.name);  
			    customer.displayCars();
			    break;
        	}
        	i++;
        }
        if(i==customerList.size())
        	System.out.println("enter valid customer id");
	}
	
	public static void generateprize()
	{
		int k=0;
		int[] array=new int[3];
		int[] random=new int[6];
		int[] array1=new int[3];
		Random rand=new Random();
		System.out.println("enter any three id of the customers");
		for(int i=0;i<3;i++)
		{
			array[i]=scanner.nextInt();
		}
		for(int i=0;i<6;i++)
		{
			int randomNum = rand.nextInt((customerList.size() - 1) + 1) + 1;
			random[i]=randomNum;
		}
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<6;j++)
			{
				if(array[i]==random[j])
				{
					array1[k]=array[i];
					k++;
				}
			}
		}	
		System.out.println("Following id's are the winners:");
		for(int i=0;i<k;i++)
			System.out.println(array1[i]);
	}
}