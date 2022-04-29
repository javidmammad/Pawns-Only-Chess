class Hero {
    val baseStrength = 1000
    inner class Equipment {
        val weapon = "trident"
        val weaponStrength = this@Hero.baseStrength + 300
    }
}

class Villain {
    val baseStrength = 500
    inner class Equipment {
        val weapon = "bomb"
        val weaponStrength = this@Villain.baseStrength + 700
    }
}

fun main() {
    val heroEquipment = Hero().Equipment()
    val heroTotalStrength = heroEquipment.weaponStrength

    val villainEquipment = Villain().Equipment()
    val villainTotalStrength = villainEquipment.weaponStrength

    // the following lines should remain as they are
    println("The hero uses ${heroEquipment.weapon}. The total strength is $heroTotalStrength.")
    println("The villain uses ${villainEquipment.weapon}. The total strength is $villainTotalStrength.")
}
