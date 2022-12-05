import java.io.File
import java.io.InputStream

// Moving the crates v.2

val inputStream: InputStream = File("input.txt").inputStream()
var instructionsStarted = false;
var rows = arrayListOf<ArrayList<Char>>();

inputStream.bufferedReader().forEachLine{
    if (!it.isEmpty())
    {
        if (!instructionsStarted)
        {
            val str = it.chunked(4);
            for (i in 0..str.size-1)
            {
                if (rows.size<i+1)
                    rows.add(arrayListOf<Char>());
                val s = str[i].toCharArray();
                when (s[1]) { in 'A'..'Z' -> rows[i].add(s[1]); }
            }
        }
        else {
            val s1 = it.indexOf("move");
            val s2 = it.indexOf(" from");
            val s3 = it.indexOf(" to");

            val repeatVal = it.subSequence(s1 + 5, s2).toString().toInt();
            val pos1 = it.subSequence(s2 + 6, s3).toString().toInt() - 1;
            val pos2 = it.subSequence(s3 + 4, it.length).toString().toInt() - 1;

            val stack1 = rows[pos1];
            val stack2 = rows[pos2];
            val temp = arrayListOf<Char>();
            repeat (repeatVal)
            {
                val ch = stack1.last();
                stack1.removeAt(stack1.size - 1);
                temp.add(ch);
            }
            repeat (repeatVal)
            {
                val ch = temp.last();
                temp.removeAt(temp.size - 1);
                stack2.add(ch);
            }
        }
    }
    else
    {
        instructionsStarted = true;
        for (i in 0..rows.size-1)
            rows[i].reverse();
    }
}

for (r in rows)
    print(r[r.size-1]);
