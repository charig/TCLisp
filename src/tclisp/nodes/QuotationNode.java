package tclisp.nodes;

public abstract class QuotationNode extends LiteralNode {

	public QuotationNode(TCLispNode node){
		
	}
	
	@Override
	public Object getValue() {
		return null;
	}

}
