package tron;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSend {
    public static void main(String[] args) throws Exception {

        String sendtext = "Message sent to be received";

        InetAddress address = InetAddress.getByName("228.5.6.7");
        MulticastSocket socket = new MulticastSocket(55555);

        InetAddress localIP = InetAddress.getLocalHost();

        socket.joinGroup(address);

        DatagramPacket packet = new DatagramPacket(sendtext.getBytes(), sendtext.length(), address, 55555);


        socket.send(packet);

        socket.leaveGroup(address);
        socket.close();



    }


}
