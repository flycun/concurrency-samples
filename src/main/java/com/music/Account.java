package com.music;

import java.util.concurrent.locks.Lock;

class Account {
    private int balance;

    Lock lock;
    public boolean transfer(Account target, int amount) {
        while (true) {
            if (this.lock.tryLock()) {
                try {
                    if (target.lock.tryLock()) {
                        try {
                            if (this.balance > amount) {
                                this.balance -= amount;
                                target.balance += amount;
                                return true;
                            }
                        } finally {
                            target.lock.unlock();
                        }
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            // if(超时) return false;
        }
    }
}
