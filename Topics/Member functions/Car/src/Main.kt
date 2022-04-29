class Car(val make: String, val year: Int) {
    private val five = 5
    var speed: Int = 0

    fun accelerate() {
        speed += five
    }
    fun decelerate() {
        speed -= if (speed >= five) five else speed
    }
}