package clientChat;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * Created by user on 07.05.2018.
 */
public class Afisha extends javafx.application.Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String url = "http://bipbap.ru/wp-content/uploads/2017/04/leto_derevo_nebo_peyzazh_dom_derevya_domik_priroda_3000x2000.jpg";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        byte[] imageBytes = restTemplate.getForObject(url, byte[].class);

//        InputStream in = new ByteArrayInputStream(s.getBytes());
//        FileOutputStream out = new FileOutputStream(new File("result.png"));
//
//        byte[] data = new byte[2048];
//        int counter = 0;
//        while((counter = in.read(data)) > 0){
//            out.write(data);
//        }
//        in.close();
//        out.close();

        Pane root = new Pane();
        ImageView view = new ImageView(new Image(new ByteArrayInputStream(imageBytes)));
        root.getChildren().addAll(view);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
