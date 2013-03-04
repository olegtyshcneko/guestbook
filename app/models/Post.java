package models;

import javax.persistence.*;
import play.db.jpa.*;

import java.util.Date;

@Entity
public class Post extends Model {
    @Lob
    public String message;
    public int rating;
    public Date messageTime;

    public Post(String message) {
        this.message = message;
        this.rating = 1;
        this.messageTime = new Date();
    }

}
