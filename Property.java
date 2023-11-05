
public class Property {
	
	//Attributes
	private String propertyName, city, owner;
	private double rentAmount;
	private Plot plot;
	
	//Constructor
	public Property() {
		
	}
	
	public Property(String pName, String city, double amount, String owner) {
		this.propertyName = pName;
		this.city = city;
		this.rentAmount = amount;
		this.owner = owner;
	}
	
	public Property(String pName, String city, double amount, String owner, int x, int y, int width, int depth) {
		this.propertyName = pName;
		this.city = city;
		this.rentAmount = amount;
		this.owner = owner;
		
		this.plot = new Plot(x,y,width,depth);
		
	}
	
	public Property(Property p) {
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.owner = p.owner;
		this.rentAmount = p.rentAmount;
	}
	//toString
	public String toString() {
		return "Property Name: "+this.propertyName+ " City: "+ this.city + 
			   " Owner: "+ this.owner + " Rent Amount: " + this.rentAmount;
	}
	
	
	//Methods
	public Plot getPlot() {
		return new Plot(this.plot);
	}
	
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public double getRentAmount() {
		return this.rentAmount;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	
}
