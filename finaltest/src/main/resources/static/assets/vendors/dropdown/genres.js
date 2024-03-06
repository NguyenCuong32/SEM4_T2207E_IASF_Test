// Lắng nghe sự kiện khi nhấp vào phần tử có id="ui-basic"
document.getElementById('genres').addEventListener('click', function() {
    // Lấy phần tử ul có class="nav flex-column sub-menu"
    var subMenu = document.querySelector('.genres');

    // Kiểm tra xem phần tử ul đã có lớp 'show' hay chưa
    var isSubMenuVisible = subMenu.classList.contains('show');

    // Nếu đã có lớp 'show', loại bỏ lớp 'show' để ẩn dropdown
    if (isSubMenuVisible) {
        subMenu.classList.remove('show');
    }
    // Ngược lại, thêm lớp 'show' để hiển thị dropdown
    else {
        subMenu.classList.add('show');
    }
});