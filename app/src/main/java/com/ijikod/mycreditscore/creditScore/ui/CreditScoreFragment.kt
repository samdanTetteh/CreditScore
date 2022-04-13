package com.ijikod.mycreditscore.creditScore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ijikod.mycreditscore.databinding.FragmentCreditScoreBinding
import com.ijikod.mycreditscore.common.AutoCompositeDisposable
import com.ijikod.mycreditscore.creditScore.CreditScoreViewModel
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
    }
}