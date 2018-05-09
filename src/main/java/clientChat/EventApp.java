package clientChat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by user on 22.04.2018.
 */
@Entity
public class EventApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String decription;
    private String author;
    private byte[] image;

    private String date;
    private String kind;
    private String time;

    private String place;
    private ArrayList<String> people = new ArrayList<>();
    private ArrayList<Dialogue> message = new ArrayList<>();


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getKind() {
        return kind;
    }

    public String getTime() {
        return time;
    }

    public void setMessage(ArrayList<Dialogue> message) {
        this.message = message;
    }

    public ArrayList<Dialogue> getMessage() {
        return message;
    }

    public void setPeople(ArrayList<String> people) {
        this.people = people;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getDecription() {
        return decription;
    }

    public String getPlace() {
        return place;
    }

    public ArrayList<String> getPeople() {
        return people;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void addPeople(String people) {
        this.people.add(people);
    }
}
