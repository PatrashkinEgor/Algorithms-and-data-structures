package Lesson6HW;
/**
 * Algorithms and data structures. Lesson 6. Homework
 *
 * @modified_by Egor Patrashkin
 * @version dated Oct 20, 2018
 */

public class Tree {

    private Node root;


    /**
     *  Метод написан в рамках выполнения ДЗ к уроку 6.
     * @param rootNode Стартовый(заданный) узел. В расчет не входит.
     * @return Возвращает количество узлов расположенных "ниже" заданного.
     */
    private int countNodes(Node rootNode){
        if(rootNode != null){
            return countNodes(rootNode.leftChild) + countNodes(rootNode.rightChild) + 1;
        }
        return 0;
    }

    /**
     * Метод написан в рамках выполнения ДЗ к уроку 6. Определяет является ли дерево сбалансированным.
     * @param delta допустимая разница в размерах ветвей дерева.
     * @return true - если дерево сбалансировано, false - если нет.
     */

    public boolean isTreeBalanced(int delta){
        int r = this.countNodes(this.root.rightChild);
        System.out.println("There are " + r + " elements on right side");
        int l = this.countNodes(this.root.leftChild);
        System.out.println("There are " + l + " elements on left side");
        return (Math.abs(r-l)<=delta)? true: false;
    }



    public Node find(int key){
        Node current = root;
        while (current.num.id != key) {
            if (key < current.num.id){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null){
                return null;
            }
        }
        return current;
    }

    public int insert(Num num){
        Node node = new Node();
        node.num = num;
        int i = 0;
        if (root == null){
            root = node;
            return i;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                i++;
                parent = current;
                if (num.id < current.num.id){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        return i;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        return i;
                    }
                }
            }
        }
    }

    public boolean delete(int id){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.num.id != id) {
            parent = current;
            if (id < current.num.id){
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){
                return false;
            }
        }

        // Если узел не имеет потомков

        if (current.leftChild == null && current.rightChild == null){
            if (current == null){
                root = null;
            } else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }
        // Если нет правого потомка
        else if(current.rightChild == null){
            if (current == null){
                root = current.leftChild;
            } else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
        }
        // Если нет левого потомка
        else if(current.leftChild == null){
            if (current == null){
                root = current.rightChild;
            } else if(isLeftChild){
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccesor(current);
            if (current == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccesor(Node node){
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }

    public void traverse(int traverseType){
        switch(traverseType){
            case 1:System.out.println("Preorder traversal");
                preOrder(root);
                break;
        }
    }

    private void preOrder(Node rootNode){
        if(rootNode != null){
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node rootNode){
        if(rootNode != null){
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    private void inOrder(Node rootNode){
        if(rootNode != null){
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }



    public void displayTree(){
        Stack stack = new Stack(100);
        stack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;

        while (isRowEmpty == false) {
            Stack localStack = new Stack(100);
            isRowEmpty = true;
            for(int i=0;i<nBlanks;i++){
                System.out.print(" ");
            }
            while (stack.isEmpty() == false) {
                Node temp = stack.pop();
                if (temp != null){
                    temp.display();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null){
                        isRowEmpty = false;
                    }
                }else{
                    System.out.print("--");
                    //localStack.push(null);
                    //localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            }
            System.out.println(" ");
            nBlanks = nBlanks/2;
            while (localStack.isEmpty() == false) {
                stack.push(localStack.pop());
            }
            System.out.println("......................................................");
        }
    }

}

