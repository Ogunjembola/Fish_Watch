package com.example.fishwatch.view.fishList

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.fishwatch.data.api.FishApiServices
import com.example.fishwatch.data.model.FishResponse
import com.example.fishwatch.viewModel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListFragmentViewModel(application: Application) : BaseViewModel(application) {
    private val fishService = FishApiServices
    private val disposable = CompositeDisposable()


    val fish = MutableLiveData<List<FishResponse>>()
    val fishLoadingError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    fun refresh() {
        fetchRemoteData()

    }

    private fun fetchRemoteData() {
        loading.value = true

        disposable.add(
            fishService.getFish()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<FishResponse>>() {
                    override fun onSuccess(fishList: List<FishResponse>) {
                        fish.value = fishList
                        fishLoadingError.value = false
                        loading.value = false

                    }

                    override fun onError(e: Throwable) {
                        fishLoadingError.value = true
                        loading.value = false
                        e.printStackTrace()
                    }

                })
        )
    }
}