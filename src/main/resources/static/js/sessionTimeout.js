let timeout;

function resetTimer() {
    clearTimeout(timeout);
    timeout = setTimeout(() => {
        alert("Phiên làm việc đã hết hạn. Bạn sẽ được chuyển đến trang đăng nhập.");
        window.location.href = "/users/logout"; // Đường dẫn logout của bạn
    }, 30 * 60 * 1000); // 30 phút
}

window.onload = resetTimer;
document.onmousemove = resetTimer;
document.onkeydown = resetTimer;
