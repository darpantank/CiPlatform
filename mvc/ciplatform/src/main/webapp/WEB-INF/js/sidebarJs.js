function openLeftFilterMenu() {
    if(document.getElementById("leftFilterMenu").style.display== "block"){
        document.getElementById("leftFilterMenu").style.display = "none";
    }
    else{
        document.getElementById("leftFilterMenu").style.display = "block";
    }
  }
  
  function closeLeftFilterMenu() {
    document.getElementById("leftFilterMenu").style.display = "none";
  }
  function openLeftMainMenu() {
    document.getElementById("leftMainMenu").style.display = "block";
  }
  
  function closeLeftMainMenu() {
    document.getElementById("leftMainMenu").style.display = "none";
  }
  function addFilter(currentAddedFilter){
    var img = document.createElement("img");
    img.src = "image/cancel.png";
    img.setAttribute('onclick', 'deleteFilter(this);');
    var namep=document.createElement("p");
    // name.className="";
    const nameText= document.createTextNode(currentAddedFilter);
    namep.appendChild(nameText);
    const node = document.createElement("div");
    node.className="col d-flex align-items-center justify-content-between";
  node.appendChild(namep);
  node.appendChild(img)
  document.getElementById("myList").appendChild(node);
  }
  function deleteFilter(mytag){
    mytag.parentNode.parentNode.removeChild(mytag.parentNode);
  }
