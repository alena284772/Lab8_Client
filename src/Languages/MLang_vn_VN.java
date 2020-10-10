package Languages;

import java.util.ListResourceBundle;

public class MLang_vn_VN extends ListResourceBundle {

    @Override
    public Object[][] getContents() {
        return contents;
    }

    private static final Object[][] contents = {
            //BUTTON
            {"eLanguage","Válassz nyelvet"},
            {"bChoose","Választ"},
            {"LLanguage","Nyelvek"},
            {"bShow", "előadás"},
            {"bSend","Üzenet küldése"},
            {"LAnswer","Szerver válasza"},
            {"LEnter","Adja meg a szerver címét (üresen is hagyható)"},
            {"LEnterPort","Adja meg a portot"},
            {"WrongPort","Érvénytelen port"},
            {"Regtitle","bemenet"},
            {"SIButton","Bejönni"},
            {"RegButton","Regisztrálj most"},
            {"Login","Belépés:"},
            {"Password","Jelszó:"},
            {"good_answer","Az engedélyezés sikeres volt."},
            {"pas_inc_answer","hibás jelszó"},
            {"user_inc_answer","Nincs felhasználó ezzel a bejelentkezéssel."},
            {"user_ex_answer","Azonos nevű felhasználó már létezik"},
            {"server_error_answer","Jelenleg nincs hozzáférés a szerverhez. Kérlek, próbáld újra később"},
            {"lang_title","Nyelvválasztás"},
            {"bremove_key","Törlés kulccsal"},
            {"bremove_greater","Távolítsa el a túllépést"},
            {"bhistory","Történelem"},
            {"bupdate","Frissítés"},
            {"breplace_if_greater","Cserélje nagyra"},
            {"bremove_any","Távolítson el minden kerekek számát"},
            {"bcount_less","Számoljon kevesebbet, mint a motor teljesítménye"},
            {"bprint_field","A típusok növekvő sorrendben"},
            {"bexecute_script","Futtassa a szkriptet"},
            {"cblanguages","nyelveket"},
            {"LUser","Felhasználó"},
            {"CDColumn","létrehozásának dátuma"},
            {"NameColumn","Név"},
            {"KeyColumn","Kulcs"},
            {"CXColumn","X koordináta"},
            {"CYColumn","Y koordináta"},
            {"EPColumn","A motor teljesítménye"},
            {"NOWColumn","A kerekek száma"},
            {"TypeColumn","Szállítási típus"},
            {"FuelTypeColumn","Üzemanyagtípus"},
            {"UserColumn","Tulajdonos"},
            {"bShowData","A rendelkezésre álló adatok megjelenítése"},
            {"bChange","Szerkesztés"},
            {"bDelete","Töröl"},
            {"errorKey","Érvénytelen kulcsérték. Kulcs - Egész érték"},
            {"errorX","Az X koordináta értéke kettős, és> -815"},
            {"errorY","Az Y koordináta értéke hosszú és> -774"},
            {"errorNumber","A Kerekek száma_mező értéke hosszú és> 0"},
            {"errorEngine","A motor teljesítmény mezőértékének úszónak vagy 0-nál nagyobbnak kell lennie"},
            {"enterKey","Adja meg a kulcsot"},
            {"enterName","Kérjük, adjon meg egy nevet"},
            {"enterX","Adjon meg x koordinátát"},
            {"enterY","Adja meg az y koordinátát"},
            {"enterNumber","Adja meg a kerekek számát"},
            {"enterEngine","Adja meg a motor teljesítményét"},
            {"enterType","Adja meg a szállítás típusát"},
            {"enterFuel","Adja meg az üzemanyag típusát"},
            {"bCreate","Hozzon létre egy"},
            {"File","File"},
            {"enter_File","Adja meg a fájlt"},
            {"File_was_used","A futtatási módszerben megadott fájl már használatban van, nem használhatja újra"},
            {"error_File","Néhány probléma a fájllal. Próbáld újra"},
            {"enter_Id","Adja meg az azonosítót"},
            {"error_Id","Id - hosszú típusú érték"},
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

            {"bHelp", "Segítség"},
            {"bInfo", "Információ"},
            {"bAdd", "Hozzáadás ehhez:"},
            {"bUpdate", "Frissítés"},
            {"bClear", "Egyértelmű"},
            {"bExecuteScript", "Futtassa a szkriptet"},

            {"lFilter", "Szűrő"},


            //DATA
            {"dataFormat", "dd.MM.yy"},
            //WORK

    };
}
