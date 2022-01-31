package android.example.rgisterformbyfragments

import android.example.rgisterformbyfragments.databinding.RegisterFragmentBinding
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class RegisterFragment : Fragment(R.layout.register_fragment) {

    lateinit var binding: RegisterFragmentBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = RegisterFragmentBinding.bind(view)



      binding.btnRegister.setOnClickListener {
          var fullName = binding.txtFullName.text
          var userName = binding.txtUsername.text
          var email = binding.txtEmail.text
          var pass = binding.txtPass.text
          var gender = if (binding.rbFemale.isChecked == true) "Female" else if(binding.rbMale.isChecked == true) "Male" else "Not Set"

          parentFragmentManager.commit {
              setReorderingAllowed(true)
              val bundle = bundleOf(Pair("FULLNAME",fullName),Pair("USERNAME",userName),Pair("EMAIL",email),Pair("PASS",pass),Pair("GENDER",gender))
              replace<ShowInfoFragment>(R.id.container1,args = bundle)



          }
      }


    }


}

