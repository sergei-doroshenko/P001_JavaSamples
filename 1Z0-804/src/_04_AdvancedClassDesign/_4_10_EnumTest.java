package _04_AdvancedClassDesign;

public class _4_10_EnumTest {
	PrinterType printerType;

	public _4_10_EnumTest(PrinterType pType) {
		printerType = pType;
	}

	public void feature() {
		switch (printerType) {
		case DOTMATRIX:
			System.out.println("Dot-matrix printers are economical");
			break;
		case INKJET:
			System.out.println("Inkjet printers provide decent quality prints");
			break;
		case LASER:
			System.out.println("Laser printers provide the best quality prints");
			break;
		}
		System.out.println("Print page capacity per minute: " + 
			printerType.getPrintPageCapacity());
	}

	public static void main(String[] args) {
		_4_9_EnumTest enumTest1 = new _4_9_EnumTest(PrinterType.LASER);
		enumTest1.feature();
		_4_9_EnumTest enumTest2 = new _4_9_EnumTest(PrinterType.INKJET);
		enumTest2.feature();
	}
}
