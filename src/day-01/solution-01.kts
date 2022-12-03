import java.io.File
import java.io.InputStream

// Searching for the load of the elf with the heaviest load

val inputStream: InputStream = File("input.txt").inputStream()
var heaviestLoad = 0;
var currentLoad = 0;

inputStream.bufferedReader().forEachLine{
    if (it!="")
    {
        currentLoad+=it.toInt();
    }
    else
    {
        if (currentLoad>heaviestLoad)
            heaviestLoad=currentLoad;
        currentLoad=0;
    }
}
println(heaviestLoad);