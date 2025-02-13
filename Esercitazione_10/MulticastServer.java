import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastServer {

    public static void main(String[] args) {

        byte[] buf = new byte[256];
        String dString = new Date().toString();
        buf = dString.getBytes();
        MulticastSocket socket = null;

        try {
             socket = new MulticastSocket();
             socket.setTimeToLive(0);
             InetAddress group = InetAddress.getByName("230.0.0.1");
             DatagramPacket packet;
             packet = new DatagramPacket(buf, buf.length, group, 4446);
             socket.send(packet);
        } catch (IOException e) {
             e.printStackTrace();
        } finally {
             socket.close();
        }
    }
}