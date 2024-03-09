import java.util.HashMap;
import java.util.Map;

public class RightViewTree {
    public static void main(String[] args) {
        new RightViewTree();
    }

    RightViewTree(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);
        bst.root.lNode.lNode= bst.insertRight(bst.root.lNode.lNode,9);
        bst.root.lNode.lNode= bst.insertRight(bst.root.lNode.lNode,19);
        Map<Integer,TreeNode> spaceMatrix = new HashMap<>();
        treeRightView(bst.root,0,0,spaceMatrix);
        System.out.println(spaceMatrix);
    }



    public void treeRightView(TreeNode root,int level,int verticalLevel,Map<Integer,TreeNode> spaceMatrix){
        if(root == null)
        return ;
       
       if(!spaceMatrix.containsKey(level)) spaceMatrix.put(level, root);
       treeRightView(root.rNode, level+1, verticalLevel-1, spaceMatrix);
       treeRightView(root.lNode, level+1, verticalLevel+1, spaceMatrix);
       return ;
    }
}
