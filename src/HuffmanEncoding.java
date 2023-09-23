import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = right = null;
    }

    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

public class HuffmanEncoding {
    public static void encodeHuffman(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode parent = new HuffmanNode('-', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;

            priorityQueue.add(parent);
        }

        HuffmanNode root = priorityQueue.poll();
        printHuffmanCodes(root, "");
    }

    public static void printHuffmanCodes(HuffmanNode root, String code) {
        if (root == null) return;

        if (root.data != '-') {
            System.out.println(root.data + ": " + code);
        }

        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        String text = "this is an example for huffman encoding";
        System.out.println("Huffman Codes:");
        encodeHuffman(text);
    }
}
