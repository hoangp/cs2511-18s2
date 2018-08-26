package tut06.designbycontract;

import java.time.LocalDate;

/**
 * Simple program to test design by contract.
 * @invariant balance >= 0
 */
public class InternetAccount extends BankAccount {
  private static final int MONTHLY_LIMIT = 10;
  private int numPayments;
  private LocalDate lastPaymentDate;

  /**
   * Initialize bank account with zero balance.
   * @param balance the opening balance
   */
  public InternetAccount(int balance) {
    super(balance);
    this.numPayments = 0;
  }

  /**
   * Deduct amount from balance, but only if not at maximum number of payments.
   * @precondition amount >= 0
   */
  public boolean makePayment(int amount) {
    LocalDate today = LocalDate.now();
    // if last Internet payment was not in this month, reset the day
    if (lastPaymentDate == null || !sameMonth(lastPaymentDate, today)) {
      lastPaymentDate = today;
      numPayments = 0;
    }

    // tests funds available and not over daily limit
    if (numPayments < MONTHLY_LIMIT) {
      if (withdraw(amount)) {
        numPayments++;
        return true;
      } else return false;
    } else return false;
  }

  /**
   * Standard equals method for Calendar months.
   */
  private boolean sameMonth(LocalDate day, LocalDate other) {
    return (day.getDayOfMonth() == other.getDayOfMonth() && day.getYear() == other.getYear());
  }

}
