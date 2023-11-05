
public class ManagementCompany {
	
	//Attributes 
	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	String mgCompName, taxID;
	double mgmFee;
	Property properties[];
	Plot plot;
	int numberOfProperties;
	
	//Constructors
	public ManagementCompany(){
		
		mgCompName = "";
		taxID = "";
		
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(0,0,MGMT_DEPTH,MGMT_WIDTH);
		
	}
	
	public ManagementCompany(String name, String tax, double fee){
		
		mgCompName = name;
		taxID = tax;
		mgmFee = fee;
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(0,0,MGMT_DEPTH,MGMT_WIDTH);
		
	} 
	
	public ManagementCompany(String name, String tax, double fee, int x, int y, int width, int depth) {
		
		mgCompName = name;
		taxID = tax;
		mgmFee = fee;
		
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
		
	}

	public ManagementCompany(ManagementCompany m) {
		
		this.mgCompName = m.mgCompName;
		this.taxID = m.taxID;
		this.mgmFee = m.mgmFee;
		
		this.plot = new Plot(m.getPlot());
		properties = m.properties;
		this.numberOfProperties = m.numberOfProperties;
		
	}
	
	//Methods
	public int addProperty(Property p) {
		
		boolean first = false, encompass = false, overlap = true, add = false, full = true, empty = true;
		int index = 0, check = 99;
		
		encompass = p.getPlot().encompasses(p.getPlot());
		
		full = isPropertiesFull();
		
		if(p.getPlot() == null)
			empty = true;
		
		if(encompass = true) {
				
			if(properties[0] == null) {
				properties[0] = p;
				first = true;
			}
			
			else if(first = false){
					
				for(int element = 0; properties[index] != null; index ++)
				{
					overlap = properties[index].getPlot().overlaps(p.getPlot());
					
				}
				
				if(overlap = false) {
					
					while(add = false) {
						
						if(properties[index] == null) {
							properties[index] = p;
							add = true;
						}
						index ++;
					}
				}
			}	
		}
		
		
		if(first = true) 
			check = 0;
		else if(add = true)
			check = index;
		else if(full = true)
			check = -1;
		else if(empty = true)
			check = -2;
		else if(encompass)
			check = -3;
		else if(overlap = true)
			check = -4;
		
		return check;
	}
	
	public void removeLastProperty() {
		
		for(int index = properties.length - 1; index >= 0; index --) {
			
			if(properties[index] != null)
				properties[index] = null;
			
		}
			
	}
	
	public boolean isPropertiesFull() {
		
		boolean check = false;
		if(properties[properties.length -1] == null)
			check = true;
		return check;
	}
	
	public int getPropertiesCount() {
		
		int num = 0;
		
		for(int index = 0;index < properties.length; index++) {
			
			if(properties[index] != null)
				num ++;
		}
		return num;
	}
	
	public double getTotalRent() {
		double amount = 0.0;
		
		for(int index = 0; index < properties.length; index ++) {
			
			if(properties[index] != null)
				amount += properties[index].getRentAmount();
		}
		
		return amount;
	}
	
	public Property getHighestRentPropperty() {
		
		double highest = properties[0].getRentAmount();
		int index = 0;
		
		for(int element = 1; element < properties.length; element++) {
			
			if(properties[element].getRentAmount() > highest) {
				highest = properties[element].getRentAmount();
				index = element;
			}	
		}
		
		return properties[index];
	}
	
	public boolean isMangementFeeValid() {
		
		boolean check = false;
		
		if(mgmFee >= 0 && mgmFee <= 100)
			check = true;
		
		return check;
	}
	
	public String getName() {
		return this.mgCompName;
	}
	
	public String getTaxID() {
		return this.taxID;
	}

	public Property[] getProperties() {
		
		return this.properties;
	}
	
	public double getMgmFeePer() {
		return this.mgmFee;
	}

	public Plot getPlot() {
		return this.plot;
	}

	public String toString() {
		
		String line = "";
		
		for(int index = 0; index < properties.length; index++)
			line += properties[index].toString() + "\n";
			
		return "List of properties for "+ properties[0].getOwner()+", taxID: "+ this.getTaxID()+"\n"+
			   line+ "\nTotal management Fee: " + (getTotalRent() * getMgmFeePer())/100; 
			   
	}

}
