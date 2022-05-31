package foo.bar

import arrow.inject.annotations.Provider
import arrow.inject.annotations.context

fun interface Repository<T> {

  fun fetch(): T
}

@Provider fun intRepo(): Repository<Int> = Repository { 1 }

context(Repository<T>)
class UseCase<T>

fun foo(): Int {
  context<Repository<Int>>()
  return with(UseCase<Int>()) { fetch() }
}

fun main() {
  foo()
}
