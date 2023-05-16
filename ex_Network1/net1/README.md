In this exercise, you will implement a web-server that can understand a limited subset of the protocol. Namely, you will accept GET request to serve a simple html or text page.
First, you need to complete the method start of the class SimpleHTTPServer. This method should create a ServerSocket and wait for client to connect. Once you have a connection, pass the corresponding Socket instance to an instance of Handler and call its start method.

The method start of Handler needs to be completed as follows: first, you need to obtain an InputStream from the socket and use it to read information from the client. It is sufficient to get the first line from the stream. Then you have to tokenize this line. You can do it with the String method split, and splits the request string by whitespaces. The first request line should look like:

GET /filename.html HTTP/1.1

You need to start by comparing the first token with GET. If it is different, you can ignore the request. Otherwise, you can get the name of the file to serve from the second token (after removing "/"). You need to open this file, read it all in memory, and send it to the client with an OutputStream. Before sending the file content, you need to prepend an HTTP header that contains information on the content length, the encoding, etc. You can use the code below as a template:

File file; // to be initialized somewhere with the obtained filename
byte[] content;
content = Files.readAllBytes(file.toPath());

String headerStr = "HTTP/1.0 200 OK\r\n"
+ "Server: SimpleHTTPServer\r\n"
+ "Content-length: " + content.length + "\r\n"
+ "Content-type: text/html"
+ "; charset=utf-8" + "\r\n\r\n";
byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));

// send the header then the content as byte[] via the OutputStream
Before reading the content of the file, it is better of course to check that the file exists. Otherwise, you should send the header, followed by an html page with the infamous 404 (File Not Found) code.
To run the server (after you completed the code), type:

java SimpleHTTPServer

then start your browser (firefox for example) and make it points to the URL: localhost:8080 (make sure that you have copied the file index.html in the same directory as the server).

As an exercise, you can create additional HTML pages, save them in the same directory as the server. You can access them by making your browser points to: localhost:8080/myfile.html, where myfile.html is your test HTML page.
