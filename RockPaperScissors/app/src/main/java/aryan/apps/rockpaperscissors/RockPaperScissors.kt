package aryan.apps.rockpaperscissors

fun main() {
    var computerChoice = ""
    println("Rock, Paper, or Scissors? Enter your choice!")
    var playerChoice = readln()

    val randomNumber = (1..3).random()

    when (randomNumber) {
        1 -> {
            computerChoice = "Rock"
        }

        2 -> {
            computerChoice = "Paper"
        }

        3 -> {
            computerChoice = "Scissors"
        }
    }
    while (playerChoice != "rock" && playerChoice != "paper" && playerChoice != "scissors")
    {
        println("That's not a valid choice. Try again!")
        playerChoice = readln()
    }
    println("The computer chose: $computerChoice")
    val winner = when {
        playerChoice.lowercase() == computerChoice.lowercase() -> "tie"
        playerChoice.lowercase() == "rock" && computerChoice.lowercase() == "scissors" -> "player"
        playerChoice.lowercase() == "paper" && computerChoice.lowercase() == "rock" -> "player"
        playerChoice.lowercase() == "scissors" && computerChoice.lowercase() == "paper" -> "player"
        else -> "computer"
    }

    when (winner) {
        "tie" -> println("It's a tie...")
        "player" -> println("You won!")
        "computer" -> println("You lost!")
    }


}