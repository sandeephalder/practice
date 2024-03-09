import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    
    public static void main(String[] args) {
        new RootToNodePath();
    }

    RootToNodePath(){
        
        BST bst = new BST();
        //for(int i : arr) 
        bst.root= bst.buildTree(bst.root);
        bst.root.lNode.lNode= bst.insertLeft(bst.root.lNode.lNode,9);
        bst.root.lNode.lNode.rNode= bst.insertRight(bst.root.lNode.lNode.rNode,19);
        List<TreeNode> path = new ArrayList<>();
        rootNodepath(bst.root,19,path);
        System.out.println(path);
    }



    public boolean rootNodepath(TreeNode root,int target,List<TreeNode> path){
        if(root == null)
        return false;
      path.add(root);
      if(root.data==target) return true;
      boolean lNode = rootNodepath(root.lNode, target, path);
      boolean rNode = rootNodepath(root.rNode, target, path);
      if(!lNode && !rNode) {
        path.remove(path.size()-1);
      }
       return lNode || rNode;
    }

}
