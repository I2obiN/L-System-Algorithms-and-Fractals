//  TODO: Write some awesome Swift code, or import libraries like "Foundation",
//  "Dispatch", or "Glibc"

    /**
    * Created by I2obiN on 29/01/16.
    */

    var heavy1: String = " ▒▒▒ ▒▒▒  ▒▒ ▒▒";
    var light2: String = "  ░  ░  ░ ░ ░ ░";
    var light3: String = "  ░  ░░░  ░ ░ ░";
    var light4: String = "  ░  ░  ░ ░ ░ ░";
    var heavy5: String = " ░░░ ░░░  ░   ░";
    
    var array: [String] = [heavy1, light2, light3, light4, heavy5];
    
    for string in array {
        print(string+" "+string+" "+string+" "+string+" "+string);
    }
