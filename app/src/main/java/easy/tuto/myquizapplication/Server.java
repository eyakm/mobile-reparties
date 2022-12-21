package easy.tuto.myquizapplication;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.net.Socket;
import java.util.ArrayList;
public class Server {
	
	ArrayList <String> list;
	//static int i;
	

	public static void main(String[] args) {
		// TODO Auto-generated method 
		try
		{int nb=0;
			ServerSocket socketServeur = new ServerSocket(4);
			System.out.println("Server waiting ...");
			while(true){
				Socket socket = socketServeur.accept();
				InputStream is = socket.getInputStream();
					InputStreamReader isr=new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					String s= br.readLine();
					ArrayList<String> list = new ArrayList<String>();
					list.add("google");
					list.add("notepad");
					list.add("youtube");
					list.add("apple");
					list.add("university");
						try {
							switch (s) {
							case "google":{ s="google";break;}
							case "notepad":{s="notepad";break;}
							case "youtube":{ s="youtube";break;}
							case "apple": {s="apple";break;}
							case "university": {s="university";break;}
							default :{s="false answer";}
							}
							//for (i=0;i<=list.size();i++) {
							//	if(s.equals(list[i].toString( ))
								//	s=list.get(i);
							//}
							//public Object get( int index );
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					
					
					//list.add("google");
					//s=s.toUpperCase();  
					 
			/*	int result =0;
				switch (s[1]) {
				case "+":{ result=Integer.parseInt(s[0])+Integer.parseInt(s[2]);break;}
				case "*":{ result=Integer.parseInt(s[0])*Integer.parseInt(s[2]);break;}
				case "/":{ result=Integer.parseInt(s[0])/Integer.parseInt(s[2]);break;}
				case "-": {result=Integer.parseInt(s[0])-Integer.parseInt(s[2]);break;}
				default :{System.out.println("c'est pas une equation");}
				}*/	
					

					++nb;
				System.out.println("client connected "+nb);
				System.out.println("resultat = "+s);
					OutputStream os=socket.getOutputStream();
					PrintWriter pw=new PrintWriter(os,true);
					//s.toUpperCase();
					pw.println(s);
							socket.close();
							}	
		}
	catch(Exception ex) {
		System.out.println(ex.getMessage());
	}

	}
	

}