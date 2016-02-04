import java.awt._
import scala.swing._
import scala.swing.Panel

/**
  * Created by I2obiN && rosettacode.org on 03/02/16.
  * Added swing lib through build.sbt, rewrote preferrsedsize call
  */

class FractalTree extends SimpleSwingApplication {
  val DEPTH = 9

  def top = new MainFrame {
    contents = new Panel {
      preferredSize.setSize(new Dimension(600, 500))

        override def paintComponent(g: Graphics2D) {
          draw(300, 460, -90, DEPTH)

          def draw(x1: Int, y1: Int, angle: Double, depth: Int) {
            if (depth > 0) {
              val x2 = x1 + (math.cos(angle.toRadians) * depth * 10).toInt
              val y2 = y1 + (math.sin(angle.toRadians) * depth * 10).toInt

              g.setColor(Color.getHSBColor(0.25f - depth * 0.125f / DEPTH, 0.9f, 0.6f))
              g.setStroke(new BasicStroke(depth))
              g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
              g.drawLine(x1, y1, x2, y2)

              draw(x2, y2, angle - 20, depth - 1)
              draw(x2, y2, angle + 20, depth - 1)
            }
          }
        }
    }
  }
}
