package tclisp.objects;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.object.Layout;
import com.oracle.truffle.object.basic.DynamicObjectBasic;

public class TCLispObject {
	 @CompilationFinal private DynamicObject dynamicObject;
	  
	  public static final Layout LAYOUT = Layout.createLayout(Layout.INT_TO_LONG);
	  
	  protected TCLispObject() {
	    dynamicObject  = new DynamicObjectBasic(LAYOUT.createShape(new LispObjectType()));
	  }
}
