/**
 *
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author snipper
 *
 */
public class TimetableController implements Initializable{


    private CalendarView calendar;

    @FXML
    private GridPane panelHost;

    @FXML
    private Button btnHome;

    public void handleHome(){
    	 btnHome.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					try {
					Parent	home= FXMLLoader.load(getClass().getResource("Home.fxml"));
				      Stage stage=new Stage();
				      stage.setTitle("Genius Home");
				      stage.setScene(new Scene(home));
				      stage.show();
				      //hide the current window.
				  ((Node) event.getSource()).getScene().getWindow().hide();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			  });
    }
	public TimetableController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
     loadCalender();

	}

	private void loadCalender() {
		 calendar = new CalendarView();

	        Calendar classes = new Calendar("Classes");
	        Calendar meetings = new Calendar("Meetings");

	        classes.setStyle(Calendar.Style.STYLE7);
	        meetings.setStyle(Calendar.Style.STYLE2);

	        CalendarSource myCalendarSource = new CalendarSource("Timetable");
	        myCalendarSource.getCalendars().addAll(classes, meetings);

	        calendar.getCalendarSources().addAll(myCalendarSource);

	        calendar.setRequestedTime(LocalTime.now());


	        Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
	            @Override
	            public void run() {
	                while (true) {
	                    Platform.runLater(() -> {
	                        calendar.setToday(LocalDate.now());
	                        calendar.setTime(LocalTime.now());
	                    });

	                    try {
	                        // update every 10 seconds
	                        sleep(10000);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }

	                }
	            }
	        };

	        updateTimeThread.setPriority(Thread.MIN_PRIORITY);
	        updateTimeThread.setDaemon(true);
	        updateTimeThread.start();

	        calendar.showMonthPage();
	        panelHost.getChildren().add(calendar);

	}

}
