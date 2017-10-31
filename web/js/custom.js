$(function() {

    $("#js-register-form").validate({

        rules: {
            loginRegister: {
                required: true
            },
            passwordRegister: {
                required: true,
                minlength: 6
            },
            passwordRegister2: {
                required: true,
                minlength: 6,
                equalTo: "#form-pswd1"
            }
        },
        messages: {
            loginRegister: {
                required: "Поле Логин обязательное для заполнения"
            },
            passwordRegister: {
                required: "Поле Пароль обязательное для заполнения",
                minlength: "Длинна пароля должна быть больше 6 символов"
            },
            passwordRegister2: {
                required: "Поле Пароль обязательное для заполнения",
                minlength: "Длинна пароля должна быть больше 6 символов",
                equalTo : "Повторите ранее введеный пароль"
            }
        },
        
        focusCleanup: true,
        focusInvalid: false

        
    });

});
