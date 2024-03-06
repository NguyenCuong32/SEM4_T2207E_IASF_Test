
function encodeImageFileAsBase64(element) {
var file = element.files[0];
var reader = new FileReader();
reader.onloadend = function() {
var base64String = reader.result.replace('data:', '').replace(/^.+,/, '');
document.getElementById("imageBase64").value = base64String;
};
reader.readAsDataURL(file);
}