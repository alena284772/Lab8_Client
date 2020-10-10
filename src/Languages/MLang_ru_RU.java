package Languages;

import java.util.ListResourceBundle;

public class MLang_ru_RU extends ListResourceBundle {

    @Override
    public Object[][] getContents() {
        return contents;
    }

    private static final Object[][] contents = {
            //BUTTON
            {"eLanguage","Выберите язык"},
            {"bChoose","Выбрать"},
            {"LLanguage","Языки"},
            {"bShow", "показать"},
            {"bSend","Отправить"},
            {"LAnswer","Ответ сервера"},
            {"LEnter","Укажите адрес сервера(можно оставить пустым)"},
            {"LEnterPort","Укажите порт"},
            {"WrongPort","Неверно указанный порт"},
            {"Regtitle","Вход"},
            {"SIButton","Войти"},
            {"RegButton","Зарегистрироваться"},
            {"Login","Логин:"},
            {"Password","Пароль:"},
            {"good_answer","Авторизация прошла успешно."},
            {"pas_inc_answer","Неверный пароль"},
            {"user_inc_answer","Пользователя с таким логином не существует"},
            {"user_ex_answer","Пользователь с таким именем уже существует"},
            {"server_error_answer","В данный момент нет доступа к серверу. Попробуйте сделать запрос позже"},
            {"lang_title","Выбор языка"},
            {"bremove_key","Удалить по ключу"},
            {"bremove_greater","Удалить превышающие"},
            {"bhistory","История"},
            {"bupdate","Обновить"},
            {"breplace_if_greater","Заменить большим"},
            {"bremove_any","Удалить любой по количеству колёс"},
            {"bcount_less","Количество тех, чья мощность двигателя меньше заданной"},
            {"bprint_field","Типы в порядке возрастания"},
            {"bexecute_script","Выполнить скрипт"},
            {"cblanguages","языки"},
            {"LUser","Пользователь"},
            {"CDColumn","Дата создания"},
            {"NameColumn","Имя"},
            {"KeyColumn","Ключ"},
            {"CXColumn","Координата x"},
            {"CYColumn","Координата y"},
            {"EPColumn","Мощность двигателя"},
            {"NOWColumn","Количество колес"},
            {"TypeColumn","Тип транспорта"},
            {"FuelTypeColumn","Тип топлива"},
            {"UserColumn","Владелец"},
            {"bShowData","Показать доступные данные"},
            {"bChange","Изменить"},
            {"bDelete","Удалить"},
            {"errorKey","Неверное значение Key. Key - значение Integer"},
            {"errorX","Значение координаты x - double и >-815"},
            {"errorY","Значение координаты y - long и >-774"},
            {"errorNumber","Значение поля Number_of_wheels - long и >0"},
            {"errorEngine","Значение поля Engine Power должно быть float и больше 0"},
            {"enterKey","Укажите ключ"},
            {"enterName","Укажите имя"},
            {"enterX","Укажите координату x"},
            {"enterY","Укажите координату y"},
            {"enterNumber","Укажите количество колёс"},
            {"enterEngine","Укажите мощность двигателя"},
            {"enterType","Укажите тип транспорта"},
            {"enterFuel","Укажите тип топлива"},
            {"bCreate","Создать"},
            {"File","Файл"},
            {"enter_File","Укажите Файл"},
            {"File_was_used","Файл, указанный в методе выполнения, уже используется, вы не можете использовать его снова"},
            {"error_File","Некоторые проблемы с файлом. Повторите попытку"},
            {"enter_Id","Введите Id"},
            {"error_Id","Id -значение типа long"},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},
            {"",""},

            {"bHelp", "помощь"},
            {"bInfo", "информация"},
            {"bAdd", "добавить"},
            {"bUpdate", "обновить"},
            {"bAddIfMin", "добавить если мин"},
            {"bRemove", "удалить"},
            {"bClear", "очистить"},
            {"bExecuteScript", "выполнить скрипт"},

            {"lFilter", "Фильтр"},


            //DATA
            {"dataFormat", "dd.MM.yy"},
            //WORK

    };
}