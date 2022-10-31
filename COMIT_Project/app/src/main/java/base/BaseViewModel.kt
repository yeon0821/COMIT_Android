package base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import util.SnackbarMessage
import util.SnackbarMessageString

open class BaseViewModel : ViewModel() {


    private val snackbarMessage = SnackbarMessage()
    private val snackMessageString = SnackbarMessageString()


    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


    fun showSnackbar(stringResourceId: Int) {
        snackbarMessage.value = stringResourceId
    }

    fun showSnackbar(str:String){
        snackMessageString.value = str
    }

    fun observeSnackbarMessge(lifecycleOwner: LifecycleOwner, ob: (Int) -> Unit){
        snackbarMessage.observe(lifecycleOwner, ob)
    }

    fun observeSnackbarMessageStr(lifecycleOwner: LifecycleOwner, ob:(String) -> Unit){
        snackMessageString.observe(lifecycleOwner, ob)
    }


}