package di.module

import MainSearchRecyclerViewAdapter
import androidx.lifecycle.ProcessLifecycleOwner.get
import androidx.lifecycle.viewmodel.viewModelFactory
import model.DataModel
import model.DataModelImpl
import model.service.KakaoSearchService
import org.koin.dsl.module
import retrofit2.Retrofit
import org.koin.androidx.viewmodel.ext.koin.viewModel
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import viewmodel.MainViewModel

//
//private val retrofit: Retrofit= Retrofit.Builder().apply {
//    baseUrl("https://dapi.kakao.com")
//    addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//    addConverterFactory(GsonConverterFactory.create())
//}.build()
//


var retrofitPart = module{
    single <KakaoSearchService> {
        Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KakaoSearchService::class.java)
    }
}

var adapterPart = module {
    factory {
        MainSearchRecyclerViewAdapter()
    }
}

var modelImpl = module {
    factory {
        DataModelImpl(get())
    }
}
var viewModelPart = module {
    viewModelFactory {
        MainViewModel(get())
    }
}

var myDiModule = listOf(
    retrofitPart,
    adapterPart,
    modelImpl,
    viewModelPart
)