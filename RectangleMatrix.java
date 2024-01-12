package home2;

public class RectangleMatrix {
	boolean[][] values;
	
	public RectangleMatrix(int m, int n) {
		this.values = new boolean[m][n];
	}
	
	public RectangleMatrix(int m, int n, boolean v) {
		this(m, n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				this.set(i, j, v);
			}
		}
		
	}
	
	public void set(int m, int n, boolean v) {
		this.values[m][n]=v;
	}
	
	public boolean getVal(int i, int j) {
		return values[i][j];
	}
	
	public void resetValues() {
		for(int i=0; i<values.length;i++) {
			
			for(int j=0; j<values[i].length;j++) {
				this.set(i, j, false);
			}
			
		}
	}
	
	
	public int rowLen() {
		return values.length;
	}
	
	public int colLen() {
		return values[0].length;
	}
	
}
