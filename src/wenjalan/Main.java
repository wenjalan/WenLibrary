package wenjalan;

import wenjalan.io.FastReader;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Timer timer = new Timer(Timer.Unit.MILLISECOND).start();

        FastReader reader = new FastReader(new RandomAccessFile(".gitattributes", "r").getChannel());
        while (reader.hasNext()) {
            System.out.print((char) reader.next());
        }

        System.out.println("Finished in " + timer.lap() + " ms");

        timer.reset();

        reader.

        BufferedReader br = new BufferedReader(new FileReader(".gitattributes"));
        String s = br.readLine();
        while (s != null) {
            System.out.println(s);
            s = br.readLine();
        }

        System.out.println("Finished in " + timer.lap() + " ms");
    }

}
