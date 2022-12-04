import java.io.File
import java.io.InputStream

fun getCommonItems(chars1: ArrayList<Char>, chars2: ArrayList<Char>): ArrayList<Char>
{
    var result: ArrayList<Char> = arrayListOf<Char>();
    for (i in chars1.indices)
    {
        for (j in chars2.indices)
            if (chars1[i] == chars2[j]) {
                result.add(chars1[i]);
                break;
            }
    }
    return (result);
}

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

// Searching for elves' badges inside their rucksacks

val inputStream: InputStream = File("input.txt").inputStream()
var group:ArrayList<String> = arrayListOf<String>();
var itemPrioritySum = 0;

inputStream.bufferedReader().forEachLine{
    group.add(it);

    if (group.size == 3)
    {
        val elfA = group[0].toCharArray().toCollection(ArrayList());
        val elfB = group[1].toCharArray().toCollection(ArrayList());
        val elfC = group[2].toCharArray().toCollection(ArrayList());

        val AnB = getCommonItems(elfA, elfB);
        val BnC = getCommonItems(elfB, elfC);
        val result = getCommonItems(AnB,BnC);

        itemPrioritySum += getItemPriority(result[0]);
        group.clear();
    }
}
println(itemPrioritySum);