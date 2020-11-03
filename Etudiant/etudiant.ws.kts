//Créer une classe Etudiant avec les attributs : name, code, sexe, adresse, age
class Etudiant(
    val name: String,
    val code: String,
    val sexe: Sexe,
    val adresse: String,
    val age: Int
){override fun toString()=name}

enum class Sexe { Male, Female, Unknown }

val etudiants = listOf(
    Etudiant(
        name = "Julie",
        code = "P01",
        sexe = Sexe.Female,
        adresse = "Biarritz",
        age = 13
    ),
    Etudiant(
        name = "Jeanne",
        code = "P02",
        sexe = Sexe.Female,
        adresse = "Biarritz",
        age = 23
    ),
    Etudiant(
        name = "André",
        code = "P03",
        sexe = Sexe.Male,
        adresse = "Biarritz",
        age = 45
    ),
    Etudiant(
        name = "Marc",
        code = "P04",
        sexe = Sexe.Male,
        adresse = "Biarritz",
        age = 13
    ), Etudiant(
        name = "Franck",
        code = "P05",
        sexe = Sexe.Unknown,
        adresse = "Biarritz",
        age = 68
    ),
    Etudiant(
        name = "Patrick",
        code = "P06",
        sexe = Sexe.Male,
        adresse = "Biarritz",
        age = 64
    ),
    Etudiant(
        name = "Juliette",
        code = "P07",
        sexe = Sexe.Female,
        adresse = "Biarritz",
        age = 42
    ), Etudiant(
        name = "Elie",
        code = "P08",
        sexe = Sexe.Unknown,
        adresse = "Biarritz",
        age = 98
    ), Etudiant(
        name = "Emie",
        code = "P09",
        sexe = Sexe.Female,
        adresse = "Biarritz",
        age = 24
    ), Etudiant(
        name = "Suzanne",
        code = "P01",
        sexe = Sexe.Male,
        adresse = "Biarritz",
        age =24
    )
)
val ages = etudiants.sortedBy {
    it.age }
println(ages)
val bySexe = etudiants.groupBy {
    it.sexe
}
println(bySexe)
val f = bySexe.get(Sexe.Female)
println(f)

val m = bySexe.get(Sexe.Male)
println(m)
//etudiants[0].name="Maxime"
//println(etudiants[0])
etudiants.reversed()
println(etudiants)

