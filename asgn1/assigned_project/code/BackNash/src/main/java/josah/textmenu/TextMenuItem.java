package main.java.josah.textmenu;

/*
 * This code is taken from: http://bytes.com/topic/java/insights/870013-text-based-menus
 * Accessed 9/24/2014
 * I do not claim any ownership or copyright.
 */

public class TextMenuItem implements Runnable {
 
    private String title;
    private Runnable exec;
 
    protected TextMenuItem(String title) { this(title, null); }
 
    public TextMenuItem(String title, Runnable exec) {
        this.title= title;
        this.exec= exec;
    }
 
    public String getTitle() { return title; }
 
    public boolean isExec() { return exec != null; }
 
    protected void setExec(Runnable exec) { this.exec= exec; }
 
    public void run() {
 
        try {
            exec.run();
        }
        catch (Throwable t) {
            t.printStackTrace(System.err);
        }
    }
}
 