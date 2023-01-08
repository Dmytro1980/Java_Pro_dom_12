package package0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList<T> {

    private List<T> list = new ArrayList<>();
    private ReentrantLock locker = new ReentrantLock();

    public void add(T varToAdd) {
        locker.lock();
        try {
            // temp print
            System.out.println("thread " + Thread.currentThread().getName() + " locked for add");
            list.add(varToAdd);
        } finally {
            locker.unlock();
            // temp print
            System.out.println("thread " + Thread.currentThread().getName() + " unlocked for add");
        }
    }

    public T get(int i) {
        locker.lock();
        try {
            // temp print
            System.out.println("thread " + Thread.currentThread().getName() + " locked for get");
            return list.get(i);
        } finally {
            locker.unlock();
            // temp print
            System.out.println("thread " + Thread.currentThread().getName() + " unlocked for get");
        }
    }

    public void remove(int i) {
        locker.lock();
        try {
            // temp print
            System.out.println("thread " + Thread.currentThread().getName() + " locked for delete");
            list.remove(i);
        } finally {
            locker.unlock();
            // temp print
            System.out.println("thread " + Thread.currentThread().getName() + " unlocked for delete");
        }
    }
}

