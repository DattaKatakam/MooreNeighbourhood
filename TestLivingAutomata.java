package home2;

import peasy.*;
import processing.core.*;

public class TestLivingAutomata extends PApplet{
	
	
	
	public static void main(String[] arg) {
		
		PApplet.main(TestLivingAutomata.class);
		
	}
	
	PeasyCam cam;
	PApplet app;
	Pattern1 p1;
	Pattern2 p2;
	Pattern3 p3;
	
	
	public void settings() {
		size(500,500,P3D);
	}
	
	public void setup() {
		
		this.cam = new PeasyCam(this, 400);
		
		int evolv = 50;
		p1= new Pattern1();
		p1.animate(evolv, this);
		
		p2= new Pattern2();
		p2.animate(evolv, this);
				
		p3 = new Pattern3();
		p3.animate(evolv, this);
		
		
	}
	
	public void draw() {
		this.background(500);
		p1.plotAnimation(this);
		p2.plotAnimation(this);
		p3.plotAnimation(this);
	}
	
	
}
