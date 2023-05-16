import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;


public class SimpleHTTPServer {

  private final int port;
  
  public SimpleHTTPServer(int port)
  {    
    this.port = port; 
  }

  public void start() {
    // Start a ServerSocker
    // wait for connection
    // then send the corresponding socket to an instance of Handler
    // and let it handle the request
    try{
      ServerSocket ss = new ServerSocket(port);
      while(true){
        Socket s = ss.accept();
        Handler hr = new Handler(s);
        hr.start();
        s.close();
      }
    }catch(Exception e){
      System.out.println("Exception" + e);
    }
  }

  public static void main(String[] args) {
    int port;
    try {
      port = Integer.parseInt(args[0]);
      if (port < 1024 || port > 65535) port = 8080;
    } catch (RuntimeException ex) {
      port = 8080;
    }
    // usage   local:8080/filename
    try {
      SimpleHTTPServer server = new SimpleHTTPServer(port);
      server.start();
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println("Usage: java SimpleHTTPServer [port]");
    }
  }
}

class Handler {
  private final Socket connection;

  Handler(Socket _connection) {
    this.connection = _connection;
  }

  public void start() {
    // Get InputStream and OutputStream from the socket.
    // 1. read the request from the client.
    // 2. if it is not starting by "GET" then ignore
    // 3. otherwise, extract the file name from the request.
    // It will look like: "GET /filename.html HTTP/1.1"
    // You can split the string by whitespaces.
    // 4. open the file and reads its content
    // 5. create an HTTP header
    // 6. send the header then the content via the OutputStream

      try{
        OutputStream out = new BufferedOutputStream(connection.getOutputStream());
        InputStream in = new BufferedInputStream(connection.getInputStream());

        StringBuilder request = new StringBuilder(80);
        while(true){
          int c = in.read();
          if(c == '\r' || c=='\n') break;
          request.append((char)c);
        }

        String requestStr = request.toString();
        System.out.println(requestStr);
        String[] tokens = requestStr.split("\\s+");
        if(tokens[0].equals("GET")){
          String fileName= tokens[1];
          //if(fileName.endsWith("/")) fileName = fileName + "index.html";
          System.out.println(fileName);
          File file = new File(fileName.substring(1)); // to be initialized somewhere with the obtained filename
          byte[] content;
          content = Files.readAllBytes(file.toPath());
     
          String headerStr = "HTTP/1.0 200 OK\r\n"
          + "Server: SimpleHTTPServer\r\n"
          + "Content-length: " + content.length + "\r\n"
          + "Content-type: text/html"
          + "; charset=utf-8" + "\r\n\r\n";
          byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));
          out.write(header);
          out.write(content);
          out.flush();
        }
        connection.close();
      }catch(Exception e){
        System.out.println("Exception" + e);
      }
      return;
  }
}



