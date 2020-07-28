package com.example.placeholder.ui.listusers

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.placeholder.R
import com.example.placeholder.model.Users
import kotlinx.android.synthetic.main.item_full_fragment.*

class UsersFullFragment : Fragment() {

    private lateinit var viewModel: UsersFullViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.item_full_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()

        viewModel = ViewModelProviders.of(this).get(UsersFullViewModel::class.java)


        val userId = arguments?.getInt("userSelectdId")
        userId?.let { viewModel.setCurrentSelectedUserId(it) }


        val observeUserData = Observer<Users> { users ->

            if (users != null) {
                textId.text = users.id.toString()
                txtNameFull.text = users.name
                txtEmailFull.text = users.email
                txtPhoneFull.text = users.phone
                textWebsite.text = users.website
                textStreet.text = users.address!!.street
                textSuite.text = users.address!!.suite
                textCity.text = users.address!!.city
                textZipcode.text = users.address!!.zipcode
                textNameCompany.text = users.company!!.name


            }

        }

        viewModel.getUserLiveData().observe(viewLifecycleOwner, observeUserData)
       // NavHostFragment.findNavController(this).navigate(R.id.action_usersFullFragment_to_listUsersFragment)

    }

}