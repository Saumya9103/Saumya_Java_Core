package Assignment2;

interface Readable {
    void read();
}

interface Writable {
    void write();
}

interface ReadableWritable extends Readable, Writable {
}

class Document implements ReadableWritable {

    public void read() {
        System.out.println("Reading Document...");
    }

    public void write() {
        System.out.println("Writing Document...");
    }
}

public class Q16 {

    public static void main(String[] args) {

        Document doc = new Document();

        doc.read();
        doc.write();
    }
}