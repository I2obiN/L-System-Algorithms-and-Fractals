
package Lfractal
import java.io.PrintWriter

/**
  * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  * Created by I2obiN on 01/02/16.
  * Vector drawing algorithm using an LSystem
  * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  */

object Lfractal {

  var write: PrintWriter = new PrintWriter("algae.txt", "UTF-8")
  var draw: StringBuilder = new StringBuilder("")
  var direction = 0
  // Enter distance you want to draw
  var iteration = 0

  def cells(z: String, i: Int): String = {
    require(i > 0)
    var x = 0
    iteration = i
    val horizontal = '━'
    val rightanddown = '┓'
    val leftanddown = '┏'
    val leftandup = '┗'
    val rightandup = '┛'
    val vertical = '┃'
    var cells: String = z

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
        cells = cells.flatMap {
          case 'A' => draw.append("\n"); draw+=vertical; write.print(draw); "AB"
          case 'B' => draw.append("\n"); draw+=vertical; write.print(draw); "A"
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
        if(x == 0){ write.print(leftandup.toString); }
        cells = cells.flatMap {
          case 'A' => draw+=horizontal; write.print(draw); "AB"
          case 'B' => draw+=horizontal; write.print(draw); "A"
        }
      }

      // Next map ..
      x+=1
    }

    // Cleaning
    write.close()
    // Return
    cells
  }

  def main(arg: Array[String]): Unit = {
    // Run the function
    for(x <- 1 to 10) { var gen = cells("A", x) }
  }
}
