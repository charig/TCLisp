package tclisp.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

@SuppressWarnings("deprecation")
public abstract class LambdaNode extends RootNode {
	@Child TCLispNode body;
	
	@Override
	public Object execute(VirtualFrame frame) {
		// TODO Auto-generated method stub
		return null;
	}

}
