package BST;
public class TreeNode implements Comparable<TreeNode>{
    
    TreeNode lNode,rNode,pNode;
    int value;

    
    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode [value=" + value + "]";
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
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TreeNode other = (TreeNode) obj;
        if (value != other.value)
            return false;
        return true;
    }

    @Override
    public int compareTo(TreeNode treeNode) {
        if(this.value>treeNode.getValue()) return 1;
        if(this.value<treeNode.getValue()) return -1;
        return 0;
    }

    
}
