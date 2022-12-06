import java.io.File
import java.io.InputStream

// device tuning / searching for a start-of-package marker

val inputStream: InputStream = File("input.txt").inputStream()
val last4 = arrayListOf<Char>();
var processed = 0;
var found = false;

val buffer = inputStream.bufferedReader().forEachLine {
    val line = it.toCharArray();
    if (!found) {
        search@ for (c in line) {
            last4.add(c);
            processed++;

            if (last4.size > 4)
                last4.removeAt(0);

            if (last4.size == 4) {
                var noRepeats = true;
                repetitionCheck@ for (i in 0..last4.size - 1) {
                    for (j in 0..last4.size - 1) {
                        if ((i != j) && (last4[i] == last4[j])) {
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