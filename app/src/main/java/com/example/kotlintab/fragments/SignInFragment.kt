package com.example.kotlintab.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlintab.R
import com.example.kotlintab.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    private var Sbinding : FragmentSignInBinding? = null
    private val binding get() = Sbinding!!

    var CheckUser : Boolean = false

    var CheckPassword : Boolean = false

    var passwordVisible : Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Sbinding = FragmentSignInBinding.inflate(inflater,container,false)

        binding.SignInBtn.isEnabled = false

        Log.e("My Fragment","This is on CreateView")

        binding.SignInBtn.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Sign In Sucessful",Toast.LENGTH_SHORT).show()
        })


        /*
        binding.Password.setOnTouchListener(object : View.OnTouchListener {
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                val  Right =2
                if (event != null) {
                    if(event.action == MotionEvent.ACTION_UP){
                        if(event.getRawX()>=binding.Password.right-binding.Password.compoundDrawables[Right].bounds.width()){
                            var selection = binding.Password.selectionEnd
                            if(passwordVisible==true){
                                binding.Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,
                                    R.drawable.password_invisible,0)
                                binding.Password.transformationMethod = PasswordTransformationMethod.getInstance()
                                passwordVisible = false
                            }else{
                                binding.Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,
                                    R.drawable.password_visible,0)
                                binding.Password.transformationMethod = HideReturnsTransformationMethod.getInstance()
                                passwordVisible = true
                            }
                            binding.Password.setSelection(selection)
                            return true
                        }
                    }
                }
                return false
            }

        })
        */


        binding.passwordToggle.setOnClickListener(View.OnClickListener {
            if (passwordVisible==true){
                binding.Password.transformationMethod =  PasswordTransformationMethod.getInstance()
                binding.passwordToggle.setBackgroundResource(R.drawable.password_invisible)
                passwordVisible = false
            }else{
                binding.Password.transformationMethod =  HideReturnsTransformationMethod.getInstance()
                binding.passwordToggle.setBackgroundResource(R.drawable.password_visible)
                passwordVisible = true
            }
        })

        binding.EditTextUsername.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            @SuppressLint("SetTextI18n")
            override fun afterTextChanged(s: Editable?) {
                var userName = s.toString()

                if (userName.isEmpty()) {
                    binding.userError.text = "Username Cannot be Empty"
                    binding.LayoutUsername.setBackgroundResource(R.drawable.error_border_line)
                    CheckUser = false
                } else if (!userName.matches(".*[a-z].*".toRegex())) {
                    binding.userError.text = "Missing Lowercase"
                    binding.LayoutUsername.setBackgroundResource(R.drawable.error_border_line)
                    CheckUser = false
                } else if (!userName.matches(".*[A-Z].*".toRegex())) {
                    binding.userError.text = "Missing Uppercase"
                    binding.LayoutUsername.setBackgroundResource(R.drawable.error_border_line)
                    CheckUser = false
                } else if (userName.matches("[0-9]".toRegex())) {
                    binding.userError.text = "No letters with Uppercase and Lowercase Present"
                    binding.LayoutUsername.setBackgroundResource(R.drawable.error_border_line)
                    CheckUser = false
                } else {
                    binding.userError.text = ""
                    binding.LayoutUsername.setBackgroundResource(R.drawable.border_line)
                    CheckUser = true
                }

                binding.SignInBtn.isEnabled = (CheckUser)&&(CheckPassword)

            }

        })

        binding.Password.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            @SuppressLint("SetTextI18n")
            override fun afterTextChanged(s: Editable?) {
                var UserPassword = s.toString()

                if (UserPassword.isEmpty()) {
                    binding.passwordError.text = "Password cannot be Empty"
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else if (!UserPassword.matches(".*[a-z].*".toRegex())) {
                    binding.passwordError.text = "Missing Lowercase"
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else if (!UserPassword.matches(".*[A-Z].*".toRegex())) {
                    binding.passwordError.text = "Missing Uppercase"
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else if (!UserPassword.matches(".*[0-9].*".toRegex())) {
                    binding.passwordError.text = "Missing Number"
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else if (!UserPassword.matches(".*[!@#$%&*].*".toRegex())) {
                    binding.passwordError.text = "Missing Special Character"
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else if (UserPassword.length < 6) {
                    binding.passwordError.text = "Password to Short"
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line)
                    CheckPassword = false
                } else {
                    binding.passwordError.text = null
                    binding.LayoutPassword.setBackgroundResource(R.drawable.border_line)
                    CheckPassword = true
                }

                binding.SignInBtn.isEnabled = (CheckUser)&&(CheckPassword)

            }

        })
        return binding.root
    }

    override fun onAttach(context: Context) {
        Log.e("My Fragment","This is on Attached")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("My Fragment","This is on Create")
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.e("My Fragment","This is on Activity Created")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.e("My Fragment","This is on Start")
        super.onStart()
    }

    override fun onResume() {
        Log.e("My Fragment","This is on Resume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("My Fragment","This is on Pause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("My Fragment","This is on Stop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("My Fragment","This is on Destroy")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.e("My Fragment","This is on DestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.e("My Fragment","This is on Detach")
        super.onDetach()
    }
}