package me.whiteship.chapter04.item17.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 12. CountDownLatch
 *      - 여러 스레드들의 작업이 다 끝날때까지 기다리거나,
 *      - 어떤 조건이 갖춰졌을 때 여러 스레드들을 실행하거나 등에서 유용하게 사용될 수 있다.
 *      - 재사용 가능하지 않다.
 *      - 가변 클래이지만 가질 수 있는 상태가 많지 않다.
 *      - 여러 스레드에서 값을 사용한다기보단 카운트를 세는 목적으로만 사용된다.
 *      - 가변 클래스지만 잘 사용된 예라고 할 수 있다.
 */
public class ConcurrentExample {
    public static void main(String[] args) throws InterruptedException {
        int N = 10;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

        ready();            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        doneSignal.await();           // wait for all to finish
        done();
    }

    private static void ready() {
        System.out.println("준비~~~");
    }

    private static void done() {
        System.out.println("끝!");
    }

    private static class Worker implements Runnable {

        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                startSignal.await(); // startSignal 의 count 가 0이 될 때까지 기다림
                doWork();
                doneSignal.countDown(); // count -1
            } catch (InterruptedException ex) {} // return;
        }

        void doWork() {
            System.out.println("working thread: " + Thread.currentThread().getName());
        }
    }
}
