package io.czipperz.github.cLibrary.bash;

/**
 * This class models the System.{out|err} objects by switching between them using {@link CBashSystem#setBold(boolean)}
 * @author czipperz on 4/18/15.
 */
public class CBashSystem implements CBash {
    private boolean bool = false;

    public synchronized CBash out(Object s) {
        if(bool) System.err.print(s);
        else     System.out.print(s);
        return this;
    }

    public CBash flush() {
        System.err.flush();
        System.out.flush();
        return this;
    }

    public synchronized CBash setBold(boolean b) {
        bool = b;
        return flush();
    }
}
