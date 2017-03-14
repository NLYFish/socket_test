package pers.hy.socket_test.talk;

import java.io.*;
import java.net.Socket;

public class TalkClient {
	public static void main(String[] args){
		try{
			Socket socket=new Socket("127.0.0.1",5327);    // "127.0.0.1" = "localhost"
			
			BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os=new PrintWriter(socket.getOutputStream());
			
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			String readline=sin.readLine();
			
			while(!readline.equals("stop")){
				
				os.println(readline);
				os.flush();
				System.out.println("Server:"+is.readLine());
				readline=sin.readLine();
				
				}
			
				os.close();
				is.close();
				socket.close();
			
		}catch(Exception e){
			
		}
		
	}

}
