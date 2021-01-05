import java.lang.System.currentTimeMillis

class TestTimer(val intervalInMs: Long) {
  val IntervalInMs: Long = intervalInMs
  val StartTimeInMs: Long = currentTimeMillis()
  var lastIntervalCrossed: Long = 0

  def hasCrossedInterval: Boolean = {
    val currentInterval = (currentTimeMillis() - StartTimeInMs) / IntervalInMs

    if (currentInterval > lastIntervalCrossed) {
      lastIntervalCrossed = currentInterval
      return true
    }
    return false
  }
}
