# Socket编程

·客户端

  java.net.Socket;
  java.io.*;
  
  Socket socket = new Socket("127.0.0.1",5327);    -> "127.0.0.1" = "localhost"

  BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStrea()));
  is.readLine();    -> 收到服务器传来信息

  PrintWriter os = new PrintWriter(socket.getOutputStream());
  os.println(String line);    -> 向服务器发送信息
  os.flush();                 -> 刷新，使服务器马上收到信息

  os.close();
  is.close();
  socket.close();
  


·服务器

  java.net.Socket;
  java.net.ServerSocket;
  java.io.*;
  
  ServerSocket server = new ServerSocket(5327);
  Socket socket = server.accept();  

  BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
  is.readLine();    -> 收到客户端传过来信息

  PrintWriter os=new PrintWriter(socket.getOutputStream());
  os.println(String line);    -> 向客户端发送信息
  os.flush;                   -> 刷新，使客户端马上收到信息

  os.close();
  is.close();
  socket.close();
  server.close();
