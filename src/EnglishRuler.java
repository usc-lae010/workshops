public class EnglishRuler {

    public static void drawRuler(int inches, int majorLength) {
        drawLine(majorLength, 0); // Draw the first major tick at 0
        for (int i = 1; i <= inches; i++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, i);
        }
    }

    public static void drawInterval(int centralLength) {
        if (centralLength >= 1) {
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }

    public static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }

    public static void drawLine(int tickLength, int tickLabel) {
        for (int i = 0; i < tickLength; i++) {
            System.out.print("-");
        }
        if (tickLabel >= 0) {
            System.out.print(" " + tickLabel);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int inches = 2; // Length of the ruler in inches
        int majorLength = 4; // Length of major ticks
        drawRuler(inches, majorLength);
    }
}
