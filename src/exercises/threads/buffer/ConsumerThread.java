package exercises.threads.buffer;

class ConsumerThread extends Thread {
    MyBuffer buffer;

    public ConsumerThread(MyBuffer b) {
        this.buffer = b;
    }

    public void run() {
        this.buffer.get();
        this.buffer.get();
        this.buffer.get();

    }
}
