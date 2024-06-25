package exercises.threads.buffer;


import java.util.LinkedList;

class MyBuffer {
    static final int MAXSIZE = 2;
    private LinkedList<Integer> values;
    private int size;

    public MyBuffer(int size) {
        values = new LinkedList<>();
        this.size = size;
    }

    public synchronized void put(int v) {
        if (values.size() >= size) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.values.add(v);
        this.notify();
        System.out.println("Put: " + v);
    }

    public synchronized int get() {
        int v;
        if (values.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        v = this.values.pop();
        this.notify();
        System.out.println("Get: " + v);
        return v;
    }

    public static void main(String[] args) {
        MyBuffer myBuffer = new MyBuffer(MAXSIZE);

        ProducerThread t1 = new ProducerThread(myBuffer);
        ConsumerThread t2 = new ConsumerThread(myBuffer);
        t1.start();
        t2.start();
    }
}
