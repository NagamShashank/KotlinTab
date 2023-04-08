package com.example.kotlintab.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.kotlintab.R
import com.example.kotlintab.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {


    private var sbinding : FragmentSignUpBinding? = null
    private val binding get() = sbinding!!
    
    var CheckUser = false
    var CheckPassword = false
    var CheckEmail = false
    var CheckContact = false

    var VisiblePassword = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        sbinding = FragmentSignUpBinding.inflate(inflater,container,false)

        binding.SignUpBtn.isEnabled = false

        binding.SignUpPassword.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val Right = 2
                if (event.rawX >= binding.SignUpPassword.right - binding.SignUpPassword.compoundDrawables[Right].bounds.width()) {
                    val selection = binding.SignUpPassword.selectionEnd
                    if (VisiblePassword) {
                        binding.SignUpPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.password_invisible,
                            0
                        )
                        binding.SignUpPassword.transformationMethod =
                            PasswordTransformationMethod.getInstance()
                        VisiblePassword = false
                    } else {
                        binding.SignUpPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.password_visible,
                            0
                        )
                        binding.SignUpPassword.transformationMethod =
                            HideReturnsTransformationMethod.getInstance()
                        VisiblePassword = true
                    }
                    binding.SignUpPassword.setSelection(selection)
                    return@OnTouchListener true
                }
            }
            false
        })


        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.Country,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.Spinner.adapter = adapter
        binding.Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val country = parent.getItemAtPosition(position).toString()
                binding.countryCode.text = country
                //signUpBinding.SignUpBtn.setEnabled(true);
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //signUpBinding.SignUpBtn.setEnabled(false);
            }
        }


        //Username.....
        binding.SignUpUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            @SuppressLint("SetTextI18n")
            override fun afterTextChanged(s: Editable) {
                val User = s.toString()
                if (User.isEmpty()) {
                    binding.userErrorText.text = "Username Cannot be Empty"
                    binding.SignUpLayoutUsername.setBackgroundResource(R.drawable.error_border_line)
                    CheckUser = false
                } else if (!User.matches(".*[a-z].*".toRegex())) {
                    binding.userErrorText.text = "Missing Lowercase"
                    binding.SignUpLayoutUsername.setBackgroundResource(R.drawable.error_border_line)
                    CheckUser = false
                } else if (!User.matches(".*[A-Z].*".toRegex())) {
                    binding.userErrorText.text = "Missing Uppercase"
                    binding.SignUpLayoutUsername.setBackgroundResource(R.drawable.error_border_line)
                    CheckUser = false
                } else if (User.matches("[0-9]".toRegex())) {
                    binding.userErrorText.text = "No letters with Uppercase and Lowercase Present"
                    binding.SignUpLayoutUsername.setBackgroundResource(R.drawable.error_border_line)
                    CheckUser = false
                } else {
                    binding.userErrorText.text = null
                    binding.SignUpLayoutUsername.setBackgroundResource(R.drawable.border_line)
                    CheckUser = true
                }
                binding.SignUpBtn.isEnabled = CheckUser && CheckEmail && CheckContact && CheckPassword
            }
        })


        //Email........
        binding.SignUpEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            @SuppressLint("SetTextI18n")
            override fun afterTextChanged(s: Editable) {
                val email = s.toString()
                if (email.isEmpty()) {
                    binding.EmailErrorText.text = "Email cannot be Empty"
                    binding.SighUpLayoutEmail.setBackgroundResource(R.drawable.error_border_line)
                    CheckEmail = false
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.EmailErrorText.text = "Invalid Email-ID"
                    binding.SighUpLayoutEmail.setBackgroundResource(R.drawable.error_border_line)
                    CheckEmail = false
                } else {
                    binding.EmailErrorText.text = null
                    binding.SighUpLayoutEmail.setBackgroundResource(R.drawable.border_line)
                    CheckEmail = true
                }
                binding.SignUpBtn.isEnabled = CheckUser == true && CheckEmail == true && CheckContact == true && CheckPassword == true
            }
        })

        //Contact......

        //Contact......
        binding.SignUpContact.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            @SuppressLint("SetTextI18n")
            override fun afterTextChanged(s: Editable) {
                val Contact = s.toString()
                if (Contact.isEmpty()) {
                    binding.ContactErrorText.text = "Contact cannot be Empty"
                    binding.SignUpLayoutContact.setBackgroundResource(R.drawable.error_border_line)
                    CheckContact = false
                } else if (!Contact.matches(".*(\\d{10}$).*".toRegex())) {
                    binding.ContactErrorText.text = "Invalid Contact Number"
                    binding.SignUpLayoutContact.setBackgroundResource(R.drawable.error_border_line)
                    CheckContact = false
                } else {
                    binding.ContactErrorText.text = null
                    binding.SignUpLayoutContact.setBackgroundResource(R.drawable.border_line)
                    CheckContact = true
                }
                binding.SignUpBtn.isEnabled = CheckUser == true && CheckEmail == true && CheckContact == true && CheckPassword == true
            }
        })

        //Password.....

        //Password.....
        binding.SignUpPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            @SuppressLint("SetTextI18n")
            override fun afterTextChanged(s: Editable) {
                val Password = s.toString()
                if (Password.isEmpty()) {
                    binding.PasswordErrorText.text = "Password cannot be Empty"
                    binding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else if (!Password.matches(".*[A-Z].*".toRegex())) {
                    binding.PasswordErrorText.text = "Uppercase Missing"
                    binding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else if (!Password.matches(".*[a-z].*".toRegex())) {
                    binding.PasswordErrorText.text = "Lowercase Missing"
                    binding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else if (!Password.matches(".*[0-9].*".toRegex())) {
                    binding.PasswordErrorText.text = "Missing Number"
                    binding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else if (!Password.matches(".*[!@#$%&*].*".toRegex())) {
                    binding.PasswordErrorText.text = "Missing Special Character"
                    binding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else if (Password.length <= 7) {
                    binding.PasswordErrorText.text = "Password is less than 6"
                    binding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else {
                    binding.PasswordErrorText.text = null
                    binding.SighUpLayoutPassword.setBackgroundResource(R.drawable.border_line)
                    CheckPassword = true
                }
                binding.SignUpBtn.isEnabled = CheckUser == true && CheckEmail == true && CheckContact == true && CheckPassword == true
            }
        })

        return binding.root

    }

}