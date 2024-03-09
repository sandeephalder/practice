public class BST {
    class Node{
        Node lNode,rNode;
        int value;
        int rank=1;
        Node(int value){
            this.value=value;
        } 
        @Override
        public String toString(){
            return "( rank= "+rank+" value="+value+" )" ;
        }
    }
    Node root;
    public static void main(String[] args) {
        BST bst = new BST();
       
    }

    BST(){
        root= insert(root, 8);
        root=insert(root, 2);
        root=insert(root, 89);
        root=insert(root, 198);
        root=insert(root, -1);
        //inorder(root);
        //System.out.println(min(root));
        //System.out.println(max(root));
       // System.out.println(rank(root,2));
        //root= deleteMin(root);
       // root= deleteMax(root);
        delete(root, 2);
        inorder(root);
    }

    public Node deleteMin(Node node){
        if (node.lNode==null) return node.rNode;

        node.lNode = deleteMin(node.lNode);
        node.rank = 1+size(node.lNode)+size(node.rNode);
        return node;
    }

    public Node deleteMax(Node node){
        if (node.rNode==null) return node.lNode;

        node.rNode = deleteMax(node.rNode);
        node.rank = 1+size(node.lNode)+size(node.rNode);
        return node;
    }

    public Node delete(Node node,int value){
        if (node==null) return node;
        if(value<node.value){
            node.lNode = delete(node.lNode, value);
        }
        else if(value>node.value){
            node.rNode = delete(node.rNode, value);
        }
        else{
            if(node.rNode==null) return node.lNode;
            
            Node t= node;
            node = min(node.rNode);
            node.rNode= deleteMin(node.rNode);
            node.lNode = t.lNode;
        }
        return node;
    }


    public int rank(Node node,int value){
       if(node ==null) return 0;
        int val=0; 
       if(value<node.value) {
           
           val = rank(node.lNode,value);
           System.out.println(node+" rank <"+val);
        return val;
       }
       else if(value>node.value) {
        
        val =rank(node.rNode,value)+1+size(node.lNode);
        System.out.println(node+" rank >" +val);
        return val;
       }
       else {
        
        val = size(node.lNode);
        System.out.println(node+" rank == "+val);
        return val;
       }


    }
    
    public Node min(Node node){
        if(node==null || node.lNode==null) return node;
        node = min(node.lNode);
        return node;
    }

    public Node max(Node node){
        if(node==null || node.rNode==null) return node;
        node = max(node.rNode);
        return node;
    }

    public Node insert(Node node,int value){
        if(node == null) return new Node(value);

        if(node.value>value) node.lNode = insert(node.lNode, value);
        else if(node.value<value) node.rNode = insert(node.rNode, value);
        else node.value= value;
        node.rank = 1+size(node.lNode)+size(node.rNode);
        System.out.println(" Insert"+node);
        return node;
    }

    public void inorder(Node node){
        if(node==null) return;

        inorder(node.lNode);
        System.out.print(" ==> "+node);
        inorder(node.rNode);
    }

    public Node get(Node node,int value){
        if(node == null) return node;

        if(node.value<value) node = get(node.lNode, value);
        else if(node.value>value) node = get(node.rNode, value);
        else return node;
        return node;
    }

    public int size(Node node){
        if(node==null) return 0;

        return node.rank;
    }
}
