package com.example.fishwatch.view.fishDetails

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.fishwatch.data.model.FishResponse
import com.example.fishwatch.viewModel.BaseViewModel

class DetailsFragmentViewModel (application : Application): BaseViewModel(application ) {
    val fishLiveData = MutableLiveData<FishResponse>()

}