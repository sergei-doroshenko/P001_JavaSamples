package _04_AdvancedClassDesign;

// define an enum for classifying printer types
enum PrinterType {
	DOTMATRIX, INKJET, LASER;

	private String printPageCapacity;

	public String getPrintPageCapacity() {
		return printPageCapacity;
	}
}

// test the enum now 
public class _4_9_EnumTest {
	PrinterType printerType;

	public _4_9_EnumTest(PrinterType pType) {
		printerType = pType;
	}
	
	public void feature() {
		// switch based on the printer type passed in the constructor 
		switch(printerType){
		case DOTMATRIX:
			System.out.println("Dot-matrix printers are economical and almost obsolete");
			break;
		case INKJET:
			System.out.println("Inkjet printers provide decent quality prints");
			break;
		case LASER:
			System.out.println("Laser printers provide best quality prints");
			break;
		}
	}

	public static void main(String[] args) {
		_4_9_EnumTest enumTest = new _4_9_EnumTest(PrinterType.LASER);
		enumTest.feature();
	}
}
