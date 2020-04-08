import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class Menu {

    ReplyKeyboardMarkup getMainMenuReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow homeworkRow = new KeyboardRow();
        KeyboardRow answersRow = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        homeworkRow.add("Задания");
        keyboard.add(homeworkRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
    ReplyKeyboardMarkup getAdminMainMenuReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow homeworkRow = new KeyboardRow();
        KeyboardRow editRow = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        homeworkRow.add("Задания");
        editRow.add("Добавить задания");
        keyboard.add(homeworkRow);
        keyboard.add(editRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }

    ReplyKeyboardMarkup getSubjectsKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow mathRow = new KeyboardRow();
        KeyboardRow rusRow = new KeyboardRow();
        KeyboardRow literatureRow = new KeyboardRow();
        KeyboardRow bioRow = new KeyboardRow();
        KeyboardRow physRow = new KeyboardRow();
        KeyboardRow backRow = new KeyboardRow();
        KeyboardRow historyRow = new KeyboardRow();
        KeyboardRow geoRow = new KeyboardRow();
        KeyboardRow peRow = new KeyboardRow();
        KeyboardRow engRow = new KeyboardRow();
        KeyboardRow obshRow = new KeyboardRow();
        KeyboardRow infaRow = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        mathRow.add("Матеша");
        rusRow.add("Русский");
        literatureRow.add("Литра");
        bioRow.add("Биология");
        physRow.add("Физика");
        backRow.add("Назад");
        historyRow.add("История");
        geoRow.add("География");
        peRow.add("Физра");
        engRow.add("Англ");
        obshRow.add("Общага");
        infaRow.add("Инфа");
        keyboard.add(mathRow);
        keyboard.add(rusRow);
        keyboard.add(literatureRow);
        keyboard.add(physRow);
        keyboard.add(bioRow);
        keyboard.add(historyRow);
        keyboard.add(geoRow);
        keyboard.add(peRow);
        keyboard.add(obshRow);
        keyboard.add(engRow);
        keyboard.add(infaRow);
        keyboard.add(backRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
    ReplyKeyboardMarkup getInfReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow shubRow = new KeyboardRow();
        KeyboardRow gr2Row = new KeyboardRow();
        KeyboardRow backRow = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        shubRow.add("Группа Шубинкин В.Н");
        gr2Row.add("Группа Бамбуркина Л.В");
        backRow.add("Назад");
        keyboard.add(shubRow);
        keyboard.add(gr2Row);
        keyboard.add(backRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
    ReplyKeyboardMarkup getMathReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow algRow = new KeyboardRow();
        KeyboardRow geomRow = new KeyboardRow();
        KeyboardRow backRow = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        algRow.add("Алгебра");
        geomRow.add("Геома");
        backRow.add("Назад");
        keyboard.add(algRow);
        keyboard.add(geomRow);
        keyboard.add(backRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
    ReplyKeyboardMarkup getAnglReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow KuzRow = new KeyboardRow();
        KeyboardRow gr2Row = new KeyboardRow();
        KeyboardRow backRow = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        KuzRow.add("Группа Кузьмина Н.О");
        gr2Row.add("Группа Серебрякова М.Г");
        backRow.add("Назад");
        keyboard.add(KuzRow);
        keyboard.add(gr2Row);
        keyboard.add(backRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}
