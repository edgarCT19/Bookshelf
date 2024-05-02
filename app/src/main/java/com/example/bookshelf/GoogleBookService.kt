import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksService {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 10
    ): BookResponse

    data class BookResponse(
        val items: List<BookItemResponse>
    )

    data class BookItemResponse(
        val volumeInfo: VolumeInfoResponse
    )

    data class VolumeInfoResponse(
        val title: String,
        val imageLinks: ImageLinksResponse?
    )

    data class ImageLinksResponse(
        val thumbnail: String?
    )
}
