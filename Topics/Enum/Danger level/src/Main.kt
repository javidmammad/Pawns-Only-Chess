@SuppressWarnings("MagicNumber")
enum class DangerLevel {
    HIGH,
    MEDIUM,
    LOW;
    fun getLevel() = 3 - ordinal
}