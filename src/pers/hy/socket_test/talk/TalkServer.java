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
				
				os.println(line);    // 向客户端发送信息
				os.flush();          // 刷新，使客户端马上收到信息
				System.out.println("Client:"+is.readLine());    // 收到客户端传过来信息
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
