package lab12;

import java.util.Random;

public class ProdConSelfTest {
    private Buffer buffer;
    private Producer producer;
    private Consumer consumer;

    public ProdConSelfTest() {
        buffer = new Buffer(15);
        producer = new Producer(buffer);
        consumer = new Consumer(buffer);
    }

    private class Producer extends Thread {
        private final Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        public void produce() throws InterruptedException {
            Random rand = new Random();
            for (int i = 0; i < buffer.getSize(); i++) {
                double randNum = (rand.nextDouble() * 100.0);
                this.buffer.add(randNum);
            }
        }

        public void run() {
            try {
                this.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Consumer extends Thread {
        private final Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        public void consume() throws InterruptedException {
            for (int i = 0; i < buffer.getSize(); i++) {
                this.buffer.remove();
            }
        }

        public void run() {
            try {
                this.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void startThread() {
        this.producer.start();
        this.consumer.start();
    }
}
