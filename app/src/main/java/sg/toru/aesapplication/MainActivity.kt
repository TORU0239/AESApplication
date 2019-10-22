package sg.toru.aesapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import sg.toru.aesapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViewModel()
    }

    override fun onDestroy() {
        if(::binding.isInitialized){
            binding.unbind()
        }
        super.onDestroy()
    }

    private fun initViewModel() {
        binding.viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(MainViewModel::class.java)
        binding.lifecycleOwner = this
    }
}