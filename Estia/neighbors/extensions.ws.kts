data class Neighbor(
    val id: Long,
    val name: String,
    val avatarUrl: String,
    val address: String,
    val phoneNumber: String,
    val aboutMe: String,
    val favorite: Boolean,
    val webSite: String
)

fun String.concat(text: String) {
    println(" $this  $text")
}
val test:String="test"
test.concat("hello")

val neighbor = Neighbor(
    firstname = "Amosse"
    lastname ="Edouard"
)

println(neighbor.fullName())