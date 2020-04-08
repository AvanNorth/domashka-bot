package orm;

import javax.persistence.*;

@Entity
@Table(name = "things")//название табл
public class Thing {

    //название перменных должно быть таким же, как и в бд, поэтому не изменять!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tag; /* например био, англ, матан...
    Лучше всего это сделать через константы, ну ты это сам понимаешь */

    private String text; // весь текст, где и ссылки на решения и сами задания

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}