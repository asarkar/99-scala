package list
import org.scalacheck.Gen

object ListGen:
  val genInt      = Gen.choose(0, 9)
  val genNotEmpty = Gen.nonEmptyListOf(genInt)
  def genSizeBetween(min: Int, max: Int) = Gen
    .choose(min, max)
    .flatMap(Gen.listOfN(_, genInt))
