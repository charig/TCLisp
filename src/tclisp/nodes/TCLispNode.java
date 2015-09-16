package tclisp.nodes;

import tclisp.types.Types;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;

@TypeSystemReference(Types.class)
@NodeInfo(language = "TCLisp Language", description = "The abstract base node for all expressions")
public class TCLispNode extends Node {

}
