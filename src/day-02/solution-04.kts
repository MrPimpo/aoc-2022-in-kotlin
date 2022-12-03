import java.io.File
import java.io.InputStream

// Checking "rock-paper-scissors" strategy that the elf truly meant

val inputStream: InputStream = File("input.txt").inputStream()
var totalPoints = 0;

inputStream.bufferedReader().forEachLine{
    val ch = it.toCharArray();

    var points = 0;
    when (ch[0]) // shape points
    {
        'A' -> points = 0;
        'B' -> points = 1;
        'C' -> points = 2;
    }

    when (ch[2]) {
        'X'-> totalPoints += ((points+2) % 3) +1; // loose points
        'Y'->totalPoints += 3 + points + 1 ; // draw points
        'Z'->totalPoints += 6 + ((points+1) % 3) + 1; // win points
    }
}
println(totalPoints);