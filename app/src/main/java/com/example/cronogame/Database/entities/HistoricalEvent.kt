import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historical_events")
data class HistoricalEvent(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val categoryId: Int,
    val eventName: String,
    val year: Int
)
