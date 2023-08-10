package richard.backend.restapi;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;

public class Lib {
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void deleteFolder(File file) {
		if(file.isDirectory()){
			File[] listfile = file.listFiles();
			for(File f:listfile)
				deleteFolder(f);
		}
		file.delete();
	}
	
	
	public static final String getStringException(Exception e) {
		String s = e.toString();
		StackTraceElement[] list = e.getStackTrace();
		if(list!=null)
			for(StackTraceElement st : list)
				s=s+"\n"+st;
		return s;
	}
	
	public static final String getMemory(long l) {
		if(l<1024)
			return l+" b";
		if(l<1024*1024) {
			return new DecimalFormat("#.##").format(((double)l)/1024)+" K("+l+")";
		}
		if(l<1024*1024*1024) {
			return new DecimalFormat("#.##").format(((double)l)/(1024*1024))+" M("+l+")";
		}
		return new DecimalFormat("#.##").format(((double)l)/(1024*1024*1024))+" G("+l+")";
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static final void traceIpAdress() {
		new Thread(new Runnable() {
			public void run() {
				ArrayList<String> listIp=getIp();
				for(String s:listIp)
					System.out.println(s);
			}
		}).start();
	}
	public static final ArrayList<String> getIp() {
		ArrayList<String> listIp=new ArrayList<String>();
		String s;
		try {
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			while(e.hasMoreElements()){
			    NetworkInterface n = (NetworkInterface) e.nextElement();
			    Enumeration<InetAddress> ee = n.getInetAddresses();
			    while (ee.hasMoreElements()) {
			    	s=ee.nextElement().getHostAddress();
			    	if(s!=null && s.equals("127.0.0.1")==false && s.startsWith("fe80:0:0:0")==false && s.startsWith("0:0:0:0:0:0")==false)
			    		listIp.add(s);
			    }
			}
			return listIp;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return listIp;
	}
	
	
}
