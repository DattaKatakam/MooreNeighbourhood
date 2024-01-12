package home2;

import processing.core.*;

public class Pattern1 {
	
	//defining final values for rowa and coloumns
	private static final int row=40;
	private static final int col=40;
	 
	//defining box area
	private static final float BOX_BASE_AREA_SIZE = 5;
	  
	  //Defining starting Points
	private static final float ELEMENT_POS_X = 0;
	private static final float ELEMENT_POS_Y = 0;
	  
	  //Defining color constants
	private static final float COLOR_MIN = 50;
	private static final float COLOR_MAX = 360;
	private static final float COLOR_SATURATION = 180;
	private static final float COLOR_BRIGHTNESS = 180;
	
	//defining RectangleMatrix one for living automata and other for storing values
	RectangleMatrix R;
	RectangleMatrix dummy;
	
	// constructor with initial values initialization
	public Pattern1() {
		R= new RectangleMatrix(row,col,false);
		dummy = new RectangleMatrix(row,col,false);
		R.set(15, 15, true);
		R.set(15, 16, true);
		R.set(16, 15, true);
		R.set(16, 16, true);
		
	}
	
	
	// Main code for evolution in various generations
	public void animate(int Evolv, PApplet app) {
		
		for(int gen = 1; gen < Evolv; gen++) {
			
			for(int i = 0; i < R.rowLen(); i++) {
				
				for(int j = 0; j < R.colLen(); j++) {
					
					//checking for living automata
					if (R.getVal(i, j)==true) {
						
						float relatives=0;
						try { if (R.getVal(i-1, j-1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i-1, j) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i-1, j+1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i, j-1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i, j+1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i+1, j-1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i+1, j) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i+1, j+1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						
						
						if(relatives ==2 || relatives ==3) {
							dummy.set(i, j, true);
						}
						
						else {
							dummy.set(i, j, false);
						}
						
						
					}
					
					//checking for Dead cell
					if (R.getVal(i, j)==false) {
						
						float relatives=0;
						try { if (R.getVal(i-1, j-1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i-1, j) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i-1, j+1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i, j-1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i, j+1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i+1, j-1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i+1, j) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						try { if (R.getVal(i+1, j+1) == true) 	 { relatives++ ;} } catch (Exception e) {  }
						
						
						if(relatives ==3) {
							dummy.set(i, j, true);
						}
						
						else {
							dummy.set(i, j, false);
						}
						
					}
					
				}
				
			}
			
			//assigning values to original RectangleMatrix
			for(int i = 0; i< row; i++) {
				
				for(int j =0; j<col; j++) {
					
					R.set(i, j, dummy.getVal(i, j));
					
				}
				
			}
						
		}
		
		// below code can be used when draw method is not used in test file
		//Pattern1.plotAnimate(R, app);
		
	}
	
	
	public void plotAnimation(PApplet app) {
		// below code can be used when draw method is used in test file
		// calling plotAnimate method
		Pattern1.plotAnimate(R, app);
	}
	
	// plotting the values of RectangleMatrix in the background area 40 X 40
	public static void plotAnimate(RectangleMatrix rm, PApplet app) {
		
		for (int i =0 ; i<row; i++) {
			
			float transY= Pattern1.ELEMENT_POS_Y + i * Pattern1.BOX_BASE_AREA_SIZE;
			
			for(int j =0 ; j<col; j++) {
				
				float transX = Pattern1.ELEMENT_POS_X + j * Pattern1.BOX_BASE_AREA_SIZE;
				
				boolean v = rm.getVal(i, j);
				
				if(v==true) {
					
					app.fill(COLOR_MAX);
					app.push();
					app.translate(transX, transY);
					app.box(Pattern1.BOX_BASE_AREA_SIZE);
					app.pop();
					
				}
								
				else {
					
					app.fill(Pattern1.COLOR_MIN, Pattern1.COLOR_BRIGHTNESS, Pattern1.COLOR_SATURATION);
					app.push();
					app.translate(transX, transY);
					app.box(Pattern1.BOX_BASE_AREA_SIZE);
					app.pop();
					
				}
				
			}
			
		}
			
	}
	
	
	
}
