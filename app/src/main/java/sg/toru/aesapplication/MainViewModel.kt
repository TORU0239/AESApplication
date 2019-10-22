package sg.toru.aesapplication

import android.app.Application
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import javax.crypto.SecretKey

class MainViewModel(app:Application):AndroidViewModel(app) {
    private val TAG = MainViewModel::class.java.simpleName
    private var key:SecretKey = generateKey()

    val userIdLiveData = ObservableField<String>("")
    val userPwdLiveData = ObservableField<String>("")
    val encryptedData = ObservableField<String>("")

    fun onSignInButtonClick(view: View){
        userPwdLiveData.get()?.let {
            if(it.isNotEmpty()){
                Log.e(TAG, "encrypted: ${encrypt(it, key)}")
                val enc = encrypt(it, key)
                encryptedData.set(String(enc).plus(", decoded::").plus(decrypt(enc, key)))
            }
        }
    }
}