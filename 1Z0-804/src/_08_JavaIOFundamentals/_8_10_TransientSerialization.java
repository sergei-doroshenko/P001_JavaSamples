package _08_JavaIOFundamentals;

import java.io.*;
class _8_10_TransientSerialization {
	public static void main(String []args) {
		_8_10_USPresident a810UsPresident = new _8_10_USPresident("Barack Obama", "2009 to --", "56th term");
		System.out.println(a810UsPresident);
		
		//Serialize the object
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("USPresident.data"));
			oos.writeObject(a810UsPresident);
			oos.close();

			a810UsPresident.setPeriod("2009 to 2016");

			oos = new ObjectOutputStream(new FileOutputStream("USPresident.data"));
			oos.writeObject(a810UsPresident);

		}
		catch(FileNotFoundException fnfe) {
			System.err.println("cannot create a file with the given file name ");
		} catch(IOException ioe) {
			System.err.println("an I/O error occurred while processing the file");
		} // the ObjectOutputStream will auto-close, so don't have to worry about it 
		finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


		/*try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("_8_10_USPresident.data"))){
			oos.writeObject(a810UsPresident);
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("cannot create a file with the given file name ");
		} catch(IOException ioe) {
			System.err.println("an I/O error occurred while processing the file");
		}*/ // the ObjectOutputStream will auto-close, so don't have to worry about it

		//De-serialize the object
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("USPresident.data"))){
			Object obj = ois.readObject();
			if(obj != null && obj instanceof _8_10_USPresident){
				_8_10_USPresident presidentOfUS = (_8_10_USPresident)obj;
				System.out.println(presidentOfUS);
			}
		}catch(FileNotFoundException fnfe) {
			System.err.println("cannot create a file with the given file name ");
		} catch(IOException ioe) {
			System.err.println("an I/O error occurred while processing the file");
		} catch(ClassNotFoundException cnfe) {
			System.err.println("cannot recognize the class of the object - is the file corrupted?");
		}
	}
}
