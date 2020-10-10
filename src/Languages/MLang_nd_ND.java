package Languages;

import java.util.ListResourceBundle;

public class MLang_nd_ND extends ListResourceBundle {

    @Override
    public Object[][] getContents() {
        return contents;
    }

    private static final Object[][] contents = {
            //BUTTON
            {"eLanguage","Kies een taal"},
            {"bChoose","Kiezen"},
            {"LLanguage","Talen"},
            {"bShow", "Tonen"},
            {"bSend","Bericht versturen"},
            {"LAnswer","Server reactie"},
            {"LEnter","Specificeer het serveradres (kan leeg worden gelaten)"},
            {"LEnterPort","Specificeer de poort"},
            {"WrongPort","Ongeldige poort"},
            {"Regtitle","invoer"},
            {"SIButton","Binnenkomen"},
            {"RegButton","Registreer nu"},
            {"Login","Log in:"},
            {"Password","Wachtwoord:"},
            {"good_answer","De autorisatie is gelukt."},
            {"pas_inc_answer","Incorrect wachtwoord"},
            {"user_inc_answer","Gebruiker met deze login bestaat niet"},
            {"user_ex_answer","Er bestaat al een gebruiker met dezelfde naam"},
            {"server_error_answer","Er is momenteel geen toegang tot de server. Probeer het later opnieuw"},
            {"lang_title","Taal selectie"},
            {"bremove_key","Verwijderen met sleutel"},
            {"bremove_greater","Verwijder overschrijding"},
            {"bhistory","Geschiedenis"},
            {"bupdate","Vernieuwen"},
            {"breplace_if_greater","Vervang door grote"},
            {"bremove_any","Verwijder alle door het aantal wielen"},
            {"bcount_less","Het aantal van degenen met een motorvermogen dat lager is dan het gespecificeerde"},
            {"bprint_field","Typen in oplopende volgorde"},
            {"bexecute_script","Voer script uit"},
            {"cblanguages","talen"},
            {"LUser","Gebruiker"},
            {"CDColumn","datum van creatie"},
            {"NameColumn","Naam"},
            {"KeyColumn","Sleutel"},
            {"CXColumn","X-coördinaat"},
            {"CYColumn","Y-coördinaat"},
            {"EPColumn","Motorkracht"},
            {"NOWColumn","Aantal wielen"},
            {"TypeColumn","Vervoerswijze"},
            {"FuelTypeColumn","Brandstoftype"},
            {"UserColumn","Eigenaar"},
            {"bShowData","Toon beschikbare gegevens"},
            {"bChange","Bewerk"},
            {"bDelete","Verwijderen"},
            {"errorKey","Ongeldige sleutelwaarde. Sleutel - Integer-waarde"},
            {"errorX","X-coördinaatwaarde is dubbel en> -815"},
            {"errorY","Y-coördinaatwaarde is lang en> -774"},
            {"errorNumber","De waarde van het veld Number_of_wheels is lang en> 0"},
            {"errorEngine","De waarde van het veld Engine Power moet float of groter zijn dan 0"},
            {"enterKey","Voer de sleutel in"},
            {"enterName","Voer een naam in"},
            {"enterX","Specificeer x-coördinaat"},
            {"enterY","Geef een y-coördinaat op"},
            {"enterNumber","Specificeer het aantal wielen"},
            {"enterEngine","Geef het motorvermogen aan"},
            {"enterType","Specificeer het type transport"},
            {"enterFuel","Specificeer het type brandstof"},
            {"bCreate","Maak een"},
            {"File","het dossier"},
            {"enter_File","Specificeer bestand"},
            {"File_was_used","Het bestand dat is opgegeven in de run-methode is al in gebruik, u kunt het niet opnieuw gebruiken"},
            {"error_File","Enkele problemen met het bestand. Probeer het nog eens"},
            {"enter_Id","Voer ID in"},
            {"error_Id","Id -waarde van het type lang"},
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

            {"bHelp", "Helpen"},
            {"bInfo", "Informatie"},
            {"bAdd", "Optellen bij"},
            {"bUpdate", "Vernieuwen"},
            {"bClear", "Doorzichtig"},
            {"bExecuteScript", "Voer script uit"},

            {"lFilter", "Filter"},


            //DATA
            {"dataFormat", "dd.MM.yy"},
            //WORK

    };
}
