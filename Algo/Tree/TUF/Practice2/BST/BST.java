package BST;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BST {
    Stack<BstNode> increasing = new Stack<>();
    Stack<BstNode> decreasing = new Stack<>();
    public static void main(String[] args) {
        new BST();
    }

    BST(){
        BstNode root=null,customRoot=null;
        root = buildTree(root);
        //System.out.println(search(root,12));
        //System.out.println(ceil(root,11,Integer.MAX_VALUE));
        //System.out.println(floor(root,11));
        //root = delete(root, 12);
        //preOrder(root);
        //System.out.println();
        //inOrder(root);
        //System.out.println(isValidBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        //System.out.println(lca(root, 14, 13));
        //int[] preOrder = {8,5,4,7,6,12,10,14,13};
        //customRoot = buildTreeFromPreorder(customRoot, preOrder);
        //customRoot=  buildTreeFromPreorder(customRoot, preOrder);
        //preOrder(customRoot);
        //System.out.println(" Forward Iterator ");
        //initForwardIterator(root);
        //while(hasNextForwardIterator()) System.out.println(nextForwardIterator());
        //System.out.println(" BackWord Iterator ");
        //initBackWordIterator(root);
        //while(hasNextBackWordIterator()) System.out.println(nextBackWordIterator());
        //System.out.println(twoSum(root,9));
        
    }

    public boolean twoSum(BstNode root,int sum){
       
        initForwardIterator(root);
        initBackWordIterator(root);
       
        while(true){
            int calculatedsum =  nextBackWordIterator().key + nextForwardIterator().key;
            if(calculatedsum < sum){
                if(hasNextForwardIterator()) nextForwardIterator();
                else return false;
            }
            else if(calculatedsum < sum){
                if(hasNextBackWordIterator()) nextBackWordIterator();
                else return false;
            }
            else return true;
        }
    }

    public BstNode initForwardIterator(BstNode node){
        while(node!=null){
            increasing.push(node);
            node = node.lNode;
        }
        return node;
    }

    public boolean hasNextForwardIterator(){
        return !increasing.isEmpty();
    }

    public BstNode nextForwardIterator(){
       
        BstNode node = increasing.pop();
        if(node.rNode!=null) {
            BstNode rNode= node.rNode;
            while(rNode!=null){
                increasing.push(rNode);
                rNode = rNode.lNode;
            }
        }
        return node;
    }

    public BstNode initBackWordIterator(BstNode node){
        while(node!=null){
            increasing.push(node);
            node = node.rNode;
        }
        return node;
    }

    public boolean hasNextBackWordIterator(){
        return !increasing.isEmpty();
    }

    public BstNode nextBackWordIterator(){
       
        BstNode node = increasing.pop();
        if(node.lNode!=null) {
            BstNode lNode= node.lNode;
            while(lNode!=null){
                increasing.push(lNode);
                lNode = lNode.lNode;
            }
        }
        return node;
    }

    
    public BstNode buildTree(BstNode root){
        root = insert(root, 8, 8);
        root = insert(root, 5, 5);
        root = insert(root, 12, 12);
        root = insert(root, 4, 4);
        root = insert(root, 7, 7);
        root = insert(root, 6, 6);
        root = insert(root, 10, 10);
        root = insert(root, 14, 14);
        root = insert(root, 13, 13);
        return root;
    }

    public BstNode buildTreeFromPreorder(BstNode root,int[] preOrder){
        if(root == null && preOrder.length >=1) root= new BstNode(preOrder[0], preOrder[0]);
        if(preOrder.length==1) return new BstNode(preOrder[0], preOrder[0]);
        if(preOrder.length<1) return null;
        int index = findIndex(preOrder, preOrder[0]);
        //System.out.println("Index"+index);
        int[] left_preOrder = Arrays.copyOfRange(preOrder, 1, index);
        int[] right_preOrder = Arrays.copyOfRange(preOrder, index, preOrder.length);

        root.lNode = buildTreeFromPreorder(root.lNode, left_preOrder);
        root.rNode = buildTreeFromPreorder(root.rNode, right_preOrder);
        return root;
    }

    private int findIndex(int[] preOrder,int partition){
        for(int i=0;i<preOrder.length;i++) if(preOrder[i]> partition) return i;
        return preOrder.length-1;
    }

    private BstNode insert(BstNode root,int key,int value){
        if(root == null) return new BstNode(key,value);

        if(key < root.key) root.lNode = insert(root.lNode, key, value);
        else if(key > root.key) root.rNode = insert(root.rNode, key, value);
        else root.value= value;
        return root;
    }

    private BstNode search(BstNode root,int key){
        if(root == null) return root;
        BstNode l=null,r=null;
        if(key < root.key) {l = search(root.lNode, key);}
        else if(key > root.key) {r = search(root.rNode, key);}
        else return root;

        if( l != null) return l;
        else  return r;
        

    }

    public BstNode lca(BstNode root,int start,int end){
        if(root ==null) return root;

        BstNode l=null,r=null;
        if(start < root.key && end < root.key) l= lca(root.lNode, start, end);
        else  if(start > root.key && end > root.key) r = lca(root.rNode, start, end);
        else if(start == root.key || end == root.key) return root;
        else return root;
         
        if(l==null) return r;
        else return l;
    }

    public boolean isValidBinaryTree(BstNode root,int start,int end){
        if(root == null) return true;

        if(start >root.value  || root.value > end) return false;

        boolean l = isValidBinaryTree(root.lNode, start, root.value);
        boolean r = isValidBinaryTree(root.rNode, root.value, end);

        return l && r;
    }


    private BstNode delete(BstNode root,int key){
        if(root == null) return root;

        if(key < root.key) {root.lNode = delete(root.lNode, key);}
        else if(key > root.key) {root.rNode = delete(root.rNode, key);}
        else {
            if(root.lNode==null) return root.rNode;
            else if(root.rNode==null) return root.lNode;
            else{
                BstNode node = root.lNode;
                while(node.rNode!=null) {
                    node = node.rNode;
                }
                node.rNode = root.rNode;
                return root.lNode;
            } 

           
        }

     return root;
        

    }

    private Integer floor(BstNode root,int key){
        int floor = 1;

        while(root!=null){
            if(root.key == key) return key;
            else if(key < root.key) {
                root= root.lNode;
            }
            else{
                floor = root.key;
                root = root.rNode;
                
            }
        }
        return floor;
    }

    private Integer ceil(BstNode root,int key,int ceilVal){
        if(root == null ) return ceilVal;
        
        Integer l=Integer.MAX_VALUE,r=Integer.MAX_VALUE;
        if(key > root.key) {r = ceil(root.rNode, key,ceilVal);}
        else if(key < root.key) { ceilVal = ceilVal>root.key?root.key:ceilVal; l = ceil(root.lNode, key,ceilVal);}
        else return root.key;

        return Math.min(l,r);
    }


    private void levelOrder(BstNode root){
        if(root == null) return;

        Queue<BstNode> queue = new LinkedList();

        System.out.println(root.getValue());
        queue.offer(root);
        List<Integer> list;
        while(!queue.isEmpty()){
            int size = queue.size();
            list = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                BstNode node = queue.poll();
                list.add(node.value);
                if(node.getlNode()!=null) queue.offer(node.getlNode());
                if(node.getrNode()!=null) queue.offer(node.getrNode());
            }
            System.out.println(list);
        }

    }

    private void preOrder(BstNode root){
        if(root == null) return;

        System.out.print("==>"+root.getValue());
        preOrder(root.getlNode());
        preOrder(root.getrNode());
    }

    private void inOrder(BstNode root){
        if(root == null) return;

        
        inOrder(root.getlNode());
        System.out.print("==>"+root.getValue());
        inOrder(root.getrNode());
    }

    private void postOrder(BstNode root){
        if(root == null) return;

        
        postOrder(root.getlNode());
        postOrder(root.getrNode());
        System.out.print("==>"+root.getValue()); 
    }
}
