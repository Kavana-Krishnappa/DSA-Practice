import java.util.LinkedList;
import java.util.Queue;
public class Tree {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.insert(11);
        binarySearchTree.insert(9);
        binarySearchTree.insert(12);
        binarySearchTree.insert(13);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
         System.out.println("inorder:");
        binarySearchTree.inorder();
        System.out.println("-----------------");
        System.out.println("Preorder:");
        binarySearchTree.preorder();
        System.out.println("-----------------");
        System.out.println("Postorder:");
        binarySearchTree.postorder();
        System.out.println("-----------------");
        System.out.println("Level order:");
        binarySearchTree.levelorder();

         binarySearchTree.delete(6);
         System.out.println("Level order after deleting:");
        binarySearchTree.levelorder();
        //System.out.println(binarySearchTree.root.right .value);
        //System.out.println(binarySearchTree.search(122));

    }
     
    
}
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
}
class BinarySearchTree{
    
    public TreeNode root;
    public BinarySearchTree(){
        this.root=null;
    }

    public void insert(int value){
        this.root=this.insert_tree(this.root,value);
    }
    public TreeNode insert_tree(TreeNode root,int value){
        if(root==null){
            return new TreeNode(value);
        }

        if(value<root.value){
            root.left=this.insert_tree(root.left, value);
        }
        else if(value>root.value){
            root.right=this.insert_tree(root.right, value);
        }
        return root;
    }

    public boolean search(int value){
        return this.Search_Tree(this.root, value);
    }
    public boolean Search_Tree(TreeNode root,int value){
        if(root==null){
            return false;
        }
        if(root.value==value){
            return true;
        }
        else if(value<root.value){
            return this.Search_Tree(root.left, value);
        }else{
            return this.Search_Tree(root.right, value);
        }
    }

    public void inorder(){
        this.inorder_tree(this.root);
    }

    public void inorder_tree(TreeNode root){
        if(root!=null){
            this.inorder_tree(root.left);
             System.out.println(root.value);

             this.inorder_tree(root.right);
        }
    }

    public void preorder(){
        this.preorder_tree(this.root);
    }

    public void preorder_tree(TreeNode root){
        if(root!=null){
            System.out.println(root.value);
            this.preorder_tree(root.left);
            this.preorder_tree(root.right);
        }
    }

    public void postorder(){
        this.postorder_tree(this.root);
    }

    public void postorder_tree(TreeNode root){
        if(root!=null){
            this.postorder_tree(root.left);
            this.postorder_tree( root.right);
            System.out.println(root.value);
            


        }
    } 
    public void levelorder(){
        this.levelorder_tree(root);
    }
    private void levelorder_tree(TreeNode root){
        if (root==null){
            return;
        }
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode top=queue.poll();
            System.out.println(top.value);
               if(top.left!=null){
             queue.offer(top.left);
              }
            if(top.right!=null){
             queue.offer(top.right);
            }

        }
    }
        public TreeNode delete(int value){
            return this.delete_tree(root, value);
        }
        private TreeNode delete_tree(TreeNode root,int value){
                if(root==null){
                    return root;
                }
                if(value<root.value){
                  root.left=this.delete_tree(root.left,value);
                  return root;
                }
                else if(value>root.value){
                    root.right=this.delete_tree(root.right, value);
                    return root;

                }
                //for one child
                if(root.left==null){
                    return root.right;
                }
                if(root.right==null){
                    return root.left;
                }
             // for 2 children
               else{
                TreeNode parent=root;
                TreeNode right=root.right;
                 
                  while(right.left!=null){
                    parent=right;
                    right=right.left;
                  }
                  if(parent!=root){
                    parent.left=right.right;
                  }else{
                    parent.right=right.left;
                  }
                  root.value=parent.value;
                  return root;





               }



            }
        }


     




