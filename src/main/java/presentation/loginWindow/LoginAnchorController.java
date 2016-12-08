package presentation.loginWindow;


import businesslogic.userbl.client.ClientController;
import businesslogic.userbl.netsale.NetsaleController;
import businesslogic.userbl.networker.NetworkerController;
import businesslogicservice.userblservice.Login;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import presentation.ClientWindow.RunClient1;
import presentation.NetWorkerWindow.RunNetworker;
import util.ResultMessage;
public class LoginAnchorController {
	@FXML
	TextField accountField;
	@FXML
	PasswordField passwordField;
	@FXML
	ImageView login;
	@FXML
	ImageView register;
	@FXML
	Button loginButton;
	@FXML
	Button registerButton;
	@FXML
	Label account;
	@FXML
	Label password;
	@FXML
	ImageView logo;
	@FXML
	RunLogin runLogin;
	
	
	
	
	
	//构造
	public LoginAnchorController(){
		
	}
	@FXML
	public void LoginClicked(){
		//判断账号和密码
		try{
		if(accountField.getText().charAt(0)=='s'){
			
			
		}else if(accountField.getText().charAt(0)=='h'){
			
		}else if(accountField.getText().charAt(0)=='m'){
			NetworkerController lg=new NetworkerController();
			ResultMessage rm=lg.login(accountField.getText(), passwordField.getText());
			if(rm==ResultMessage.SUCCESS){
				RunNetworker rc=new RunNetworker();
				rc.setanchor1(1);
				
				rc.start(new Stage());
				runLogin.getPrimaryStage().close();
			}else{
				//添加 登录失败弹窗
			}
		}else{
			ClientController lg=new ClientController();
			ResultMessage rm=lg.login(accountField.getText(), passwordField.getText());
			if(rm==ResultMessage.SUCCESS){
				RunClient1 rc=new RunClient1();
				rc.SetAnchor1(1);
				rc.SetClientVO(lg.getClientInfo(accountField.getText()));
				rc.start(new Stage());
				runLogin.getPrimaryStage().close();
			}else{
				//添加 登录失败弹窗
			}
		}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	
	private void initialize() {
        // Initialize the person table with the two columns.
		try{
		       login.setImage(new Image("file:src/lib/yes.png"));
		       register.setImage(new Image("file:src/lib/no.png"));
		       
		        }catch(Exception e){
		        	e.printStackTrace();
		        }
        
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setRunLogin(RunLogin runLogin) {
        this.runLogin = runLogin;

        // Add observable list data to the table
        initialize();
        try{
       logo.setImage(new Image("file:src/lib/logo.png"));
       
        }catch(Exception e){
        	e.printStackTrace();
        }
    }

}