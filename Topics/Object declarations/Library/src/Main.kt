object Math {
    fun abs(arg: Int): Int {
        return if (arg >= 0) arg else arg * -1
    }
    fun abs(arg: Double): Double {
        return if (arg >= 0) arg else arg * -1
    }
}