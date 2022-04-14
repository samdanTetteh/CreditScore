package com.ijikod.mycreditscore.creditScore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ijikod.mycreditscore.R
import com.ijikod.mycreditscore.common.*
import com.ijikod.mycreditscore.creditScore.CreditScoreViewModel
import com.ijikod.mycreditscore.databinding.FragmentCreditDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreditDetailFragment : Fragment() {

    private var _binding: FragmentCreditDetailBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreditDetailBinding.inflate(inflater, container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { args ->
            val clientRef = args.getString(CLIENT_REF, String())
            val defaultedStatus = args.getBoolean(DEFAULTED_STATUS)
            val creditUsed = args.getString(USED_CREDIT_PERCENTAGE, String())
            val creditScore = args.getString(CREDIT_SCORE, String())

            binding.clientRefTxt.text = getString(R.string.client_ref, clientRef)
            binding.defaultedTxt.text = getString(R.string.defaulted, defaultedStatus)
            binding.creditUsedTxt.text = getString(R.string.percentageCreditUsed, creditUsed)
            binding.scoreTxt.text = getString(R.string.creditScoreTxt, creditScore)
        }
    }
}