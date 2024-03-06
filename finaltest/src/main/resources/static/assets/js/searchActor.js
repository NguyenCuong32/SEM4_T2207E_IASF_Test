$(document).ready(function() {
    $('#txt').keyup(function() {
        $('#result').html('');
        var search = $('#txt').val();
        if (search !== '') {
            $('#result').css('display', 'inherit');
            var expression = new RegExp(search, 'i');
            $.getJSON('/json/actors.json', function(data) {
                var resultsFound = false;
                $.each(data, function(key, value) {
                    if (value.name.search(expression) != -1) {
                        resultsFound = true;
                        $('#result').append(
                            '<li data-actor-id="' + value.id + '" style="cursor:pointer; display: flex; max-height: 140px;" class="list-group-item link-class"><img style="object-fit:cover" src="/avatarActors/' +
                            value.avatar +
                            '" width="100" class="" /><div style="padding-left:10px; flex-direction: column; margin-left: 2px;"><span width="100%" style="font-size:16px;font-weight: 700;">' +
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
        var actorId = $(this).data('actor-id');
        var actorTitle = $(this).find('span').text();
        $('#ActorId').val(actorId);
        $('#txt').val(actorTitle);
        $('#result').html('');
        $('#result').css('display', 'none');
    });
});