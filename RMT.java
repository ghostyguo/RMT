import java.text.*;
import java.util.*;
import java.io.*;

public class RMT
{
	public static void main(String[] args) 
	{
		while (true) {
			try {
				downloadThread thread = new downloadThread();
				thread.start();				
				Thread.sleep(2000);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
}

class downloadThread extends Thread{
	public void run(){
		downloadRMT();
	}   
	
	void downloadRMT()
	{
		Date now = new java.util.Date(); 
		String dirTodayName = new SimpleDateFormat("yyyyMMdd").format(now);
		String dirHourName  = new SimpleDateFormat("HH").format(now);
		String filename = new SimpleDateFormat("yyyyMMdd-HHmmss").format(now) + ".png";		
		String filepath =  dirTodayName + "/" + dirHourName + "/" + filename; 
		
		File dirToday = new File(dirTodayName);
        if (!dirToday.exists()) {
            boolean success = dirToday.mkdir();
            if (success) {
                System.out.printf("Successfully created new directory : %s%n", dirTodayName);
            } else {
                System.out.printf("Failed to create new directory: %s%n", dirTodayName);
            }
        }
		
		File dirHour = new File(dirTodayName + "/" + dirHourName);
        if (!dirHour.exists()) {
            boolean success = dirHour.mkdir();
            if (success) {
                System.out.printf("Successfully created new directory : %s%n", dirHourName);
            } else {
                System.out.printf("Failed to create new directory: %s%n", dirHourName);
            }
        }
		
		try {            
            Runtime rt = Runtime.getRuntime ();
			String command = "wget http://rmt.earth.sinica.edu.tw/rmt.png -O " + filepath;
			System.out.println (command);
            Process proc = rt.exec (command);
			
			/*			
            String line = null;
 
            InputStream stderr = proc.getErrorStream ();
            InputStreamReader esr = new InputStreamReader (stderr);
            BufferedReader ebr = new BufferedReader (esr);
            System.out.println ("<error>");
            while ( (line = ebr.readLine ()) != null)
                System.out.println(line);
            System.out.println ("</error>");
             
            InputStream stdout = proc.getInputStream ();
            InputStreamReader osr = new InputStreamReader (stdout);
            BufferedReader obr = new BufferedReader (osr);
            System.out.println ("<output>");
            while ( (line = obr.readLine ()) != null)
                System.out.println(line);
            System.out.println ("</output>");
			*/
			
            int exitCode = proc.waitFor ();
			if (exitCode==0) {
				//System.out.println ("OK");
			} else {
				System.out.println ("Fail : Code = " + exitCode);
			}
			
        } catch (Exception e) {
            e.printStackTrace();
        }		
	}
}