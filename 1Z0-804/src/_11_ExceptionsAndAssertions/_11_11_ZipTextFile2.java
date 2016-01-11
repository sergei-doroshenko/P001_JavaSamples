package _11_ExceptionsAndAssertions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// class ZipTextFile takes the name of a text file as input and creates a zip file 
// after compressing that text file. 

class _11_11_ZipTextFile2 {
	public static final int CHUNK = 1024; // to help copy chunks of 1KB 
	public static void main(String []args) {
		if(args.length == 0) {
			System.out.println("Pass the name of the file in the current directory to be zipped as an argument");
			System.exit(-1); 
		}
		
		String fileName = args[0]; 
		// name of the zip file is the input file name with the suffix ".zip" 
		String zipFileName = fileName + ".zip";

		ByteBuffer buf = ByteBuffer.allocate(CHUNK);
		// these constructors can throw FileNotFoundException
		try (
			FileChannel inChannel = new FileInputStream(fileName).getChannel();
			ZipOutputStream zipFile = new ZipOutputStream(new FileOutputStream(zipFileName));
			WritableByteChannel outChanel = Channels.newChannel(zipFile)
		) {
			// putNextEntry can throw IOException
			zipFile.putNextEntry(new ZipEntry(fileName));

			// successfully read
			// copy the contents of the input file into the zip file 
			while(inChannel.read(buf) > 0) {
				System.out.println("Read: " + buf.limit());
				buf.flip();
				// both read and write methods can throw IOException
				outChanel.write(buf);
				buf.clear();
				System.out.println("cleared");
			}
			// the streams and channels will be closed automatically because they are
			// within try-with-resources statement
		}
		// this can result in multiple exceptions thrown from the try block; 
		// use "suppressed exceptions" to get the exceptions that were suppressed!
		catch(Exception e) {
			System.out.println("The caught exception is: " + e);
			System.out.print("The suppressed exceptions are: ");  
			for(Throwable suppressed : e.getSuppressed()) {
				System.out.println(suppressed); 
			}
		}
	}
}
