package foo.bar

import arrow.inject.annotations.context
import arrow.inject.annotations.Provider
import arrow.inject.annotations.contextual

interface Repository<T>

class IntRepo : Repository<Int>

@Provider fun repo(): Repository<Int> = IntRepo()

context(Repository<T>)
class UseCase<T>(val x: Int)

fun f(): Int {
  context<Repository<Int>>()
  return UseCase<Int>(x = 0).x
}

fun f3(): Int {
  return contextual<Repository<Int>, Int>(repo()) {
    return UseCase<Int>(x = 0).x
  }
}

fun box(): String {
  val result = f()
  return if (result == 0) {
    "OK"
  } else {
    "Fail: $result"
  }
}
