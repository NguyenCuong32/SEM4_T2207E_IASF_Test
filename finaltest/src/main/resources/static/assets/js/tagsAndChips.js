var directorList = [];

function render() {
    var list = document.querySelector('#list');
    list.innerHTML = '';
    directorList.forEach(function(director) {
        var li = document.createElement('li');
        var span = document.createElement('span');
        span.innerText = director.name;
        var input = document.createElement('input');
        input.setAttribute('type', 'hidden');
        input.setAttribute('class', 'DirectorId');
        input.setAttribute('name', 'DirectorId');
        input.value = director.id;
        var removeLink = document.createElement('a');
        removeLink.setAttribute('href', 'javascript: remove(' + director.id + ')');
        removeLink.innerText = 'X';
        li.appendChild(span);
        li.appendChild(input);
        li.appendChild(removeLink);
        list.appendChild(li);
    });
}

function remove(directorId) {
    directorList = directorList.filter(function(director) {
        return director.id !== directorId;
    });
    render();
}

$(document).ready(function() {
    $('#txt').keyup(function() {
        $('#result').html('');
        var search = $('#txt').val();
        if (search !== '') {
            $('#result').css('display', 'inherit');
            var expression = new RegExp(search, 'i');
            $.getJSON('/json/directors.json', function(data) {
                var resultsFound = false;
                $.each(data, function(key, value) {
                    if (value.name.search(expression) != -1) {
                        resultsFound = true;
                        $('#result').append(
                            '<li data-director-id="' + value.id + '" style="cursor:pointer; display: flex; max-height: 140px;" class="list-group-item link-class">' +
                            '<div style="padding-left:10px; flex-direction: column; margin-left: 2px;"><span width="100%" style="font-size:16px;font-weight: 700;">' +
                            value.name +
                            '</span></div></li>'
                        );
                    }
                });

                if (!resultsFound) {
                    $('#result').append(
                        '<li class="list-group-item">Không tìm thấy kết quả</li>'
                    );
                }
            });
        } else {
            $('#result').css('display', 'none');
        }
    });

    $('#result').on('click', 'li', function() {
        var directorId = $(this).data('director-id');
        var directorTitle = $(this).find('span').text();
        var director = { id: directorId, name: directorTitle };
        directorList.push(director);
        render();
        $('#txt').val('');
        $('#result').html('');
        $('#result').css('display', 'none');
    });
});

window.onload = function() {
    render();
    $('#txt').focus();
};