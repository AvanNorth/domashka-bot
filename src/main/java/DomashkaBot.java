import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DomashkaBot extends TelegramLongPollingCommandBot {
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
            case "Матеша":{
                sendKeyboardMarkupToUser(chatId,menu.getMathReplyKeyboard(),"Выберите раздел");
            break;
           }
            case "Англ":{
                sendKeyboardMarkupToUser(chatId,menu.getAnglReplyKeyboard(),"Выберите группу");
            break;
            }
            case "Инфа":{
                sendKeyboardMarkupToUser(chatId,menu.getMathReplyKeyboard(),"Выберите группу");
            break;
            }
            case "Литра":{

                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
            break;
            }
            case "Биология":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
            break;
            }
            case "Физика":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
            break;
            }
            case "История":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
            break;
            }
            case "Физра":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
            break;
            }
            case "Общага":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
            break;
            }
            case "Группа Шубинкин В.Н":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
                break;
            }
            case "Алгебра":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
                break;
            }
            case "Геома":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
                break;
            }
            case "Группа Бамбуркина Л.В":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
                break;
            }
            case "Группа Кузьмина Н.О":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
                break;
            }
            case "Группа Серебрякова М.Г":{
                //todo скинуть из бд
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
                break;
            }
            default: {
                    sendMessageToUser(chatId, "Извини, но я тебя не понимаю, \nпопробуй нажать /start");
                break;
            }
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
