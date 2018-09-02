package tut07.exceptions;

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
   * @throws LimitException
   * @throws InSufficientBalanceException
   * @precondition amount >= 0
   */
  public void withdraw(int amount) throws InSufficientBalanceException, LimitException {
    LocalDate today = LocalDate.now();
    // if last Internet payment was not in this month, reset the day
    if (lastPaymentDate == null || !sameMonth(lastPaymentDate, today)) {
      lastPaymentDate = today;
      numPayments = 0;
    }
    if (numPayments < MONTHLY_LIMIT) {

      // tests funds available and not over daily limit
      super.withdraw(amount);
      numPayments++;
    } else {
      throw new LimitException("You have exceeded your monthly withdrawal limit");
    }
  }

  /**
   * Standard equals method for Calendar months.
   */
  private boolean sameMonth(LocalDate day, LocalDate other) {
    return (day.getDayOfMonth() == other.getDayOfMonth() && day.getYear() == other.getYear());
  }

}
