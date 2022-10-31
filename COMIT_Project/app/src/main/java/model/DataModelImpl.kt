package model

import io.reactivex.Single
import model.enum.KaKaoSearchSortEunm
import model.response.ImageSearchResponse
import model.service.KakaoSearchService

class DataModelImpl(private val service: KakaoSearchService):DataModel {

    private val KAKAO_APP_KEY = "YOUR_APP_KEY"

    override fun getData(
        query: String,
        sort: KaKaoSearchSortEunm,
        page: Int,
        size: Int
    ): Single<ImageSearchResponse> {
        return service.searchImage(auth = "KakaoAK $KAKAO_APP_KEY", query = query, sort = sort.sort, page = page, size = size)
    }
}
