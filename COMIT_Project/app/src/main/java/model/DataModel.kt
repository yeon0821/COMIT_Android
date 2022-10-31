package model

import io.reactivex.Single
import model.enum.KaKaoSearchSortEunm
import model.response.ImageSearchResponse

interface DataModel {
    fun getData(query:String, sort: KaKaoSearchSortEunm, page:Int, size:Int): Single<ImageSearchResponse>
}