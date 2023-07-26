
public class InternetApplication {
    public static void main(String[] args) {
        Alice alice = new Alice();
        Bob bob = new Bob();

        // Alice creates packets periodically
        alice.createPacket("Hello Bob!");
        alice.createPacket("How are you?");
        alice.createPacket("Packet 1");
        alice.createPacket("Packet 2");

        // Bob periodically checks for packets from Alice
        bob.checkForPackets(alice);
    }
}

