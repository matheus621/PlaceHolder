package com.example.placeholder.ui.listusers

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.placeholder.R
import kotlinx.android.synthetic.main.list_users_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()

        Glide.with(view!!.context).load(R.drawable.unnamed).into(gif_maxima)

        btn_list.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_listUsersFragment)
        }
    }


}