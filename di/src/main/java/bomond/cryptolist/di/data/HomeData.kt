package bomond.cryptolist.di.data

class HomeData {
    data class Element(
        var image: String,
        var name: String,
        var capitalization: String,
        var price: String,
        var growth: String
    )
}