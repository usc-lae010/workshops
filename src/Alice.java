import java.util.ArrayList;
import java.util.List;

public class Alice {
    private List<Packet> packets;

    public Alice() {
        packets = new ArrayList<>();
    }

    public void createPacket(String data) {
        Packet packet = new Packet(data);
        packets.add(packet);
        System.out.println("Alice: Created packet with data - " + data);
    }

    public boolean hasPacketsToSend() {
        return !packets.isEmpty();
    }

    public Packet getNextPacket() {
        if (!packets.isEmpty()) {
            return packets.remove(0);
        }
        return null;
    }
}

