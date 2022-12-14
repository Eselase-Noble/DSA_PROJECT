package com.example.g22dsainventorysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {


        @FXML
        private AnchorPane acDashBord;

        @FXML
        private AnchorPane acHead;

        @FXML
        private AnchorPane base;

        @FXML
        private AnchorPane acMain;

        @FXML
        private BorderPane bp;

        @FXML
        private BorderPane appContent;

        @FXML
        private Button btnAbout;

        @FXML
        private Button btnEmplopye;

        @FXML
        private Button btnLogOut;

        @FXML
        private Button btnSell;

        @FXML
        private Button btnStore1;

        @FXML
        private Circle circleImgUsr;

        @FXML
        private Hyperlink hlEditUpdateAccount;

        @FXML
        private ImageView imgAboutBtn;

        @FXML
        private ImageView imgEmployeBtn;

        @FXML
        private ImageView imgMenuBtn;

        @FXML
        private ImageView imgSellBtn;

        @FXML
        private ImageView imgStoreBtn1;

        @FXML
        private Circle imgUsrTop;

        @FXML
        private Label lblFullName;

        @FXML
        private Label lblRoleAs;

        @FXML
        private Label lblUserId;

        @FXML
        private Label lblUsrName;

        @FXML
        private Label lblUsrNamePopOver;

        @FXML
        private ScrollPane leftSideBarScroolPan;

        @FXML
        private MenuButton mbtnUsrInfoBox;

        @FXML
        private MenuItem miPopOver;

        @FXML
        private ToggleButton sideMenuToogleBtn;


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }

        @FXML
        private void acMain(KeyEvent event) {
                if (event.getCode() == KeyCode.F11) {
                        Stage stage = (Stage) acMain.getScene().getWindow();
                        stage.setFullScreen(true);
                }
        }

        public void btnHomeOnClick(ActionEvent actionEvent) {
                bp.setCenter(base);
        }

        public void btnSellOnClick(ActionEvent actionEvent) {
        }

        public void btnSettingsOnClick(ActionEvent actionEvent) {
        }

        public void btnAboutOnClick(ActionEvent actionEvent) {
        }

        public void btnCategoryOnClick() throws IOException {
                loadPage("view/screens/Products/ViewCategory");
        }

        public void btnProductOnClick() throws IOException {
                loadPage("view/screens/Products/ViewProducts");
        }

        public void btnVendorOnClick() throws IOException{
                loadPage("view/screens/Vendor/ViewVendor");

        }

        public void btnBillOnClick()throws IOException{
                loadPage("view/screens/Bills/ViewBills");

        }

        public void btnSaleOnClick() throws IOException{
                loadPage("view/screens/IssuedGoods/ViewIssuedGoods");

        }
        private void loadPage(String page){
              Parent root = null;
              try {
                      root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
              } catch(IOException ex){
                      System.out.printf("Code not set right");
              }
              bp.setCenter(root);
        }


    public void Generatereport(ActionEvent event) {
            URL fxmlLocation = HelloApplication.class.getResource("view/screens/Report/Overview.fxml");
            FXMLLoader loader5 = new FXMLLoader(fxmlLocation);
            try {
                    loader5.load();
                    Parent parent = loader5.getRoot();
                    Scene scene = new Scene(parent);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.initModality(Modality.APPLICATION_MODAL);

                    stage.show();
            }catch (IOException e) {
                    e.printStackTrace();
            }
    }
}
