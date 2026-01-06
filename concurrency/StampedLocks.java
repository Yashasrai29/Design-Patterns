package concurrency;

import java.security.spec.ECField;
import java.util.concurrent.locks.StampedLock;

public class StampedLocks {

    public static class Locks {

        private StampedLock lock;

        private int data;

        public Locks() {
            this.lock = new StampedLock();
        }

        public synchronized void write(int val) {
            long stamp = 0L;
            try {
                stamp = lock.writeLock();
                this.data = val;
                Thread.sleep(7000);
            } catch (Exception e) {

            } finally {
                if (stamp != 0L) {
                    lock.unlockWrite(stamp);
                }
            }
        }

        public synchronized int read() {
            long stamp = 0L;
            try {
                stamp = lock.tryOptimisticRead();
                while (!lock.validate(stamp)) {
                    stamp = lock.readLock();
                }
                int result = data;
                stamp = 0L;
                return result;
            } catch (Exception e) {

            } finally {
                if (stamp != 0L) {
                    lock.unlockRead(stamp);
                }
            }
            return 0;
        }

        public synchronized int writeAndRead(int val){
            long stamp = 0L;
            try {
                stamp = lock.writeLock();
                this.data = val;
                Thread.sleep(7000);
                stamp = lock.tryConvertToReadLock(stamp);
                while(!lock.validate(stamp)){
                    stamp = lock.readLock();
                }
                Thread.sleep(2000);
                int result = data;
                return result;
            } catch (Exception e) {

            } finally {
                if (stamp != 0L && lock.validate(stamp)) {
                    lock.unlock(stamp);
                }
            }
            return 0;
        }

    }
    public static void main(String [] args){
        Locks locks = new Locks();


        new Thread(() ->{
            int res = locks.read();
            System.out.println("res "+res);
        }).start();

        new Thread(() ->{
            locks.write(10);
        }).start();

        new Thread(() ->{
            int res = locks.read();
            System.out.println("res "+res);
        }).start();

        new Thread(() ->{
            int res = locks.read();
            System.out.println("res 2 "+res);
        }).start();

        new Thread(() ->{
            int res = locks.read();
            System.out.println("res 2 "+res);
        }).start();


        new Thread(() ->{
            int res = locks.writeAndRead(29);
            System.out.println("res 2 "+res);
        }).start();

        new Thread(() ->{
            try {
                Thread.sleep(11000);
                locks.write(100);
            }catch (Exception e){

            }
        }).run();
    }



}
