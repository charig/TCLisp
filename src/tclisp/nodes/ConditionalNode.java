package tclisp.nodes;

public abstract class ConditionalNode extends TCLispNode {
	@Child TCLispNode clause;
	@Child TCLispNode trueAlternative;
	@Child TCLispNode falseAlternative;
}
