package tron;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastRead {
    public static void main(String[] args) throws Exception {

        InetAddress address = InetAddress.getByName("228.5.6.7");
        MulticastSocket socket = new MulticastSocket(55555);

        socket.joinGroup(address);

        byte[] messageBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(messageBuffer, 1024);

        //Statement that waits until something is sent...
        socket.receive(receivePacket);

        String recievetext = new String(messageBuffer);

        System.out.println(recievetext);



        socket.close();
        socket.leaveGroup(address);

    }


}
