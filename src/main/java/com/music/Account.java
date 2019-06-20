package com.music;

class Account {
    private int balance;

    void transfer(Account target, int money) {
        synchronized (Account.class) {
            if (this.balance > money) {
                this.balance -= money;
                target.balance += money;
            }
        }
    }
}
