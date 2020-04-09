import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import orm.Thing;
import orm.ThingDao;

import java.util.Arrays;

public class DomashkaBot extends TelegramLongPollingCommandBot {

   // private boolean isInEdit = false;
    private Thing thing;
    private Thing isInEdit;
    private ThingDao dao = new ThingDao();
   //todo перенести в константы
   private String[] admins = {"430148873","339293658","396945086"};
   private String[] subjects =
           {
           "Алгебра",
           "Геома",
           "Егэ",
           "Русский",
           "Литра",
           "Биология",
           "Физика",
           "История",
           "География",
           "Физра",
           "Общага",
           "Группа Кузьмина Н.О",
           "Группа Серебрякова М.Г",
           "Группа Шубинкин В.Н",
           "Группа Бамбуркина Л.В",
            };


    public DomashkaBot() {
        StartCommand startCommand = new StartCommand(this);
        register(startCommand);
    }

    public String getBotUsername() {
        return "Domashka";
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        Message msg = update.getMessage();
        long chatId = msg.getChatId();
        Menu menu = new Menu();

        switch (msg.getText()) {
            case "Задания":{
                sendKeyboardMarkupToUser(chatId,menu.getSubjectsKeyboard(),"Выберите предмет");
                break;
            }
            case "Добавить задания":{
                if(isAdmin(chatId)){//chatId == 430148873 || chatId == 339293658 || chatId == 396945086){
                    isInEdit = new Thing();
                    isInEdit = dao.getLast(Long.toString(chatId));
                    isInEdit.setText("true");
                    dao.update(isInEdit);
                    //isInEdit = true;
                    sendKeyboardMarkupToUser(chatId,menu.getSubjectsKeyboard(),"Выберите предмет");
                }else{
                    sendMessageToUser(chatId, "У вас нет админ-прав!");
                }
                break;
            }
            case "Назад":{
                returnToMenu(chatId);
                break;
            }
            case "Матеша":{
                sendKeyboardMarkupToUser(chatId,menu.getMathReplyKeyboard(),"Выберите раздел");
            break;
           }
            case "Англ":{
                sendKeyboardMarkupToUser(chatId,menu.getAnglReplyKeyboard(),"Выберите группу");
            break;
            }
            case "Инфа":{
                sendKeyboardMarkupToUser(chatId,menu.getInfReplyKeyboard(),"Выберите группу");
            break;
            }
            case "Литра":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
            break;
            }
            case "Биология":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
            break;
            }
            case "Физика":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
            break;
            }
            case "ЕГЭ":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
                break;
            }
            case "История":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
            break;
            }
            case "Русский":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
                break;
            }
            case "Физра":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
            break;
            }
            case "Общага":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
            break;
            }
            case "Группа Шубинкин В.Н":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
                break;
            }
            case "Алгебра":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
                break;
            }
            case "Геома":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
                break;
            }
            case "Группа Бамбуркина Л.В":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
                break;
            }
            case "Группа Кузьмина Н.О":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
                break;
            }
            case "Группа Серебрякова М.Г":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
                break;
            }
            case "География":{
                handleSubject(msg.getText(),chatId);
                returnToMenu(chatId);
                break;
            }
            default: {
                if (isAdmin(chatId)&&dao.getLast(Long.toString(chatId)).getText().equals("true")){//(isInEdit && chatId == 430148873) || (isInEdit && chatId == 339293658)||(isInEdit && chatId == 396945086)){
                    //todo сделать красиво и хорошо (если руки дойдут вообще)
                    thing.setText(msg.getText());
                    dao.update(thing);
                    isInEdit = dao.getLast(Long.toString(chatId));
                    isInEdit.setText("false");
                    dao.update(isInEdit);
                    sendMessageToUser(chatId,"Изменения сохранены");
                    //todo дата и актуальность
                }else
                    sendMessageToUser(chatId, "Извини, но я тебя не понимаю, \nпопробуй нажать /start");
                break;
            }
        }
    }


    private void returnToMenu(long chatId){
        Menu menu = new Menu();
        if (isAdmin(chatId)){
            sendKeyboardMarkupToUser(chatId,menu.getAdminMainMenuReplyKeyboard(),"<<");
        }else
            sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"<<");
    }

    private boolean isAdmin(long chatId){
        return Arrays.asList(admins).contains(Long.toString(chatId));
    }


    private void handleSubject(String subject,long chatId){
        String lastText;
        if (isAdmin(chatId)&&dao.getLast(Long.toString(chatId)).getText().equals("true")) {
            thing = dao.getLast(subject);
            sendMessageToUser(chatId,"Отправьте мне новое дз");
        }else{
            lastText = dao.getLast(subject).getText();
            if(dao.getLast(subject)==null)
                sendMessageToUser(chatId,"Тут ничего нет(");
            else
                sendMessageToUser(chatId,lastText);
            System.out.println(dao.getLast(subject).getText());
        }
    }

    private void sendMessageToUser(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(chatId);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.err.println(e);
        }
    }

    private void sendKeyboardMarkupToUser(long chatId, ReplyKeyboardMarkup replyKeyboardMarkup, String reply) {
        SendMessage message = new SendMessage();
        message.setReplyMarkup(replyKeyboardMarkup);
        message.setText(reply);
        message.setChatId(chatId);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.err.println(e);
        }
    }


    @Override
    public String getBotToken() {
        return "1105354299:AAEcAnb7sXnnPS3tRoEy0Gjk3QDc2PvFrxk";
    }

}
