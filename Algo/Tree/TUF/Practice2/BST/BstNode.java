package BST;
public class BstNode {

    BstNode lNode,rNode;
    int key =0;
    int value=0;

    


    public BstNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    
    public BstNode getlNode() {
        return lNode;
    }
    public void setlNode(BstNode lNode) {
        this.lNode = lNode;
    }
    public BstNode getrNode() {
        return rNode;
    }
    public void setrNode(BstNode rNode) {
        this.rNode = rNode;
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "BstNode [key=" + key + ", value=" + value + "]";
    }

    

}
