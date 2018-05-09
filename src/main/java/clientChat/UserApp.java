package clientChat;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity // This tells Hibernate to make a table out of this class
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mName;
    private String password;
    private String email;
    private String age;
    private String city;
    private byte[] image;
    private ArrayList<Long> eventsSub = new ArrayList<>();

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEventsSub(ArrayList<Long> eventsSub) {
        this.eventsSub = eventsSub;
    }

    public ArrayList<Long> getEventsSub() {
        return eventsSub;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        mName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
