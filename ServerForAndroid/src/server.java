import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;

import org.omg.CORBA.Any;
import org.omg.CORBA.AnySeqHolder;
import org.omg.CORBA.BooleanSeqHolder;
import org.omg.CORBA.CharSeqHolder;
import org.omg.CORBA.DataInputStream;
import org.omg.CORBA.DoubleSeqHolder;
import org.omg.CORBA.FloatSeqHolder;
import org.omg.CORBA.LongLongSeqHolder;
import org.omg.CORBA.LongSeqHolder;
import org.omg.CORBA.OctetSeqHolder;
import org.omg.CORBA.ShortSeqHolder;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.ULongLongSeqHolder;
import org.omg.CORBA.ULongSeqHolder;
import org.omg.CORBA.UShortSeqHolder;
import org.omg.CORBA.WCharSeqHolder;

public class server {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
Thread t=new Thread(new Runnable() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try{
		
			ServerSocket ss=new ServerSocket(500);
			System.out.println("Running....");
			while(true){
				
				Socket s=ss.accept();
				System.out.println("accepted connection");
				java.io.DataInputStream dIs= new java.io.DataInputStream(s.getInputStream());
				String h=dIs.readUTF();
				System.out.println(h);
				/*BufferedImage image;
				try {
					image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
					ImageIO.write(image, "png", new File("G:\\screenshot.png"));
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				PrintWriter writer = new PrintWriter("G:\\temp.bat", "UTF-8");
				writer.print(h);
				writer.close();
			
						try {
					Process p =  Runtime.getRuntime().exec("cmd /c G:\\temp.bat");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dIs.close();
				
			/*	FileInputStream fis=new FileInputStream("G:\\screenshot.png");
				byte[] buffer =new byte[fis.available()];
				fis.read(buffer);
				
				ObjectOutputStream objectOutputStream =new ObjectOutputStream(s.getOutputStream());
				objectOutputStream.writeObject(buffer);
				objectOutputStream.close();*/
				s.close();
				System.out.println("closed connection");
			}}catch(IOException e){
				e.printStackTrace();
			}
	

}
});t.start();

	}	}
