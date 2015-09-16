package tclisp.nodes;

public abstract class LiteralNode extends TCLispNode {
	public Object execute(){
		return this.getValue();
	}
	
	public abstract Object getValue();
}
