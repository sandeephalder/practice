import java.util.HashMap;
import java.util.Map;

public class TreeTopView {
    public static void main(String[] args) {
        new TreeTopView();
    }

    TreeTopView(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);
        bst.root.lNode.lNode= bst.insertRight(bst.root.lNode.lNode,9);
        bst.root.lNode.lNode.rNode= bst.insertRight(bst.root.lNode.lNode.rNode,19);
        Map<Integer,Map<Integer,TreeNode>> spaceMatrix = new HashMap<>();
        treeTopView(bst.root,0,0,spaceMatrix);
        System.out.println(spaceMatrix);
    }



    public void treeTopView(TreeNode root,int level,int verticalLevel,Map<Integer,Map<Integer,TreeNode>> spaceMatrix){
        if(root == null)
        return ;

       if(!spaceMatrix.containsKey(verticalLevel)){
          spaceMatrix.put(verticalLevel, new HashMap<>());
          spaceMatrix.get(verticalLevel).put(level, root);
       }
       
           treeTopView(root.lNode, level+1, verticalLevel+1, spaceMatrix);
           treeTopView(root.rNode, level+1, verticalLevel-1, spaceMatrix);
       return ;
    }

}
