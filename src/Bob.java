
import java.util.Timer;
import java.util.TimerTask;
class Bob {
    public void receivePacket(Packet packet) {
        if (packet != null) {
            String data = packet.getData();
            System.out.println("Bob: Received packet with data - " + data);
        } else {
            System.out.println("Bob: No packets to receive.");
        }
    }

    public void checkForPackets(Alice alice) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (alice.hasPacketsToSend()) {
                    Packet packet = alice.getNextPacket();
                    receivePacket(packet);
                }
            }
        }, 0, 2000); // Check every 2 seconds
    }
}