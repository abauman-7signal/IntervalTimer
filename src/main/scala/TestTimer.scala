import java.lang.System.currentTimeMillis

class TestTimer(val intervalInMs: Long) {
  val IntervalInMs: Long = intervalInMs
  val StartTimeInMs: Long = currentTimeMillis()
  private var lastIntervalCrossed: Long = 0
  private var numberTimesCrossed: Long = 0

  private def hasCrossedInterval: Boolean = {
    val currentInterval = (currentTimeMillis() - StartTimeInMs) / IntervalInMs

    if (currentInterval > lastIntervalCrossed) {
      println(s"numberTimesCrossed: $numberTimesCrossed")
      numberTimesCrossed = numberTimesCrossed + currentInterval - lastIntervalCrossed
      lastIntervalCrossed = currentInterval
      return true
    }
    false
  }

  def getNumberTimesCrossed: Long = {
    hasCrossedInterval
    numberTimesCrossed
  }

  def getNumberTimesCrossedAndClear: Long = {
    val numTimesCrossed = getNumberTimesCrossed
    numberTimesCrossed = 0
    numTimesCrossed
  }
}
