import org.scalatest.FunSuite

class TestTimerTest extends FunSuite {
  test("when instantiated, object set to known state") {
    val subject = new TestTimer(100)
    assert(subject.IntervalInMs == 100)
    assert(subject.StartTimeInMs > 0)
//    assert(subject.lastIntervalCrossed == 0)
    assert(subject.getNumberTimesCrossed == 0)
  }

  test("when has not crossed interval") {
    val subject = new TestTimer(100)
//    assert(!subject.hasCrossedInterval)
    assert(subject.getNumberTimesCrossed == 0)
  }

  test("when has crossed interval") {
    val subject = new TestTimer(50)
    Thread.sleep(50)
//    assert(subject.hasCrossedInterval)
    assert(subject.getNumberTimesCrossed == 1)
  }

  test("when has crossed second interval") {
    val subject = new TestTimer(50)
//    assert(!subject.hasCrossedInterval)
    Thread.sleep(50)
//    assert(subject.hasCrossedInterval)
//    assert(!subject.hasCrossedInterval)
    assert(subject.getNumberTimesCrossed == 1)
    Thread.sleep(50)
//    assert(subject.hasCrossedInterval)
//    assert(!subject.hasCrossedInterval)
    assert(subject.getNumberTimesCrossed == 2)
  }

  test("when has crossed 2 intervals without being checked") {
    val subject = new TestTimer(30)
//    assert(!subject.hasCrossedInterval)
    assert(subject.getNumberTimesCrossed == 0)
    Thread.sleep(70)
//    assert(subject.hasCrossedInterval)
//    assert(!subject.hasCrossedInterval)
    assert(subject.getNumberTimesCrossed == 2)
  }

  test("when has crossed interval and accessed times crossed interval with clear") {
    val subject = new TestTimer(50)
    Thread.sleep(50)
//    assert(subject.hasCrossedInterval)
    assert(subject.getNumberTimesCrossed == 1)
    Thread.sleep(50)
    assert(subject.getNumberTimesCrossed == 2)
    assert(subject.getNumberTimesCrossedAndClear == 2)
    assert(subject.getNumberTimesCrossed == 0)
  }
}
