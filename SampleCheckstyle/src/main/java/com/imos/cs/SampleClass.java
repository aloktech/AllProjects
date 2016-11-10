
package com.imos.cs;

/**
 *
 * @author alok
 */
public final class SampleClass implements Sample {

    /**
     * Unused Constructor.
     */
    private SampleClass() {
    }

    /**
     * Sample.
     * @param args
     */
    public static void main(final String[] args) {
        boolean status1 = true, status2 = true, status3 = true, status4 = true;
        if (status1) {
            if (status2) {
                if (status3) {
                    if (status4) {
                        System.out.println("X");
                    } else {
                        System.out.println("Y");
                    }
                } else {
                    System.out.println("Z");
                }
            } else {
                System.out.println("W");
            }
        } else {
            System.out.println("T");
        }
        System.out.println("done");
        System.out.println("done");
        System.out.println("done");
    }

    /**
     * change.
     */
    @Override
    public void change() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
