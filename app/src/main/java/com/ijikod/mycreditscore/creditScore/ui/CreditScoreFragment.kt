package com.ijikod.mycreditscore.creditScore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.ijikod.mycreditscore.R
import com.ijikod.mycreditscore.databinding.FragmentCreditScoreBinding
import com.ijikod.mycreditscore.common.AutoCompositeDisposable
import com.ijikod.mycreditscore.common.addTo
import com.ijikod.mycreditscore.creditScore.CreditScoreViewModel
import com.ijikod.mycreditscore.creditScore.states.CreditScoreEvents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreditScoreFragment : Fragment() {

    private var _binding: FragmentCreditScoreBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val disposable: AutoCompositeDisposable by lazy { AutoCompositeDisposable(lifecycle) }
    private val viewModel: CreditScoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreditScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMyCreditScore()

        viewModel.events()
            .subscribe { event ->

                when (event) {

                    is CreditScoreEvents.Loading -> binding.loadingProgress.isVisible = true


                    is CreditScoreEvents.Error -> {
                        binding.loadingProgress.isVisible = false
                        binding.scoreDonutView.isVisible = false
                        binding.scoreHolder.isVisible = false
                        binding.errorView.isVisible = true
                        binding.errorTxt.text = event.error.message
                        binding.retryBtn.setOnClickListener {
                            viewModel.getMyCreditScore()
                        }
                    }

                    is CreditScoreEvents.ShowCreditScore -> {
                        binding.loadingProgress.isVisible = false
                        binding.errorView.isVisible = false
                        binding.scoreDonutView.isVisible = true
                        binding.scoreHolder.isVisible = true
                        event.state.getCreditScore?.let { creditScoreInfo ->
                            binding.scoreDonutView.max = creditScoreInfo.maxScoreValue
                            binding.scoreDonutView.progress = creditScoreInfo.maxScoreValue
                            binding.scoreDonutView.secondaryProgress = creditScoreInfo.score
                            binding.scoreTxt.text = creditScoreInfo.score.toString()
                            binding.outOfTxt.text = getString(R.string.out_of_txt, creditScoreInfo.maxScoreValue)
                        }
                    }


                }
            }.addTo(disposable)
    }
}