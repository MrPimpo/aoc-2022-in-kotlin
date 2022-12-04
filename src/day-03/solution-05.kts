import java.io.File
import java.io.InputStream

fun getItemPriority(char: Char): Int
{
    val c = char.toInt();
    //println(c);
    when (c) {
        in 65..90 -> return (c-38);
        in 97..122 -> return (c-96);
        else -> return (-1);
    }
}

// Checking errors in storing items inside rucksacks

val inputStream: InputStream = File("input.txt").inputStream()
var itemPrioritySum = 0;

inputStream.bufferedReader().forEachLine{
    val ch = it.toCharArray();
    val length = it.length;

    check@for (i in 0..(length/2)-1)
    {
        for (j in length/2..length-1)
            if (ch[i] == ch[j]) {
                itemPrioritySum += getItemPriority(ch[i]);
                break@check;
            }
    }
}
println(itemPrioritySum);