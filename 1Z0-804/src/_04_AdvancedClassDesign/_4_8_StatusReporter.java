package _04_AdvancedClassDesign;

class _4_8_StatusReporter {
	static Shape.Color getDesciptiveColor(final Shape.Color color) {
		// note the use of anonymous inner classes here -- specifically, there is no name 
		// for the class and we construct and use the class "on the fly" in the return statement! 
		return new Shape.Color() {
			public String toString() {
				return "You selected a color with RGB values " + color; 
			}
		}; 
	}
	public static void main(String []args) {
		Shape.Color descriptiveColor = _4_8_StatusReporter.getDesciptiveColor(new Shape.Color(0, 0, 0));
		System.out.println(descriptiveColor);  	
	}
}
