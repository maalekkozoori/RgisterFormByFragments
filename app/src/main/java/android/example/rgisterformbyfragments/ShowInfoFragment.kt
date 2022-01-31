package android.example.rgisterformbyfragments

import android.content.Context
import android.content.SharedPreferences
import android.example.rgisterformbyfragments.databinding.ShowInfoFragmentBinding
import android.os.Binder
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class ShowInfoFragment : Fragment(R.layout.show_info_fragment) {


    lateinit var binding: ShowInfoFragmentBinding

    lateinit var sharedPreferences: SharedPreferences


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ShowInfoFragmentBinding.bind(view)

        sharedPreferences = requireContext().getSharedPreferences("RegisterInfo", Context.MODE_PRIVATE)

        binding.tvFullName.text = arguments?.get("FULLNAME").toString()
        binding.tvUserName.text = arguments?.get("USERNAME").toString()
        binding.tvEmail.text = arguments?.get("EMAIL").toString()
        binding.tvPassword.text = arguments?.get("PASS").toString()
        binding.tvGender.text = arguments?.get("GENDER").toString()


        binding.btnSave.setOnClickListener {
            saveData()
            parentFragmentManager.commit {
                replace<RegisterFragment>(R.id.container1)
            }
        }

    }

fun saveData(){
    with(binding){
        var edit = sharedPreferences.edit()
        edit.putString("Full_Name", tvFullName.text.toString())
        edit.putString("User_Name", tvUserName.text.toString())
        edit.putString("Email", tvEmail.text.toString())
        edit.putString("Pass", tvPassword.text.toString())
        edit.putString("Gender", tvGender.text.toString())
        edit.apply()
        Toast.makeText(requireContext(), "Data Saved Successfuly", Toast.LENGTH_LONG)
            .show()
    }

}
}
