import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPostOrder {

    class BiHolder{

        
        public BiHolder(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        }

        public TreeNode node;
        public int count=0;


    }

    public static void main(String[] args) {
        new PreInPostOrder();
    }

    PreInPostOrder(){
        
        BST bst = new BST();
       
        bst.root= bst.buildTree(bst.root);

        preinpostOrderTraversalIterativeTwoStack(bst.root);


    }

   

    public void preinpostOrderTraversalIterativeTwoStack(TreeNode node){
       Stack<BiHolder> stack = new Stack<>();

       List<TreeNode> preOrder = new ArrayList<>();
       List<TreeNode> inOrder = new ArrayList<>();
       List<TreeNode> postOrder = new ArrayList<>();


       stack.push(new BiHolder(node, 1));
       
       while(!stack.isEmpty()){
        BiHolder holder = stack.peek();
        
        if(holder.count ==1){
            holder.count++;
           // stack.push(holder);
            if(holder.node.lNode != null) 
            stack.push(new BiHolder(holder.node.lNode, 1));
            preOrder.add(holder.node);
        }
        else if(holder.count==2){
            holder.count++;
            //stack.push(holder);
            if(holder.node.lNode != null) 
            stack.push(new BiHolder(holder.node.rNode, 1));
            inOrder.add(holder.node);
        }
        else if(holder.count==3){
            
            postOrder.add(stack.pop().node);
        }
       }
       System.out.println("Preorder =>"+preOrder);
       System.out.println("Ineorder =>"+inOrder);
       System.out.println("Postorder =>"+postOrder);
    }

   
}
