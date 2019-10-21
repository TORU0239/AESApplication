package sg.toru.aesapplication

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel

class MainViewModel(app:Application):AndroidViewModel(app) {
    private val TAG = MainViewModel::class.java.simpleName

    fun onSignInButtonClick(view: View){
        Log.e(TAG, "onSignInClick")
    }


}