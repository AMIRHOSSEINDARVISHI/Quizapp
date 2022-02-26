package code.with.cal.quizapp.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import code.with.cal.quizapp.R
import code.with.cal.quizapp.data.Data
import code.with.cal.quizapp.data.StatusAnswer
import code.with.cal.quizapp.databinding.FragmentCheatBinding

class CheatFragment : Fragment(R.layout.fragment_cheat) {

    private lateinit var bindingCheat: FragmentCheatBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindingCheat = FragmentCheatBinding.bind(view)

        if (Data.cheats[Data.round]) {
            bindingCheat.textviewShowAnswer.text = if (Data.answers[Data.round]) {
                getString(R.string.text_toast_correct)
            } else {
                getString(R.string.text_toast_incorrect)
            }
            bindingCheat.buttonShowAnswer.setOnClickListener {
                Toast.makeText(activity, R.string.text_no_cheat, Toast.LENGTH_SHORT).show()
            }
        } else {
            bindingCheat.buttonShowAnswer.setOnClickListener {
                if (Data.isCompletes[Data.round] == StatusAnswer.None) {
                    bindingCheat.textviewShowAnswer.text = if (Data.answers[Data.round]) {
                        getString(R.string.text_toast_correct)
                    } else {
                        getString(R.string.text_toast_incorrect)
                    }
                    Data.cheats[Data.round] = true
                    Data.isCompletes[Data.round] = StatusAnswer.Cheat
                } else {
                    Toast.makeText(activity, R.string.text_no_cheat, Toast.LENGTH_SHORT).show()
                }
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }
}