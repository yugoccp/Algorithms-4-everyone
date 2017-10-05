var tree = function(value) {

    // initialize an epty object which will contain our tree
    var createNewTree = {};

    createNewTree.value = value;
    createNewTree.children = [];

    //_.extend() Copies every property of the source objects into the first object.
    _.extend(createNewTree, methods);

    return createNewTree;
  };
  
  // Creating instance of tree methods
  var methods = {};
  
  //Declare Tree methods
  methods.addChild = function(value) {
    this.children.push(tree(value));
  };
  
  methods.contains = function(target, root) {
    root = root || this;
    if (root.value === target) return true; // In case of root branch
    
    for (var i = 0; i < root.children.length; i++) {
      if (this.contains(target, root.children[i])) return true;
    }
    
    return false;
  };