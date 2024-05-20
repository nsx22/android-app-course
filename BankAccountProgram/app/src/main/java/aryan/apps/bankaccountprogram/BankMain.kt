package aryan.apps.bankaccountprogram

fun main() {

    val aBankAccount = BankAccount("Aryan Sharma", 4629.38)
    aBankAccount.deposit(200.0)
    aBankAccount.displayTransactionHistory()

    aBankAccount.withdraw(4829.0)
    aBankAccount.displayTransactionHistory()
    aBankAccount.acctBalance()

    val sarah = BankAccount("Sarah", 0.0)
    sarah.deposit(100.0)
    sarah.withdraw(10.0)
    sarah.deposit(300.0)
    sarah.acctBalance()
    sarah.displayTransactionHistory()
}
