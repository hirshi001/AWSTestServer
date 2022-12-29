package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // http://myjavaserver-env.eba-yaemhmi2.us-east-1.elasticbeanstalk.com/
        Socket socket = new Socket("arn:aws:elasticbeanstalk:us-east-1:397919555386:application/MyJavaServer", 40315);
        System.out.println("Connected");
        DataInputStream in = new DataInputStream(socket.getInputStream());
        String message = in.readUTF();
        System.out.println(message);
        socket.close();
    }
}
