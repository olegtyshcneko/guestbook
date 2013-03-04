package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;
import java.util.*;
import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void book() {
        List<Post> posts =
                Post.find("order by messageTime desc").fetch();
        render(posts);
    }

    public static void addPost(@Required String message) {
        if(validation.hasErrors()) {
            redirect("/book");
        }

        new Post(message).save();
        redirect("/book");
    }

    public static void editPost(Long postId, @Required String message) {
        if(validation.hasErrors()) {
            redirect("/book");
        }

        Post p = Post.findById(postId);

        p.message = message;
        p.save();
        redirect("/book");
    }

    public static void removePost(Long postId) {
        Post.findById(postId)._delete();
        redirect("/book");
    }

    public static void updateRating(Long postId, int newRating) {
        Post p =Post.findById(postId);

        p.rating = newRating;
        p.save();
    }
}