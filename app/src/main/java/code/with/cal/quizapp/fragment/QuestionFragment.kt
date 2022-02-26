package code.with.cal.quizapp.fragment



import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import code.with.cal.quizapp.R
import code.with.cal.quizapp.data.Data
import code.with.cal.quizapp.data.Question
import code.with.cal.quizapp.data.StatusAnswer
import code.with.cal.quizapp.databinding.FragmentQuestionBinding


class QuestionFragment : Fragment() {

    private lateinit var bindingQuestion: FragmentQuestionBinding
    private lateinit var question: Question

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindingQuestion = FragmentQuestionBinding.bind(view)

        question = Question(
            Data.question[Data.round][0],
            Data.question[Data.round][1]
        )

        showQuestion()

        buttonPrevDisable()


        bindingQuestion.buttonCheat.setOnClickListener {
            val actionToCheat = QuestionFragmentDirections.actionQuestionFragmentToCheatFragment()
            view.findNavController().navigate(actionToCheat)
        }

        bindingQuestion.buttonPrev.setOnClickListener {
            questionPrev()
        }

        bindingQuestion.buttonNext.setOnClickListener {
            questionNext()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun buttonIsTrue() {
        if (Data.isCompletes[Data.round] == StatusAnswer.Cheat) {
            Toast.makeText(activity, R.string.text_toast_cheat, Toast.LENGTH_SHORT).show()
        } else {
            if (getAnswer()) {
                Toast.makeText(activity, R.string.text_toast_correct, Toast.LENGTH_SHORT).show()
                Data.isCompletes[Data.round] = StatusAnswer.Correct
            } else {
                Toast.makeText(activity, R.string.text_toast_incorrect, Toast.LENGTH_SHORT)
                    .show()
                Data.isCompletes[Data.round] = StatusAnswer.Incorrect
            }
            buttonIsEnable(false)
        }
    }

    private fun buttonIsFalse() {
        if (Data.isCompletes[Data.round] == StatusAnswer.Cheat) {
            Toast.makeText(activity, R.string.text_toast_cheat, Toast.LENGTH_SHORT).show()
        } else {
            if (!getAnswer()) {
                Toast.makeText(activity, R.string.text_toast_correct, Toast.LENGTH_SHORT).show()
                Data.isCompletes[Data.round] = StatusAnswer.Correct
            } else {
                Toast.makeText(activity, R.string.text_toast_incorrect, Toast.LENGTH_SHORT)
                    .show()
                Data.isCompletes[Data.round] = StatusAnswer.Incorrect
            }
            buttonIsEnable(false)
        }

    }

    private fun buttonPrevDisable() {
        if (Data.round == 0) {
            bindingQuestion.buttonPrev.isEnabled = false
        }
    }

    private fun showQuestion() {
        bindingQuestion.textviewQuiz.text = getQuestion()
        setAnswer()
    }

    private fun buttonIsEnable(status: Boolean) {
        bindingQuestion.buttonTrue.isEnabled = status
        bindingQuestion.buttonFalse.isEnabled = status
    }

    private fun setAnswer() {
        if (Data.isCompletes[Data.round] == StatusAnswer.None || Data.isCompletes[Data.round] == StatusAnswer.Cheat) {
            buttonIsEnable(true)
        } else {
            buttonIsEnable(false)
        }

        bindingQuestion.buttonTrue.setOnClickListener {
            buttonIsTrue()
        }
        bindingQuestion.buttonFalse.setOnClickListener {
            buttonIsFalse()
        }
    }

    private fun getAnswer(): Boolean {
        return question.answer.toBoolean()
    }

    private fun getQuestion(): String {
        return question.quest
    }

    private fun questionNext() {
        bindingQuestion.buttonPrev.isEnabled = true

        Data.round += 1

        if (Data.round >= 9) {
            Data.round = 9
            bindingQuestion.buttonNext.isEnabled = false
        }

        question = Question(
            Data.question[Data.round][0],
            Data.question[Data.round][1]
        )

        showQuestion()
    }

    private fun questionPrev() {
        bindingQuestion.buttonNext.isEnabled = true

        Data.round -= 1

        if (Data.round <= 0) {
            Data.round = 0
            bindingQuestion.buttonPrev.isEnabled = false
        }

        question = Question(
            Data.question[Data.round][0],
            Data.question[Data.round][1]
        )

        showQuestion()
    }

}