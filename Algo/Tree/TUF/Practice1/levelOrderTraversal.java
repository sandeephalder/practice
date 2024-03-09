import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {
    int[] arr = {1,2,7,3,4,5,6};
    public static void main(String[] args) {
        new levelOrderTraversal();
    }

    levelOrderTraversal(){
        
        BST bst = new BST();
      
        bst.root= bst.buildTree(bst.root);

        levelOrderTraversalIterative(bst.root);


    }


    public void levelOrderTraversalIterative(TreeNode node){
        if(node == null)
        return;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levels = new LinkedList<List<Integer>>(); 
        queue.offer(node);
        int levelNum=0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelStore = new LinkedList<>(); 
            levelNum++;
            for(int i=0;i<levelSize;i++){
            TreeNode temp = queue.poll();
            levelStore.add(temp.data);
            if(temp.rNode != null) queue.offer(temp.rNode);
            if(temp.lNode != null) queue.offer(temp.lNode); 
            }
            levels.add(levelStore);
        }
        System.out.print(levels);
    }
}
