package Languages;

import java.util.ListResourceBundle;

public class MLang_en_NZ extends ListResourceBundle {

    @Override
    public Object[][] getContents() {
        return contents;
    }

    private static final Object[][] contents = {
            //BUTTON
            {"eLanguage","Choose language"},
            {"bChoose","Choose"},
            {"LLanguage","Languages"},
            {"bShow", "Show"},
            {"bSend","Send"},
            {"LAnswer","Server response"},
            {"LEnter","Specify the server address (can be left blank)"},
            {"LEnterPort","Specify the port"},
            {"WrongPort","Invalid port"},
            {"Regtitle","Input"},
            {"SIButton","Sign in"},
            {"RegButton","Register"},
            {"Login","Login:"},
            {"Password","Password:"},
            {"good_answer","The authorization was successful."},
            {"pas_inc_answer","Incorrect password"},
            {"user_inc_answer","User with this login does not exist"},
            {"user_ex_answer","A user with the same name already exists"},
            {"server_error_answer","There is currently no access to the server. Please try again later"},
            {"lang_title","Language selection"},
            {"bremove_key","Remove by key"},
            {"bremove_greater","Remove greater"},
            {"bhistory","History"},
            {"bupdate","Update"},
            {"breplace_if_greater","Replace if greater"},
            {"bremove_any","Remove any by the number of wheels"},
            {"bcount_less","Count less than engine power"},
            {"bprint_field","Print_field_ascending_type"},
            {"bexecute_script","Execute script"},
            {"cblanguages","languages"},
            {"LUser","User"},
            {"CDColumn","Creation date"},
            {"NameColumn","Name"},
            {"KeyColumn","Key"},
            {"CXColumn","Coordinate x"},
            {"CYColumn","Coordinate y"},
            {"EPColumn","Engine power"},
            {"NOWColumn","Number of wheels"},
            {"TypeColumn","Type"},
            {"FuelTypeColumn","Fuel type"},
            {"UserColumn","User"},
            {"bShowData","Show available data"},
            {"bChange","Change"},
            {"bDelete","Delete"},
            {"errorKey","Invalid Key value. Key - Integer value"},
            {"errorX","X coordinate value is double and> -815"},
            {"errorY","Y coordinate value is long and> -774"},
            {"errorNumber","The value of the Number_of_wheels field is long and> 0"},
            {"errorEngine","The Engine Power field value must be float or greater than 0"},
            {"enterKey","Enter Key"},
            {"enterName","Enter name"},
            {"enterX","Enter coordinate x"},
            {"enterY","Enter coordinate y"},
            {"enterNumber","Enter number of wheels"},
            {"enterEngine","Enter engine power"},
            {"enterType","Enter type"},
            {"enterFuel","Enter fuel type"},
            {"bCreate","Create"},
            {"File","File"},
            {"enter_File","Enter file"},
            {"File_was_used","The file specified in the run method is already in use, you cannot use it again"},
            {"error_File","Some problems with the file. Try again"},
            {"enter_Id","Enter Id"},
            {"error_Id","Id -value of type long"},
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

            {"bHelp", "Help"},
            {"bInfo", "Info"},
            {"bAdd", "Add"},
            {"bUpdate", "Update"},
            {"bClear", "Clear"},
            {"bExecuteScript", "Execute script"},

            {"lFilter", "Filter"},


            //DATA
            {"dataFormat", "dd.MM.yy"},
            //WORK

    };
}
