class Process {
    int id;
    int burstTime;
    Process next;

    public Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.next = null;
    }
}

class CircularLinkedList {
    private Process tail;

    public CircularLinkedList() {
        this.tail = null;
    }

    public void addProcess(int id, int burstTime) {
        Process newProcess = new Process(id, burstTime);

        if (tail == null) {
            tail = newProcess;
            tail.next = tail; // Make it circular
        } else {
            newProcess.next = tail.next;
            tail.next = newProcess;
            tail = newProcess;
        }
    }

    public Process getNextProcess() {
        if (tail == null) {
            return null;
        }

        Process nextProcess = tail.next;
        if (nextProcess == tail) {
            tail = null; // Last process in the list, reset tail to null
        } else {
            tail.next = nextProcess.next; // Remove the process from the list
        }
        return nextProcess;
    }

    public boolean isEmpty() {
        return tail == null;
    }
}

