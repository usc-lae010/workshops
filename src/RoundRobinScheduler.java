public class RoundRobinScheduler {
    public static void main(String[] args) {
        CircularLinkedList processQueue = new CircularLinkedList();

        // Adding processes to the circular linked list
        processQueue.addProcess(1, 5);
        processQueue.addProcess(2, 3);
        processQueue.addProcess(3, 7);

        // Simulating round-robin scheduling
        while (!processQueue.isEmpty()) {
            Process currentProcess = processQueue.getNextProcess();
            if (currentProcess != null) {
                System.out.println("Executing process " + currentProcess.id + " with burst time " + currentProcess.burstTime);

                // Simulating process execution
                try {
                    Thread.sleep(currentProcess.burstTime * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
