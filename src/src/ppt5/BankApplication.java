package src.ppt5;

public class BankApplication {

	public static void main(String[] args) {
        Account account = new Account(1000);

        Thread thread1 = new TransactionThread(account);
        Thread thread2 = new TransactionThread(account);

        thread1.start();
        thread2.start();
    }

}

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " : 입금 완료. 잔액 = " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " : 출금 완료. 잔액 = " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " : 잔액 부족. 출금 불가.");
        }
    }
}

class TransactionThread extends Thread {
    private Account account;

    public TransactionThread(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            int randomAmount = (int) (Math.random() * 100) + 1;
            if (i % 2 == 0) {
                account.deposit(randomAmount);
            } else {
                account.withdraw(randomAmount);
            }
            try {
                Thread.sleep(100); // 잠시 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}