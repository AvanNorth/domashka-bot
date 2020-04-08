import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import orm.Thing;
import orm.ThingDao;

public class DomashkaBot extends TelegramLongPollingCommandBot {

    private boolean isInEdit = false;
    private Thing thing;
    private ThingDao dao = new ThingDao();


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
                if(chatId == 430148873 || chatId == 339293658 || chatId == 396945086){
                    isInEdit = true;
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
                if (isInEdit){
                    thing.setText(msg.getText());
                    dao.save(thing);
                    isInEdit = false;
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
        if (chatId == 430148873 || chatId == 339293658 || chatId == 396945086){
            sendKeyboardMarkupToUser(chatId,menu.getAdminMainMenuReplyKeyboard(),"<<");
        }else
            sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"<<");
    }

    private void handleSubject(String subject,long chatId){
        String lastText;
        if ((isInEdit && chatId == 430148873) || (isInEdit && chatId == 339293658)||(isInEdit && chatId == 396945086)) {
            thing = new Thing();
            thing.setTag(subject);
            sendMessageToUser(chatId,"Отправьте мне новое дз");
        }else{
            lastText = dao.getLast(subject).getText();
            if(lastText==null)
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
