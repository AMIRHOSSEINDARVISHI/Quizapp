package code.with.cal.quizapp.data


object Data {
    var round = 0

    val question = arrayOf(
        arrayOf("Quiz1", "true"),
        arrayOf("Quiz2", "false"),
        arrayOf("Quiz3", "true"),
        arrayOf("Quiz4", "false"),
        arrayOf("Quiz5", "true"),
        arrayOf("Quiz6", "false"),
        arrayOf("Quiz7", "true"),
        arrayOf("Quiz8", "false"),
        arrayOf("Quiz9", "true"),
        arrayOf("Quiz10", "false")
    )

    val questions = arrayOf(
        "Quiz1",
        "Quiz2",
        "Quiz3",
        "Quiz4",
        "Quiz5",
        "Quiz6",
        "Quiz7",
        "Quiz8",
        "Quiz9",
        "Quiz10"
    )

    val answers = arrayOf(
        false,
        true,
        false,
        true,
        false,
        true,
        false,
        true,
        false,
        true
    )

    val isCompletes = arrayOf(
        StatusAnswer.None,
        StatusAnswer.None,
        StatusAnswer.None,
        StatusAnswer.None,
        StatusAnswer.None,
        StatusAnswer.None,
        StatusAnswer.None,
        StatusAnswer.None,
        StatusAnswer.None,
        StatusAnswer.None
    )

    val cheats = arrayOf(
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false
    )
}