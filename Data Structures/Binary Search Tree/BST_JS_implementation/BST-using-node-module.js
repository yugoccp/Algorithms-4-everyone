/* ======= Including(requiring) the needed libraries ======= */

var Node = require("tree-node-js");
var BST = require("binary-search-tree-js");

/* ======= Create a tree using tree-node-js library ======= */
 

var node1 = Node(100);
var tree = BST(node1);

/* ======= Create the child nodes ======= */
 
var node1 = Node(10);
var node2 = Node(2);

/* ======= Append the created nodes to the tree ======= */

tree.insert(node1);
tree.insert(node2);

/* ======= Display the inorder traversal ======= */
 
tree.inorder(node1, function(node){
  console.log(node);
})