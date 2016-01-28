import scala.io.StdIn
import java.io.PrintWriter

/**
  * Created by I2obiN on 26/01/16.
  */

object Lfractal {
 
 var write: PrintWriter = new PrintWriter("algae.txt", "UTF-8")

  def fractal() = {
   // O(1)
    print("iterations> ")
    val iteration = StdIn.readInt()
    require(iteration > 0)
    var x = 0
    var fractal: String = "A"

    // Run through iterations, O(n^2) (quadratic time I think)
    while(x != iteration){
      // Print current line
      write.println(fractal)
      fractal = fractal.flatMap { case 'A' => "AB" case 'B' => "A"}
      x+=1
    }
  }

  def main(arg: Array[String]): Unit = {
    // Run the function
    fractal()
  }

}
