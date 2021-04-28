package money;

class Money implements Expression {
  protected int amount;
  protected String currency;

  Money times(int multiplier) {
    return new Money(amount * multiplier, currency);
  }

  Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount
      && currency().equals(money.currency());
  }

  public String toString() {
    return amount + " " + currency;
  }

  String currency() {
    return currency;
  }

  Expression plus(Money addend) {
    return new Sum(this, addend);
  }

  public Money reduce(String to) {
    return this;
  }

  static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  static Money franc(int amount) {
    return new Money(amount, "CHF");
  }
}
