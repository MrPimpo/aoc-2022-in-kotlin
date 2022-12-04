import java.io.File
import java.io.InputStream

// Looking for cleaning sections that overlap with one another

val inputStream: InputStream = File("input.txt").inputStream()
var sumOfFullyContained = 0;

inputStream.bufferedReader().forEachLine{
    val commaPlace = it.indexOf(',');

    val sector1 = it.subSequence(0, commaPlace);
    var dashPlace = sector1.indexOf('-');
    val elf1start = sector1.subSequence(0, dashPlace).toString().toInt();
    val elf1end = sector1.subSequence(dashPlace+1, sector1.length).toString().toInt();

    val sector2 = it.subSequence(commaPlace+1, it.length);
    dashPlace = sector2.indexOf('-');
    val elf2start = sector2.subSequence(0, dashPlace).toString().toInt();
    val elf2end = sector2.subSequence(dashPlace+1, sector2.length).toString().toInt();

    print(it);
    if ((elf1end >= elf2start)&&(elf1start <= elf2end)) {
        sumOfFullyContained++;
        println(" overlap.")
    }
    else
        println();
}
println(sumOfFullyContained);