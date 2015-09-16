package tclisp.vm;

import java.util.HashMap;

import tclisp.objects.TCLSymbol;
import tclisp.objects.TCLispObject;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleRuntime;

public class Universe {
	
	public static void main(final String[] arguments) {
	    Universe u = current();
	
	    try {
	      //u.interpret(arguments);
	    	u.interpret("a");
	      u.exit(0);
	    } catch (IllegalStateException e) {
	      errorExit(e.getMessage());
	    }
	}
	
	/*public Object interpret(String[] arguments) {
	    // Check for command line switches
	    //arguments = handleArguments(arguments);
		arguments = null;
	    // Initialize the known universe
	    return execute(arguments);
	}*/
	
	public Object interpret(final String function) {
	    //initializeObjectSystem();
	
	    //SClass clazz = loadClass(symbolFor(className));
	
	    // Lookup the initialize invokable on the system class
	    //SInvokable initialize = clazz.getSOMClass().lookupInvokable(
	        //symbolFor(selector));
	    //return initialize.invoke(clazz);
		return null;
	}
	
	/*private Object execute(final String[] arguments) {
	    initializeObjectSystem();

	    // Start the shell if no filename is given
	    if (arguments.length == 0) {
	      Shell shell = new Shell(this);
	      return shell.start();
	    }

	    // Lookup the initialize invokable on the system class
	    SInvokable initialize = systemClass.
	        lookupInvokable(symbolFor("initialize:"));

	    return initialize.invoke(new Object[] {systemObject,
	        SArray.create(arguments)});
	}*/
	
	protected Universe() {
	    this.truffleRuntime = Truffle.getRuntime();
	    this.globals      = new HashMap<TCLSymbol, TCLispObject>();
	    this.symbolTable  = new HashMap<>();
	    this.avoidExit    = false;
	    //this.alreadyInitialized = false;
	    this.lastExitCode = 0;
	}
	
	public TruffleRuntime getTruffleRuntime() {
	    return truffleRuntime;
	}
	
	public void exit(final int errorCode) {
	    CompilerDirectives.transferToInterpreter();
	    // Exit from the Java system
	    if (!avoidExit) {
	      System.exit(errorCode);
	    } else {
	      lastExitCode = errorCode;
	    }
	}
	
	public static void errorExit(final String message) {
	    CompilerDirectives.transferToInterpreter();
	    println("Runtime Error: " + message);
	    current().exit(1);
	}

	
	public int lastExitCode() {
	    return lastExitCode;
	}
		
	public static Universe getCurrent(){
	    return current;
	}
	  
	public static void setCurrent(Universe universe){
	    current = universe;
	}
	  
	public static Universe current() {
	    if (current == null) {
	      current = new Universe();
	    }
	    return current;
	}
	
	@TruffleBoundary
	public static void println(final String msg) {
	    System.out.println(msg);
	}

	private final TruffleRuntime                   truffleRuntime;
	private final HashMap<String, TCLSymbol>       symbolTable;
	private final HashMap<TCLSymbol, TCLispObject> globals;
	@CompilationFinal private boolean              avoidExit;
	private int                                    lastExitCode;
	@CompilationFinal private static Universe 	   current;
}
