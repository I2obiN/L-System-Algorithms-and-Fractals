import scala.io.StdIn

/**
  * Created by I2obiN on 26/01/16.
  */

object Lfractal {

  def fractal() = {
    print("iterations> ")
    val iteration = StdIn.readInt()
    var x = 0
    var fractal: String = "A"

    // Run through iterations, O(n^2)
    while(x != iteration){
      // Print current line
      println(fractal)
      fractal = fractal.flatMap { case 'A' => "AB" case 'B' => "A"}
      x+=1
    }
  }

  def main(arg: Array[String]): Unit = {
    // Run the function
    fractal()
  }

}
