import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ip {
    public static void main(String [] args){
        InetAddress ip;
        try{
            //For ip Address
            ip = InetAddress.getLocalHost();
            System.out.println("Current Ip Address : " + ip.getHostAddress());

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte [] mac = network.getHardwareAddress();
            System.out.println("Current MAC Address : ");

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < mac.length; i++){
                stringBuilder.append(String.format("%02X%s", mac[i],(i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(stringBuilder.toString());

        }catch (UnknownHostException e){
            e.printStackTrace();
      }catch (SocketException e){
            e.printStackTrace();
       }
    }
}
