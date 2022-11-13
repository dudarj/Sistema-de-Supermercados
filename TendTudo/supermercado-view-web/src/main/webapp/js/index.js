$(function () {
    $('#login-form-link').click(function (e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-form-link').click(function (e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
});

function mascaraTelefone(campo) {

    function trata(valor, isOnBlur) {
        valor = valor.replace(/\D/g, "");
        valor = valor.replace(/^(\d{2})(\d)/g, "($1)$2");
        if (isOnBlur) {
            valor = valor.replace(/(\d)(\d{4})$/, "$1-$2");
        } else {
            valor = valor.replace(/(\d)(\d{3})$/, "$1-$2");
        }
        return valor;
    }

    campo.onkeypress = function (evt) {
        var code = (window.event) ? window.event.keyCode : evt.which;
        var valor = this.value
        if (code > 57 || (code < 48 && code != 8)) {
            return false;
        } else {
            this.value = trata(valor, false);
        }
    }

    campo.onblur = function () {

        var valor = this.value;
        if (valor.length < 13) {
            this.value = ""
        } else {
            this.value = trata(this.value, true);
        }
    }

    campo.maxLength = 14;
}
