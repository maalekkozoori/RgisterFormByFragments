package android.example.rgisterformbyfragments

import android.example.rgisterformbyfragments.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<RegisterFragment>(R.id.container1)

        }





    }

    fun goToShowInfoFragment(){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<ShowInfoFragment>(R.id.container1)
        }
    }
}