package com.music;

class Account {
    private int balance;

    void transfer(Account target, int money) {
        synchronized (this) { //锁定转出账户
            synchronized (target){//锁定转入账户
                if (this.balance > money) {
                    this.balance -= money;
                    target.balance += money;
                }
            }
        }
    }
}
