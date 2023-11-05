
public class Plot {
	
	//Attributes 
	private int x, y, width, depth;
	
	//Constructors
	public Plot() {
		
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	
	//Accessors
	public void setX(int x) {
		this.x = x;
	 }
	 
	public void setY(int y) {
		this.y = y;
	 }
	 
	public void setWidth(int width) {
		this.width = width;
	 }
	 
	public void setDepth(int depth) {
		this.depth = depth;
	 }
	
	//Mutators
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	//toString
	public String toString() {
		return x+","+y+","+width+","+depth;
	}
	
	//Overlaps Method
	public boolean overlaps(Plot plot) {
		
		boolean flag = false;
		
		int x1 = this.x + this.y;
		int xWidth = x1 + this.width;
		int xDepth = x1 + this.depth;
		
		int y1 = plot.getX() + plot.getY();
		int yWidth = y1 + plot.getWidth();
		int yDepth = y1 + plot.getDepth();
		
		if(xWidth > y1 && y1 < xDepth)
			flag = true;
		else if (yWidth > x1 && xWidth < yDepth)
			flag = true;
		return flag;
	
	}
	
	//Encompasses Method
	public boolean encompasses(Plot plot) {
		
		boolean check = true;
		
		if(plot.getX() + plot.getWidth() > 10 || plot.getY() + plot.getDepth() > 10)
			check = false;
		
		return check;
	}

}
