import java.io.File
import java.io.InputStream

// Checking elf's "rock-paper-scissors" strategy

val inputStream: InputStream = File("input.txt").inputStream()
var totalPoints = 0;

inputStream.bufferedReader().forEachLine{
    val ch = it.toCharArray();

    when (ch[2]) { // shape points
        'X'->totalPoints += 1 ;
        'Y'->totalPoints += 2 ;
        'Z'->totalPoints += 3 ;
    }

    if (ch[0] == ch[2]-23)
        totalPoints += 3; // draw points
    else if (((ch[0] == 'A') && (ch[2] == 'Y'))
            || ((ch[0] == 'B') && (ch[2] == 'Z'))
            || ((ch[0] == 'C') && (ch[2] == 'X')))
        totalPoints += 6; // win points

}
println(totalPoints);