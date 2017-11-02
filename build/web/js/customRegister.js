$(function() {

    $("#jsRegisterForm").validate({

        rules: {
            loginRegister: {
                required: true
            },
            passwordRegister: {
                required: true,
                minlength: 6
            },
            passwordRegisterRepeat: {
                required: true,
                minlength: 6,
                equalTo: "#firstPassword"
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
            passwordRegisterRepeat: {
                required: "Поле Повторите пароль обязательное для заполнения",
                minlength: "Длинна пароля должна быть больше 6 символов",
                equalTo : "Повторите ранее введеный пароль"
            }
        },
        
        focusCleanup: true,
        focusInvalid: false

        
    });

});
