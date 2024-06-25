package exercises.threads.buffer;

class ProducerThread extends Thread {
    MyBuffer buf;
    public ProducerThread(MyBuffer b) {
        this.buf = b;
    }
    public void run() {
        this.buf.put(5);
        this.buf.put(6);
        this.buf.put(7);
        this.buf.put(8);
        this.buf.put(9);
        this.buf.put(10);
        this.buf.put(11);
    }
}