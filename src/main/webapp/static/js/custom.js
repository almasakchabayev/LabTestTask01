function showConfirm() {
    var deleteElement = document.getElementById("delete");
    var text = deleteElement.innerHTML;
    return confirm(text);
}