package io.czipperz.github.cLibrary.bash;

/**
 * @author czipperz on 4/8/15.
 */
public interface CBash {
    public CBash out(s);
    public default CBash outln(s) {
        out(s);
        out("\n");
    }
    public default CBash outln()    { return out("\n");      }
    public CBash flush();
    public CBash setBold(boolean b);
    public default CBash setBold()  { return setBold(true);  }
    public default CBash setUBold() { return setBold(false); }
}
