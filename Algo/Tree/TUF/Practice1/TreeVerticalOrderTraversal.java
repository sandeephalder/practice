import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeVerticalOrderTraversal {
    public static void main(String[] args) {
        new TreeVerticalOrderTraversal();
    }

    TreeVerticalOrderTraversal(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);
        bst.root.lNode.lNode= bst.insertLeft(bst.root.lNode.lNode,9);
        //bst.root.lNode.lNode.rNode= bst.insertRight(bst.root.lNode.lNode.rNode,19);
        Map<Integer,List<TreeNode>> spaceMatrix = new HashMap<>();
        verticalOrderTraversal(bst.root,0,0,spaceMatrix);
        System.out.println(spaceMatrix);
    }



    public void verticalOrderTraversal(TreeNode root,int level,int verticalLevel,Map<Integer,List<TreeNode>> spaceMatrix){
        if(root == null)
        return ;
       if(!spaceMatrix.containsKey(verticalLevel)){
          spaceMatrix.put(verticalLevel, new ArrayList<>());
       }
      
           spaceMatrix.get(verticalLevel).add(root);
       
       verticalOrderTraversal(root.lNode, level+1, verticalLevel+1, spaceMatrix);
       verticalOrderTraversal(root.rNode, level+1, verticalLevel-1, spaceMatrix);
       return ;
    }

   
   
}
