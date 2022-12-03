import java.io.File
import java.io.InputStream

// Searching for the sum of the loads of the 3 elfs with the 3 heaviest loads

val inputStream: InputStream = File("input-01.txt").inputStream();
val heaviestLoad = IntArray(3);
var currentLoad = 0;
var top3Load = 0;

inputStream.bufferedReader().forEachLine{
    if (it != "")
    {
        currentLoad += it.toInt();
    }
    else
    {
        for (i in 0..2) {
            if (currentLoad > heaviestLoad[i]) {
                var temp = heaviestLoad[i];
                heaviestLoad[i] = currentLoad;
                currentLoad = temp;
            }
        }
        currentLoad = 0;
    }
}

for (i in 0..2)
{
    top3Load += heaviestLoad[i];
    println("top"+(i+1)+". "+heaviestLoad[i]);
}

println("Total load of top 3: "+top3Load);