$('form input[name="email"]').blur(function () {
var email = $(this).val();
var re = /[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}/igm;
if (re.test(email)) {
    $('.msg').hide();
} else {
    $('.msg').hide();
    $('.error').show();
}

});

var password1 = document.getElementById('password');
var password2 = document.getElementById('repeatpass');

var checkPasswordValidity = function() {
    if (password1.value != password2.value) {
        password1.setCustomValidity('Passwords must match.');
    } else {
        password1.setCustomValidity('');
    }
};

password1.addEventListener('change', checkPasswordValidity, false);
password2.addEventListener('change', checkPasswordValidity, false);