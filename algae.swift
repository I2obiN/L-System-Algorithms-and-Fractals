
/**
  * Created by I2obiN on 26/01/16
  * L-System Algae
  *
  */

  import Foundation
  
  func stringmap(x: String) -> String {
  var str = x;
    print(x.stringByReplacingOccurrencesOfString("A", withString: "AB"));
    str = x.stringByReplacingOccurrencesOfString("A", withString: "AB")
    + x.stringByReplacingOccurrencesOfString("B", withString: "A");
    // Return mapped string;
    return str;
  }

  func lsys() {
    var iteration : Int = 2;
    var x = 0;
    var lsystem: String = "A";
    let charA: Character = "A";
    let charB: Character = "B";

    // Run through iterations, O(n^2)
    while(x != iteration) {
      // Print current generation
      print(lsystem)
      
      // Get next gen ..
      lsystem = stringmap(lsystem);

      // Iterate ..
      x+=1
    }
  }
  
    // Run ..
    lsys();


