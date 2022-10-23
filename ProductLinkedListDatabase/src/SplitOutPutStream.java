import java.io.*;

public class SplitOutPutStream extends OutputStream{
    OutputStream o1;
    OutputStream o2;
    //Constructor
    public SplitOutPutStream(OutputStream o1,OutputStream o2){
        this.o1=o1;
        this.o2=o2;
    }

    /**
     * Write number to both 2 OutputStream type
     * @param b   number need to write
     * @throws IOException
     */
    @Override public void write(int b) throws IOException{
        o1.write(b);
        o2.write(b);
    }

    /**
     * Write byte to both 2 OutputStream type
     * @param b     the data.
     * @param off   the start offset in the data.
     * @param len   the number of bytes to write.
     * @throws IOException
     */
    @Override public void write(byte[] b,int off,int len) throws IOException{
        o1.write(b,off,len);
        o2.write(b,off,len);
    }

    //Flush OutputStream
    @Override public void flush() throws IOException{
        o1.flush();
        o2.flush();
    }//Close OutputStream
    @Override public void close() throws IOException{
        o1.close();
        o2.close();
    }
}