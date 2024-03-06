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
                            '</span></div></li>');
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
        $(this).find('.DirectorId').val(directorId);
        $('#txt').val(directorTitle);
        $('#result').html('');
        $('#result').css('display', 'none');
    });
});