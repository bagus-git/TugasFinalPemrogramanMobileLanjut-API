package com.example.tabunganku.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tabunganku.R
import com.example.tabunganku.databinding.FragmentLoginBinding
import com.example.tabunganku.home.HomeActivity

class LoginFragment : Fragment() {
    private lateinit var fragmentLoginFragment: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLoginFragment =  FragmentLoginBinding.inflate(layoutInflater, container, false)
        return fragmentLoginFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentLoginFragment.btnLogin.setOnClickListener {
            val username: String = fragmentLoginFragment.edEmail.text.toString().trim()
            val password: String = fragmentLoginFragment.edPassword.text.toString().trim()

            if (username.isEmpty()) {
                fragmentLoginFragment.edEmail.error = getString(R.string.email_required)
                fragmentLoginFragment.edEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                fragmentLoginFragment.edPassword.error = getString(R.string.password_required)
                fragmentLoginFragment.edPassword.requestFocus()
                return@setOnClickListener
            }
            val intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}