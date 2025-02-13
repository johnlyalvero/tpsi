import java.net.*;
import java.io.*;

public class MulticastClient {
	
    public static void main(String[] args) throws IOException {
		
        MulticastSocket socket = null;
        byte[] buf = new byte[256];
        socket = new MulticastSocket(4446);
        InetAddress group = InetAddress.getByName("230.0.0.1");
        socket.joinGroup(group);
        DatagramPacket packet;
        for(int i = 0; i < 5; i++) {
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(packet.getData());
            System.out.println("Received " + received);
        }
        socket.leaveGroup(group);
        socket.close();
    }
}