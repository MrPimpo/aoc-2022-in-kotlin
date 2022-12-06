import java.io.File
import java.io.InputStream

// device tuning / searching for a start-of-message marker

val inputStream: InputStream = File("input.txt").inputStream()
val last14 = arrayListOf<Char>();
var processed = 0;
var found = false;

val buffer = inputStream.bufferedReader().forEachLine {
    val line = it.toCharArray();
    if (!found) {
        search@ for (c in line) {
            last14.add(c);
            processed++;

            if (last14.size > 14)
                last14.removeAt(0);

            if (last14.size == 14) {
                var noRepeats = true;
                repetitionCheck@ for (i in 0..last14.size - 1) {
                    for (j in 0..last14.size - 1) {
                        if ((i != j) && (last14[i] == last14[j])) {
                            noRepeats = false;
                            break@repetitionCheck
                        };
                    }
                }

                if (noRepeats) {
                    found = true;
                    break@search;
                }
            }
        }
    }
}
println(processed);