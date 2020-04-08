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
        answersRow.add("Ответы");
        keyboard.add(homeworkRow);
        keyboard.add(answersRow);
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
        keyboard.add(rusRow);
        keyboard.add(literatureRow);
        keyboard.add(physRow);
        keyboard.add(bioRow);
        keyboard.add(historyRow);
        keyboard.add(geoRow);
        keyboard.add(peRow);
        keyboard.add(backRow);
        keyboard.add(obshRow);
        keyboard.add(engRow);
        keyboard.add(infaRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
    ReplyKeyboardMarkup getInfReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow shubRow = new KeyboardRow();
        KeyboardRow gr2Row = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        shubRow.add("Группа Шубинкин В.Н");
        gr2Row.add("Группа Бамбуркина Л.В");
        keyboard.add(shubRow);
        keyboard.add(gr2Row);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
    ReplyKeyboardMarkup getMathReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow algRow = new KeyboardRow();
        KeyboardRow geomRow = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        algRow.add("Алгебра");
        geomRow.add("Геома");
        keyboard.add(algRow);
        keyboard.add(geomRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
    ReplyKeyboardMarkup getAnglReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow KuzRow = new KeyboardRow();
        KeyboardRow gr2Row = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        KuzRow.add("Группа Кузьмина Н.О");
        gr2Row.add("Группа Серебрякова М.Г");
        keyboard.add(KuzRow);
        keyboard.add(gr2Row);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}
