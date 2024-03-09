import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraverse {
    
    public static void main(String[] args) {
        new ZigZagTraverse();
    }

    ZigZagTraverse(){
        
        BST bst1 = new BST();

        bst1.root= bst1.buildTree(bst1.root);


        bst1.root.lNode.lNode= bst1.insertLeft(bst1.root.lNode.lNode,9);
        bst1.root.lNode.rNode= bst1.insertLeft(bst1.root.lNode.rNode,10);
     
        zigzagTraverse(bst1.root);
    }

    public void zigzagTraverse(TreeNode node){
      if(node ==null ) return;
      List<List<TreeNode>> levels = new LinkedList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(node);
      boolean isReverse=true;
      while(!queue.isEmpty()){
        int levelNumber = queue.size();
        List<TreeNode> currentLevelNodes = new LinkedList<>();
        for(int i=0;i<levelNumber;i++){
            TreeNode currentNode = queue.poll();
            if(currentNode.lNode!=null) queue.offer(currentNode.lNode);
            if(currentNode.rNode!=null) queue.offer(currentNode.rNode);
            currentLevelNodes.add(currentNode);
        }
        if(isReverse)
            currentLevelNodes = reverseList(currentLevelNodes);
           
        isReverse=!isReverse;
        levels.add(currentLevelNodes);
      }

      System.out.println(levels);
      
    }

    private List<TreeNode> reverseList(List<TreeNode> list){
        List<TreeNode> reverseList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        for(TreeNode node:list) stack.push(node);
        while(!stack.isEmpty()) reverseList.add(stack.pop());
        return reverseList;
    }
}
