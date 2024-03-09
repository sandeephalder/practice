public class TreeNode{
    TreeNode lNode=null,rNode=null;
    int data;
    int level;

    TreeNode(int data){
        this.data=data;
    }
    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TreeNode getlNode() {
        return lNode;
    }
    public void setlNode(TreeNode lNode) {
        this.lNode = lNode;
    }
    public TreeNode getrNode() {
        return rNode;
    }
    public void setrNode(TreeNode rNode) {
        this.rNode = rNode;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode " + data + "";
    }
   
    
}