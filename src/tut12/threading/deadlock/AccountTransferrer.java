package tut12.threading.deadlock;

/**
 * Thread which performs account transfers.
 */
public class AccountTransferrer implements Runnable {
  private Account from;
  private Account to;
  private String name; // for demonstration

  public AccountTransferrer(Account from, Account to, String name) {
    this.from = from;
    this.to = to;
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      from.transfer(to, 1);
      System.out.println(name + " " + i);
    }
  }
}
