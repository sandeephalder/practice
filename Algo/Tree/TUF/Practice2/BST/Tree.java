package BST;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    class MixedNode{
        TreeNode node;
        int value;

        public MixedNode(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }

        
    }

    TreeNode root,root1,root3,customRoot;
    Tree(){
        buildTree();
       // System.out.println("PreOrder ==>");
       // preOrder(root);
     //   System.out.println("\nInOrder ==>");
       // inOrder(root);
        //postOrder(root);
        //levelOrder(root);
        //preOrderIterative(root);
        //inOrderIterative(root);
        //postOrderIterative(root);
        //System.out.println("Depth of Tree:"+depthOfTree(root));
        //pre_post_in_OrderIterativeSingleStack(root);
        //postOrderIterativeSingleStack(root);
        //System.out.println(" Check Balanced"+checkIfBalanced(root));
        /*int max[] = new int[1];
        diameterOfTree(root,max) ;
        System.out.println(" Diameter "+max[0]);
        max[0] = Integer.MIN_VALUE;
        maxPathOfTree(root, max);
        System.out.println(" Max path Sum "+max[0]);*/
        //buildIdenticalTree();
        //System.out.println(" Check identical tree: "+checkIfIdenticalTree(root,root1));
        buildBoundaryTree();
        //boundaryTraverse(root3);
        //Map<Integer,List<Integer>> map = new HashMap<>();
        //vertricalTraverse(root,map,0,0);
       // System.out.println(map);

      // topView(root3);
      // bottomView(root3);
      // System.out.println("Left View");
      // leftView(root3, 0,new ArrayList<>());
      // System.out.println("Right View");
      // rightView(root3, 0,new ArrayList<>());
      //List<TreeNode> path = new ArrayList<>();
      //rootToNodePath(root3, 6, path);
      //System.out.println("Root to Path"+path);
      //System.out.println(" LCA: "+lowestCommonAnsestor(root, 5, 4));
      //preOrder(root);
      //childrenSumproperty(root);
      //preOrder(root);
      //fillParentNode(root);
      //kDistance(root, 2, 1);
      //fillParentNode(root);
      //burnDistance(root,5);
       // countNodes(root3);
      //int[] preOrderList = {1,2,4,5,3,6,7};
      //int[] inOrderList = {4,2,5,1,6,3,7};
      //int[] postOrderList = {4,5,2,6,7,3,1};
      //customRoot = buildTreeFromPreInOrder(preOrderList, inOrderList, customRoot);
      //preOrder(customRoot);

       ///customRoot = buildTreeFromPostInOrder(postOrderList, inOrderList, customRoot);
       //postOrder(customRoot);

      // System.out.println(serealizeTree(root));
     /*   try {
        preOrder(deserealizeTree(serealizeTree(root)));
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }*/
     
    }

    public int getIndexinArray(int number,int[] arr){
        for(int i=0;i<arr.length;i++) if(arr[i]==number) return i;
        return -1;
    }

    public static void main(String[] args) {
        new Tree();
    }

    private TreeNode buildTreeFromPostInOrder(int[] postOrderList,int[] inOrderList,TreeNode root){

       

        if(postOrderList.length ==1 ) return new TreeNode(postOrderList[0]);

        if(inOrderList.length ==1 ) return new TreeNode(inOrderList[0]);

        if(root == null) root = new TreeNode(postOrderList[postOrderList.length-1]);
       
        int index  = getIndexinArray(postOrderList[postOrderList.length-1],inOrderList);

        int[] in_left = Arrays.copyOfRange(inOrderList, 0,index);
        int[] in_right = Arrays.copyOfRange(inOrderList, index+1,inOrderList.length);
        int[] pre_left = Arrays.copyOfRange(postOrderList, 0,in_left.length);
        int[] pre_right = Arrays.copyOfRange(postOrderList, postOrderList.length-1-in_right.length,postOrderList.length-1);
        
        root.lNode = buildTreeFromPostInOrder(pre_left, in_left, root.lNode);
        root.rNode = buildTreeFromPostInOrder(pre_right, in_right, root.rNode);

        return root;
    }

    private TreeNode buildTreeFromPreInOrder(int[] preOrderList,int[] inOrderList,TreeNode root){

       

        if(preOrderList.length ==1 ) return new TreeNode(preOrderList[0]);

        if(inOrderList.length ==1 ) return new TreeNode(inOrderList[0]);

        if(root == null) root = new TreeNode(preOrderList[0]);
       
        int index  = getIndexinArray(preOrderList[0],inOrderList);

        int[] in_left = Arrays.copyOfRange(inOrderList, 0,index);
        int[] in_right = Arrays.copyOfRange(inOrderList, index+1,inOrderList.length);
        int[] pre_left = Arrays.copyOfRange(preOrderList, 1,in_left.length);
        int[] pre_right = Arrays.copyOfRange(preOrderList, in_left.length+1,preOrderList.length);
        
        root.lNode = buildTreeFromPreInOrder(pre_left, in_left, root.lNode);
        root.rNode = buildTreeFromPreInOrder(pre_right, in_right, root.rNode);

        return root;
    }

    private void buildTree(){

        root = new TreeNode(1);
        root = setLeft(root, 2);
        root = setRight(root, 3);
        root.lNode = setLeft(root.lNode, 4);
        root.lNode = setRight(root.lNode, 5);
        root.rNode = setLeft(root.rNode, 6);
        root.rNode = setRight(root.rNode,7 );
        //root.lNode.lNode = setLeft(root.lNode.lNode, 8);
        //root.lNode.lNode.lNode = setLeft(root.lNode.lNode.lNode, 9);
        //root.lNode.lNode.lNode.lNode = setLeft(root.lNode.lNode.lNode.lNode, 10);
    }

    private void buildIdenticalTree(){

        root1 = new TreeNode(1);
        root1 = setLeft(root1, 2);
        root1 = setRight(root1, 3);
        root1.lNode = setLeft(root1.lNode, 4);
        root1.lNode = setRight(root1.lNode, 5);
        root1.rNode = setLeft(root1.rNode, 6);
        root1.rNode = setRight(root1.rNode,7 );
        //root.lNode.lNode = setLeft(root.lNode.lNode, 8);
        //root.lNode.lNode.lNode = setLeft(root.lNode.lNode.lNode, 9);
        //root.lNode.lNode.lNode.lNode = setLeft(root.lNode.lNode.lNode.lNode, 10);
    }

    private void buildBoundaryTree(){

        root3 = new TreeNode(1);
        root3 = setLeft(root3, 2);
        root3 = setRight(root3, 7);
        root3.lNode = setLeft(root3.lNode, 3);
        root3.rNode = setRight(root3.rNode, 8);
        root3.lNode.lNode = setRight(root3.lNode.lNode, 4);
        root3.rNode.rNode = setLeft(root3.rNode.rNode, 9);
        root3.lNode.lNode.rNode = setLeft(root3.lNode.lNode.rNode, 5);
        root3.lNode.lNode.rNode = setRight(root3.lNode.lNode.rNode, 6);
        root3.rNode.rNode.lNode = setLeft(root3.rNode.rNode.lNode, 10);
        root3.rNode.rNode.lNode = setRight(root3.rNode.rNode.lNode, 11);
    }

    private TreeNode setLeft(TreeNode root,int value){
        TreeNode node = new TreeNode(value);
        root.setlNode(node);
        return root;
    }

    private TreeNode setRight(TreeNode root,int value){
        TreeNode node = new TreeNode(value);
        root.setrNode(node);
        return root;
    }

    private void preOrder(TreeNode root){
        if(root == null) return;

        System.out.print("==>"+root.getValue());
        preOrder(root.getlNode());
        preOrder(root.getrNode());
    }

    private void inOrder(TreeNode root){
        if(root == null) return;

        
        inOrder(root.getlNode());
        System.out.print("==>"+root.getValue());
        inOrder(root.getrNode());
    }

    private void postOrder(TreeNode root){
        if(root == null) return;

        
        postOrder(root.getlNode());
        postOrder(root.getrNode());
        System.out.print("==>"+root.getValue()); 
    }

    private void levelOrder(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> queue = new LinkedList();

        System.out.println(root.getValue());
        queue.offer(root);
        List<Integer> list;
        while(!queue.isEmpty()){
            int size = queue.size();
            list = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.value);
                if(node.getlNode()!=null) queue.offer(node.getlNode());
                if(node.getrNode()!=null) queue.offer(node.getrNode());
            }
            System.out.println(list);
        }

    }

    private void preOrderIterative(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        System.out.println();
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print("==>"+node.getValue()); 
            if(node.getrNode()!=null) stack.push(node.getrNode());
            if(node.getlNode()!=null) stack.push(node.getlNode());
        }

    }

    private void inOrderIterative(TreeNode node){
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        System.out.println();
        while(true){
          if(node!=null){
            stack.push(node);
            node=node.lNode;
          }
          else{
            if(stack.isEmpty()) return;
            node = stack.pop();
            System.out.print("==>"+node.getValue()); 
            node= node.rNode;
          }
        }
    }

    private void postOrderIterative(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.lNode!=null) stack1.push(node.lNode);
            if(node.rNode!=null) stack1.push(node.rNode);
        }
        System.out.println();
        while(!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            System.out.print("==>"+node.getValue()); 
        }
    }


    private void postOrderIterativeSingleStack(TreeNode root){
        if(root == null) return;

        TreeNode current = root,temp = root;

        Stack<TreeNode> stack = new Stack<>();

        while(current !=null || !stack.isEmpty()){
            if(current!=null){
                stack.push(current);
                current=current.lNode;
            }
            else{
                temp = stack.pop().rNode;
                if(temp==null){
                    temp = stack.pop();
                    System.out.print("==>"+temp.getValue()); 
                    while(!stack.isEmpty() && temp == stack.peek().rNode){
                        temp = stack.pop();
                        System.out.print("==>"+temp.getValue()); 
                    }
                }
                else
                current=temp;
            }
        }
    }

    private int depthOfTree(TreeNode root){
        if(root == null) return 0;

        int l = depthOfTree(root.lNode);
        int r = depthOfTree(root.rNode);

        return 1+ Math.max(l, r);

    }

    private int diameterOfTree(TreeNode root,int max[]){
        if(root == null) return 0;

        int l = diameterOfTree(root.lNode,max);
        int r = diameterOfTree(root.rNode,max);

        max[0] = Math.max(l+r,max[0]);

        return  Math.max(l, r)+1;

    }

    private int maxPathOfTree(TreeNode root,int max[]){
        if(root == null) return 0;

        int l = Math.max(0,maxPathOfTree(root.lNode,max));
        int r = Math.max(0,maxPathOfTree(root.rNode,max));

        max[0] = Math.max(l+r+root.value,max[0]);

        return  Math.max(l, r)+root.value;

    }

    private int checkIfBalanced(TreeNode root){
        if(root == null) return 0;

    
       int lf = checkIfBalanced(root.lNode);
       if(lf==-1) return -1;
       int rf = checkIfBalanced(root.rNode);
       if(rf==-1) return -1;
       if(Math.abs(lf-rf) > 1) return -1;

       return Math.max(lf , rf);

    }

    private void pre_post_in_OrderIterativeSingleStack(TreeNode root){
        if(root == null) return;

        Stack<MixedNode> stack = new Stack<>();
        List<Integer> inorder,preorder,postorder;
        inorder = new ArrayList<>();
        preorder = new ArrayList<>();
        postorder = new ArrayList<>();

        stack.push(new MixedNode(root, 1));

        while(!stack.isEmpty()){

            MixedNode mixedNode = stack.pop();


            if(mixedNode.value ==1){
                preorder.add(mixedNode.node.value);
                stack.push(new MixedNode(mixedNode.node, mixedNode.value+1));
                if(mixedNode.node.lNode!=null) stack.push(new MixedNode(mixedNode.node.lNode, 1));
            }
            else if(mixedNode.value ==2){
                inorder.add(mixedNode.node.value);
                stack.push(new MixedNode(mixedNode.node, mixedNode.value+1));
                if(mixedNode.node.rNode!=null) stack.push(new MixedNode(mixedNode.node.rNode, 1));
            }
            else if(mixedNode.value ==3){
                postorder.add(mixedNode.node.value);
                stack.push(new MixedNode(mixedNode.node, mixedNode.value+1));
            }


        }

        System.out.println(" preorder: "+preorder);
        System.out.println(" inorder: "+inorder);
        System.out.println(" postorder: "+postorder);


    }

    private boolean checkIfIdenticalTree(TreeNode tree1, TreeNode tree2){
        if(tree1 == null || tree2 == null) return true;

        boolean l= checkIfIdenticalTree(tree1.lNode,tree2.lNode);
        if(tree1.value != tree2.value) return false;
        boolean r= checkIfIdenticalTree(tree1.rNode,tree2.rNode);
        System.out.println(" Value1 "+tree1.value+" Value2 "+tree2.value+" left "+l+ " right " +r);
        return l&&r;
    }

    private void zigZagTraverse(TreeNode root){
              if(root == null) return;
              Queue<TreeNode> queue = new LinkedList<>();
              queue.offer(root);
               int[] answer;
               boolean leftToRight = true;
               int index=0;
               while(!queue.isEmpty()){
                System.out.println();
                int size =  queue.size();
                answer = new int[size];
                leftToRight = !leftToRight;
                for(int i=0;i<size;i++){
                    TreeNode node = queue.poll();
                    index= leftToRight?i:size-i-1;
                     answer[index] = node.value;
                    if(node.lNode!=null) queue.offer(node.lNode);
                    if(node.rNode!=null) queue.offer(node.rNode);
                }

                for(int i=0;i<size;i++) System.out.print(" ==> "+answer[i]);

               }

    }
    
    private void boundaryTraverse(TreeNode root){
            if(root == null) return;
            List<Integer> boundary = new ArrayList<>();
            leftBoundary(root, boundary);
            leafNodes(root, boundary);
            rightBoundary(root, boundary);
            System.out.println(boundary);
    }

    private void leftBoundary(TreeNode root,List<Integer> boundary){
      
        while(root!=null){
            if(root.lNode!=null && root.rNode!=null) boundary.add(root.value);
            else if(root.lNode!=null) root = root.lNode;
            else root= root.rNode;            
        }
    }

    private void rightBoundary(TreeNode root,List<Integer> boundary){
     
        Stack<Integer> stack = new Stack<>();
        System.out.println(root.value);
        while(root!=null){
            
            if(root.lNode!=null && root.rNode!=null) ;
            else if(root.rNode!=null) root = root.rNode;
            else root= root.lNode;
            
        }   
        
        while(!stack.isEmpty()) boundary.add(stack.pop());
    }

    private void leafNodes(TreeNode root,List<Integer> boundary){
        if(root == null) return;
        if(root.lNode==null && root.rNode ==null) boundary.add(root.value);
        leafNodes(root.lNode, boundary);
        leafNodes(root.rNode, boundary);
    }

    private void vertricalTraverse(TreeNode root,Map<Integer,List<Integer>> node,int vertical,int horizontal){
        if(root == null) return ;

        if(!node.containsKey(vertical))
        {
            node.put(vertical, new ArrayList<>());
        }
        node.get(vertical).add(root.value);

        vertricalTraverse(root.lNode, node, vertical-1, horizontal);
        vertricalTraverse(root.rNode, node, vertical+1, horizontal);
    }

    private void topView(TreeNode root){
        if(root == null) return ;
        System.out.println("Top View");
        Map<Integer,List<Integer>> map = new HashMap<>();
        vertricalTraverse(root,map,0,0);
        for(int i:map.keySet()) System.out.println(map.get(i).get(0));
    }

    private void bottomView(TreeNode root){
        if(root == null) return ;
        System.out.println("Bottom View");
        Map<Integer,List<Integer>> map = new HashMap<>();
        vertricalTraverse(root,map,0,0);
        for(int i:map.keySet()) System.out.println(map.get(i).get(map.get(i).size()-1));
    }

    private void leftView(TreeNode root,int level, List<Integer> ds){
        if(root==null) return ;

        if(level == ds.size()) {
            ds.add(root.value);
            System.out.println(root.value);
        }
        rightView(root.lNode, level+1, ds);
        rightView(root.rNode, level+1, ds);
    }

    private void rightView(TreeNode root,int level, List<Integer> ds){
        if(root==null) return ;

        if(level == ds.size()) {
            ds.add(root.value);
            System.out.println(root.value);
        }
        rightView(root.rNode, level+1, ds);
        rightView(root.lNode, level+1, ds);
    }

    private boolean rootToNodePath(TreeNode root,int val, List<TreeNode> ds){
        if(root == null) return false;
        ds.add(root);
        if(root.value==val) {
            return true;
        }
        
        boolean l = rootToNodePath(root.lNode, val, ds);
        boolean r=rootToNodePath(root.rNode, val, ds);
        if(l || r) return true;
        else {
            ds.remove(ds.size()-1);
            return false;
        }
    }

    private int lowestCommonAnsestor(TreeNode root,int src,int dest){
        if(root == null) return -1;

        if(root.value == src) return src;
        if(root.value == dest) return dest;
        int l = lowestCommonAnsestor(root.lNode, src, dest);
        
        int r = lowestCommonAnsestor(root.rNode, src, dest);
        if(r!=-1 && l!=-1) return root.value;
        else if(r!=-1) return r;
        else if(l !=-1) return l;
        else return -1;

    }

    public void childrenSumproperty(TreeNode root){
        if(root==null) return ;
        int child = 0;
        
        if(root.lNode !=null) child += root.lNode.value;
        if(root.rNode !=null) child += root.rNode.value;

        if(child >= root.value) root.value= child;
        else{
            if(root.lNode != null) root.lNode.value = root.value;
            else if(root.rNode != null) root.rNode.value = root.value;
        }

        childrenSumproperty(root.lNode);
        childrenSumproperty(root.rNode);

        int tot = 0;

        if(root.lNode !=null) tot+=root.lNode.value;
        if(root.rNode !=null) tot+=root.rNode.value;
        if(root.lNode !=null || root.rNode !=null) root.value=tot;

    }

    public void kDistance(TreeNode root,int k,int target){
        if(root==null) return;
        TreeNode node = findNode(root, target);
        boolean[] visited = new boolean[maxVal(root, 0)+1];
        for(int i=0;i<visited.length;i++) visited[i]=false;
        treeBFS(node, visited,k);
    }

    public void burnDistance(TreeNode root,int target){
        if(root==null) return;
        boolean[] visited = new boolean[maxVal(root, 0)+1];
        for(int i=0;i<visited.length;i++) visited[i]=false;
        int[] count = new int[1];
        count[0]=0;
        TreeNode node = findNode(root, target);
        
        System.out.println(" burnDistance "+treeBFS(node, visited));
    }

    public int treeBFS(TreeNode root,boolean[] visited){
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);   
        int count=0;

        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            System.out.println(" burnDistance ==> ");
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                visited[node.value]=true;
                for(TreeNode n:adj(node))
                    if(!visited[n.value]) queue.offer(n);
            }
        }

        return count-1;
    }

    public int maxVal(TreeNode root,int max){
        if(root == null) return 0;
        if(root.value > max) max=  root.value;
        int l = maxVal(root.lNode, max);
        int r= maxVal(root.rNode, max);
        return Math.max(Math.max(l,r),max);
    }

    public List<TreeNode> adj(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        if(root.lNode !=null) result.add(root.lNode);
        if(root.rNode !=null) result.add(root.rNode);
        if(root.pNode !=null) result.add(root.pNode);
        return result;
    }

    public void treeBFS(TreeNode root,boolean[] visited,int perimiter){
        if(perimiter==0) {
            System.out.println(" kDistance "+root.value);
            return;
        }
        visited[root.value]=true;
        for(TreeNode n:adj(root)){
            if(!visited[n.value])
             treeBFS(n, visited, perimiter-1);
        }
    }

    public TreeNode findNode(TreeNode root,int target){
        if(root == null) return root;

        if(root.value ==target) return root;

        TreeNode l = findNode(root.lNode, target);
        if(l != null)  return l;

        TreeNode r = findNode(root.rNode, target);
        if(r != null)  return r;

        return null;
    }

    public void fillParentNode(TreeNode root){
        if(root==null) return;

        if(root.lNode != null ) {
            root.lNode.pNode=root;
            fillParentNode(root.lNode);
        }

        if(root.rNode != null ) {
            root.rNode.pNode=root;
            fillParentNode(root.rNode);
        }
        
    }

    public void countNodes(TreeNode root){
        System.out.println(" Left ==>"+getHeightLeft(root));
        System.out.println(" Right ==>"+getHeightRight(root));
    }

    public int getHeightLeft(TreeNode root){
        if(root==null) return 0;
        int count =0;
        while(root.lNode !=null) {
            count++;
            root= root.lNode;
        }
        return count;
    }

    public int getHeightRight(TreeNode root){
        if(root==null) return 0;
        int count =0;
        while(root.rNode !=null) {
            count++;
            root= root.rNode;
        }
        return count;
    }

    public String serealizeTree(TreeNode root){
        if(root==null) return "";
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node== null) result.append(" # ");
            else {
                result.append(" "+node.value+" ");
                queue.offer(node.lNode);
                queue.offer(node.rNode);
            }

        }
        return result.toString();
    }

    public TreeNode deserealizeTree(String str) throws ParseException{
        if(str.isEmpty()) return null;
        int index=0;
        String[] strs = str.trim().split("  ");
        TreeNode root = new TreeNode(Integer.parseInt(strs[index]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
       
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!strs[++index].equals("#") ) {node.lNode = new TreeNode(Integer.parseInt(strs[index])); queue.offer(node.lNode);}
            if(!strs[++index].equals("#")) { node.rNode = new TreeNode(Integer.parseInt(strs[index])); queue.offer(node.rNode);}
            
        }

        return root;
    }

}
