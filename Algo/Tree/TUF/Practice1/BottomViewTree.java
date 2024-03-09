import java.util.HashMap;
import java.util.Map;

public class BottomViewTree {
    public static void main(String[] args) {
        new BottomViewTree();
    }

    BottomViewTree(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);
        bst.root.lNode.lNode= bst.insertRight(bst.root.lNode.lNode,9);
        //bst.root.lNode.lNode.rNode= bst.insertRight(bst.root.lNode.lNode.rNode,19);
        Map<Integer,Map<Integer,TreeNode>> spaceMatrix = new HashMap<>();
        treeBottomView(bst.root,0,0,spaceMatrix);
        System.out.println(spaceMatrix);
    }



    public void treeBottomView(TreeNode root,int level,int verticalLevel,Map<Integer,Map<Integer,TreeNode>> spaceMatrix){
        if(root == null)
        return ;
        treeBottomView(root.lNode, level+1, verticalLevel+1, spaceMatrix);
       if(!spaceMatrix.containsKey(verticalLevel)){
          spaceMatrix.put(verticalLevel, new HashMap<>());
          spaceMatrix.get(verticalLevel).put(level, root);
       }
       else{
           int max=0;
           for(int i:spaceMatrix.get(verticalLevel).keySet()){
            max = Math.max(max,i);
           }
           if(level>max) {
               spaceMatrix.get(verticalLevel).remove(max);
               spaceMatrix.get(verticalLevel).put(level, root);
           }
       }
       
       
       
       treeBottomView(root.rNode, level+1, verticalLevel-1, spaceMatrix);
       return ;
    }
}
