

$(document).ready(function() {
    $('#timkiem').keyup(function() {
        $('#result').html('');
        var search = $('#timkiem').val();
        if (search !== '') {
            $('#result').css('display', 'inherit');
            var expression = new RegExp(search, 'i');
            $.getJSON('/json/movies.json', function(data) {
                var resultsFound = false;
                $.each(data, function(key, value) {
                    if (value.title.search(expression) != -1) {
                        resultsFound = true;
                        $('#result').append(
                            '<li data-movie-id="' + value.id + '" style="cursor:pointer; display: flex; max-height: 140px;" class="list-group-item link-class"><img style="object-fit:cover" src="/poster/' +
                            value.poster +
                            '" width="100" class="" /><div style="padding-left:10px; flex-direction: column; margin-left: 2px;"><span width="100%" style="font-size:16px;font-weight: 700;">' +
                            value.title +
                            '</span><p style="font-size:12px"> | ' + value.nameEng + '</p></div></li>');
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
        var movieId = $(this).data('movie-id');
        var movieTitle = $(this).find('span').text();
        $('#selectedMovieId').val(movieId);
        $('#timkiem').val(movieTitle);
        $('#result').html('');
        $('#result').css('display', 'none');
    });
});