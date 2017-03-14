package pers.hy.socket_test.talk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {
	public static void main(String[] args){
		try{	
			ServerSocket server=new ServerSocket(5327);
			Socket socket=server.accept();
			
			BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os=new PrintWriter(socket.getOutputStream());
			System.out.println("Client:"+is.readLine());
			
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			String line=sin.readLine();
			
			while(!line.equals("stop")){
				
				os.println(line);
				os.flush();
				System.out.println("Client:"+is.readLine());
				line=sin.readLine();
				
				}
			
			os.close();
			is.close();
			socket.close();
			server.close();
			
		}catch(Exception e){
			
		}
	}

}
