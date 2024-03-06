var inputTag = document.getElementById('inputTag');
var listTag = document.getElementById('tag');
var itemTag = [];

inputTag.addEventListener('keypress', function(e) {
    if (e.key === 'Enter') {
        let val = inputTag.value;
        if (val !== '') {
            if (itemTag.indexOf(val) >= 0) {
                alert('Tag name is a duplicate');
            } else {
                itemTag.push(val);
                renderTag();
                inputTag.value = '';
                inputTag.focus();
            }
        } else {
            alert('Please type a tag Name');
        }
    }
});

function renderTag() {
    listTag.innerHTML = '';
    itemTag.map((item, index) => {
        listTag.innerHTML += `<li><span>${item}</span><a href="javascript: remove(${index})">X</a></li>`;
    });
}

function remove(i) {
    itemTag = itemTag.filter(function(tag) {
        return itemTag.indexOf(tag) !== i;
    });
    renderTag();
}


window.onload = function() {
    renderTag();
    inputTag.focus();
}