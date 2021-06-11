package com.example.tabunganku.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tabunganku.BuildConfig.BASE_URL
import com.example.tabunganku.R
import com.example.tabunganku.data.network.ApiConfig
import com.example.tabunganku.data.network.ApiService
import com.example.tabunganku.data.respons.ResponsLogin
import com.example.tabunganku.databinding.FragmentLoginBinding
import com.example.tabunganku.databinding.FragmentRegisterBinding
import com.example.tabunganku.home.HomeActivity
import com.example.tabunganku.login.LoginFragment
import com.example.tabunganku.main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
    private lateinit var fragmentSignUpFragment: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignUpFragment =  FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return fragmentSignUpFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSignUpFragment.btnSignup.setOnClickListener {
            val username: String = fragmentSignUpFragment.edEmail.text.toString().trim()
            val password: String = fragmentSignUpFragment.edPassword.text.toString().trim()
            val reenterpassword: String = fragmentSignUpFragment.edReenterpassword.text.toString().trim()

            if (username.isEmpty()) {
                fragmentSignUpFragment.edEmail.error = getString(R.string.email_required)
                fragmentSignUpFragment.edEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                fragmentSignUpFragment.edPassword.error = getString(R.string.password_required)
                fragmentSignUpFragment.edPassword.requestFocus()
                return@setOnClickListener
            }
            if (reenterpassword.isEmpty()) {
                fragmentSignUpFragment.edReenterpassword.error = getString(R.string.password_required)
                fragmentSignUpFragment.edReenterpassword.requestFocus()
                return@setOnClickListener
            }
            signupUserApi()
        }
    }

    private fun signupUserApi() {
        val email = fragmentSignUpFragment.edEmail.text.toString()
        val password = fragmentSignUpFragment.edPassword.text.toString()
        val reentrypassword = fragmentSignUpFragment.edReenterpassword.text.toString()

        val user = ApiConfig.getApiService(BASE_URL).create(ApiService::class.java)
        user.postSignup(email, password, reentrypassword)
            .enqueue(object : Callback<ResponsLogin> {
                override fun onFailure(call: Call<ResponsLogin>, t: Throwable) {
                    Log.e("SIGUP", "Failed: ${t.message.toString()}")
                }

                override fun onResponse(call: Call<ResponsLogin>, response: Response<ResponsLogin>) {
                    val user = response.body()
                    Toast.makeText(context, "Sukses Signup Silahkan Login", Toast.LENGTH_SHORT).show()
                }
            })
    }
}