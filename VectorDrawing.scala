
package Lfractal
import java.io.PrintWriter

/**
  * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  * Created by I2obiN on 26/01/16.
  * Vector drawing algorithm using an LSystem
  * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  */

object Lfractal {

  var write: PrintWriter = new PrintWriter("algae.txt", "UTF-8")
  var draw: StringBuilder = new StringBuilder("")
  var direction = 1
  var cells = ""

  def cells(z: String, i: Int): String = {
    require(i > 0)
    cells = z
    var x = 0
    val iteration = i
    val horizontal = '━'
    val rightanddown = '┓'
    val leftanddown = '┏'
    val leftandup = '┗'
    val rightandup = '┛'
    val vertical = '┃'


    // Algorithm
    while(x != iteration) {

      if(direction == 0) {
        cells = cells.flatMap {
          case 'A' => draw+=horizontal; write.print(draw); "AB"
          case 'B' => draw+=horizontal; write.print(draw); "A"
        }
        if(x == iteration-1){ draw+=rightanddown; write.print(draw) }
      }

      if(direction == 1) {
        for(count <- x to 0) { draw.append(" ") }
        cells = cells.flatMap {
          case 'A' => draw.append("\n" + draw); draw+=vertical; write.print(draw); "AB"
          case 'B' => draw.append("\n" + draw); draw+=vertical; write.print(draw); "A"
        }
        if(x == iteration-1){ draw.append("\n"); draw+=rightandup; write.print(draw) }
      }

      if(direction == 2) {
        if(x == 0){ write.print(leftandup.toString); }
        cells = cells.flatMap {
          case 'A' => draw.append(horizontal.toString + draw); write.print(draw); "AB"
          case 'B' => draw.append(horizontal.toString + draw); write.print(draw); "A"
        }
      }

      if(direction == 3) {
        if(x == 0){ write.print(leftanddown.toString); }
        cells = cells.flatMap {
          case 'A' => draw+=horizontal; write.print(draw); "AB"
          case 'B' => draw+=horizontal; write.print(draw); "A"
        }
      }

      // Next map ..
      x+=1
    }

    // Return
    cells
  }

  def main(arg: Array[String]): Unit = {
    // Run the function
    cells("A", 2)
    direction+=1
    cells("A", 2)
    write.close()

  }
}
