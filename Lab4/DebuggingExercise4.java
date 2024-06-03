class DebuggingExercise4 {
    public static void main(String[] args) {
        Account a = new Account(null);
        a.deposit(100);
        System.out.println(a.getOwner() + " has $" + a.getBalance());
        a.withdraw(200);
        System.out.println("After trying to withdraw $200, " + a.getOwner() + " has $" + a.getBalance());
    }
}
/*
 * 2.2: Where is the variable watch window on your screen? What information does this present to you? Describe this in comments in your code.
 * Where is the method call stack on your screen? What information does this describe?
 * 
 * The variable watch window is on the left of the IDE's code construction window.
 * The method call stack is on the lower left hand side of the screen. It seems to describe the inner processes of how this code block is handled, like where time would actually be calculated.
 * 
 * Step Over: What does this do?
 *  Takes you to the next line of code further from the breakpoint.
 * Step Into: What does this do? How is it different from step over?
 *  Seems like, for right now, it takes me to the inner-built Thread.class, to the method System.exit(). I'm assuming that's because that's where it does exit.
 * Step Out: What does this do? How is it different from step over or step into?
 *  It took me out of my breakpoint, but my assumption is it might move on to the next breakpoint in the code.
 * Continue: What does this do? How is it different than moving in steps?
 *  It runs the entire program for me. Step Out would be better in general for running multiple lines, but Continue might be easier for traversing large sections of code.
 */