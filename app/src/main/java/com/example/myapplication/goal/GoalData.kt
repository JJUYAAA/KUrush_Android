data class HigherGoalItem(
    val HigherGoalText: String,
    val RemainTempral: Int,
    val lowerGoals: List<LowerGoalItem>
)

data class LowerGoalItem(
    val Emoji : String,
    val LowerGoalText: String,
    val progress: Int
)