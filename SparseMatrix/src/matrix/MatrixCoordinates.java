package matrix;

public class MatrixCoordinates {
	int x,y,val;
	
	private MatrixCoordinates(){}
	
	public MatrixCoordinates(int x,int y, int val){
		this.x=x;
		this.y=y;
		this.val=val;
	}
	
	public int getValue(){
		return val;
	}

	@Override
	public String toString() {
		return "( x= "+x+" y= "+y+" val= "+val+" )";
	}
	
}
