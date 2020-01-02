/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.login;

import rosagallery.messages.MessageEmpty;
import rosagallery.messages.MessageUpdated;
import rosagallery.admins.WelcomeScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rosagallery.customers.CustomerInfo;
import rosagallery.customers.WelcomeCustomer;
import rosagallery.customers.formEditInfo;
import rosagallery.register.Register;
import rosagallery.login.User;
import rosagallery.admins.AdminsInfo;
import rosagallery.admins.AdminsFormEditInfo;
import rosagallery.items.Arts;
import rosagallery.admins.Admin;
import rosagallery.admins.AddNewAdmin;
import rosagallery.admins.DeleteAdmin;
import rosagallery.artists.Artists;
import rosagallery.artists.AddNewArtist;
import rosagallery.artists.DeleteArtist;
import rosagallery.items.AddNewArt;
import rosagallery.items.DeleteArt;
import rosagallery.customers.SearchView;
import rosagallery.customers.SearchResultsName;
import rosagallery.customers.SearchResultsType;
import rosagallery.customers.SearchByArtistId;
import rosagallery.customers.Favorites;
import rosagallery.items.EditArt;
import rosagallery.artists.EditArtist;
import rosagallery.messages.InvalidLogin;
import rosagallery.messages.MessageEmptyArtistID;
import rosagallery.messages.MessageEmptySearch;

/**
 *
 * @author mrosa
 */

public class Controller implements ActionListener {
    
    // This class has to have a reference to all elements of the program
    public Model model;
    LoginWindow view;
    WelcomeScreen welcome;
    WelcomeCustomer welcome_cus;
    Register registerView;
    public User userLogged;
    CustomerInfo customerInfo;
    public User userRegistered;
    formEditInfo formEditInfo;
    AdminsInfo adminsInfo;
    AdminsFormEditInfo adminsFormEditInfo;
    Arts arts;
    Admin adm;
    AddNewAdmin newAdm;
    DeleteAdmin delAdmin;
    Artists artists;
    AddNewArtist addArtist;
    DeleteArtist delArtist;
    AddNewArt addArt;
    DeleteArt delArt;
    SearchView searchView;
    SearchResultsName resultsName;
    SearchResultsType resultsType;
    SearchByArtistId resultsArtistId;
    Favorites favorites;
    EditArt editArt;
    EditArtist editArtist;
    
    
    // When the controller starts, we need a new model and a new view
    public Controller(){
        
        view = new LoginWindow(this);
        model = new Model();
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getActionCommand().equals("b")){
            
            // Getting the necessary data from the field
            String un = view.getUsername();
            String pw = view.getPassword();
            
            // Create an instance of the user class with the data collated
            userLogged = new User(un, pw);
            
            // Ask the model if the user is valid
            boolean login = model.login(userLogged);
            boolean loginCustomer = model.LoginCustomer(userLogged);
            System.out.println(login);
            
            if(login){
                welcome = new WelcomeScreen(this);
                view.dispose();
            }
            else if(loginCustomer){
                welcome_cus = new WelcomeCustomer(this);
                view.dispose();
            }
            else {
                System.out.println("You should register first");
                // message in case the user is invalid
                new InvalidLogin();
            }
        }
        else if(e.getActionCommand().equals("b2")){
            
            // creating a new instance of Register class
            registerView = new Register(this);
            
        }
        else if(e.getActionCommand().equals("b3")){
            //new Register(this);
            
            // Getting the data from textfields, storing in Strings
            String name = registerView.getName2();
            String email = registerView.getEmail();
            String username = registerView.getUsername();
            String password = registerView.getPassword();
            String address = registerView.getAddress();
            
            userRegistered = new User(name, email, address, username, password);
            
            //making the registration
            model.register(userRegistered);
            
            //showing that something has changed
            new MessageUpdated();
            
            //closing the views
            view.dispose();
            registerView.dispose();
            
            //opening the new view to make the Login
            view = new LoginWindow(this);
            model = new Model();
            
        }
        
        else if(e.getActionCommand().equals("b4")){
            //display info
            System.out.println("update informations");
            //changing view, because the applications is using buttons to go back to dashboard
            welcome_cus.setVisible(false);
            customerInfo = new CustomerInfo(this); 
        }
        
        else if(e.getActionCommand().equals("b5")){
            //logout customer
            welcome_cus.dispose();
            view = new LoginWindow(this);
            model = new Model();
        }
        
        else if(e.getActionCommand().equals("b6")){
            //favorites
            String pass = userLogged.getPw();
            //System.out.println(pass);
            model.Favorites(pass);
            welcome_cus.setVisible(false);
            favorites = new Favorites(this);
            
        }
        else if(e.getActionCommand().equals("b7")){
            // Open a new form to input data to be updated
            formEditInfo = new formEditInfo(this);
            
        }
        else if(e.getActionCommand().equals("b8")){
            // Update the information edited on the previous form
            String pass = userLogged.getPw();
            System.out.println(pass);
            
            //getting data from textfields
            String newName = formEditInfo.name.getText();
            String newUsername = formEditInfo.username.getText();
            String newAddress = formEditInfo.address.getText();
            String newEmail = formEditInfo.email.getText();
            String newPassword = formEditInfo.password.getText();
            
            //calling the method created in the model
            model.updateCusInfo(userRegistered, pass, newName, newUsername, newAddress, newEmail, newPassword);
            
        }
        
        else if(e.getActionCommand().equals("b9")){
            //Show Admins Informations
            System.out.println("update informations");
            welcome.setVisible(false);
            adminsInfo = new AdminsInfo(this);
        }
        
        else if(e.getActionCommand().equals("b10")){
            // Admin's Logout
            welcome.dispose();
            view = new LoginWindow(this);
            model = new Model();
        }
        
        else if(e.getActionCommand().equals("b11")){
            // Open a new form to input data to be updated
            adminsFormEditInfo = new AdminsFormEditInfo(this);
        }
        
        else if(e.getActionCommand().equals("b12")){
            // Update the information edited on the previous form
            // Getting necessary data to perfom the change
            String pass = userLogged.getPw();
            System.out.println(pass);
            String newName = adminsFormEditInfo.name.getText();
            String newUsername = adminsFormEditInfo.username.getText();
            String newEmail = adminsFormEditInfo.email.getText();
            String newPassword = adminsFormEditInfo.password.getText();
            // Calling the method created on model, passing necessary data to be updated
            model.updateAdminsInfo(userRegistered, pass, newName, newUsername, newName, newEmail, newPassword);
        }
        
        else if(e.getActionCommand().equals("b13")){
            //Arts - Items
            welcome.setVisible(false);
            arts = new Arts(this);
        }
        
        else if(e.getActionCommand().equals("b14")){
            //Add New Piece of Art - Btn
            addArt = new AddNewArt(this);
        }
        
        else if(e.getActionCommand().equals("b14_1")){
            //Add New Piece of Art - Performing
            String name = addArt.name.getText();
            String description = addArt.description.getText();
            String type = addArt.type.getText();
            String artist = addArt.artist.getText();
            model.CreateNewArt(name, description, type, artist);
            
        }
        
        else if(e.getActionCommand().equals("b15")){
            //Delete one piece of art - btn
            delArt = new DeleteArt(this);
        }
        
        else if(e.getActionCommand().equals("b15_1")){
            //Delete one piece of art - Performing
            String name = delArt.name.getText();
            model.DeleteArt(name);
        }
        
        else if(e.getActionCommand().equals("b16")){
            //Admins
            welcome.setVisible(false);
            adm = new Admin(this);
        }
        
        else if(e.getActionCommand().equals("b17")){
            //Add new admin - btn
            newAdm = new AddNewAdmin(this);
            
        }
        
        else if(e.getActionCommand().equals("b17_1")){
            //Creating new admin
            String newName = newAdm.name.getText();
            String newUsername = newAdm.username.getText();
            String newEmail = newAdm.email.getText();
            String newPassword = newAdm.password.getText();
            model.CreateNewAdmin(newName, newUsername, newEmail, newPassword);
            
        }
        
        else if(e.getActionCommand().equals("b18")){
            //Delete new admin - btn
            delAdmin = new DeleteAdmin(this);
        }
        
        else if(e.getActionCommand().equals("b18_1")){
            //Delete new admin - Performing
            //DELETE FROM table_name WHERE condition;
            String username = delAdmin.username.getText();
            model.DeleteAdmin(username);
        }
        
        else if(e.getActionCommand().equals("b19")){
            //Artists
            welcome.setVisible(false);
            artists = new Artists(this);
        }
        
        else if(e.getActionCommand().equals("b20")){
            //Artists
            addArtist = new AddNewArtist(this);
        }
        
        else if(e.getActionCommand().equals("b20_1")){
            //Adding new artist - btn
            String name = addArtist.name.getText();
            String address = addArtist.address.getText();
            String website = addArtist.website.getText();
            model.CreateNewArtist(name, address, website);
        }
        
        else if(e.getActionCommand().equals("b21")){
            //Delete one artist - btn
            delArtist = new DeleteArtist(this);
        }
        
        else if(e.getActionCommand().equals("b21_1")){
            //Delete one artist - btn
            String name = delArtist.name.getText();
            model.DeleteArtist(name);
        }
        
        else if(e.getActionCommand().equals("b22")){
            // Search btn - will open a new view and then the buttons inside the new view will perform the search
            welcome_cus.setVisible(false);
            searchView = new SearchView(this);
        }
        
        else if(e.getActionCommand().equals("SearchByName")){
            // Search by Art Name
            String name = searchView.artName.getText();
            System.out.println(name);
            //checking if something has been typed
            if(!name.isEmpty()){
                model.searchByName(this);
                resultsName = new SearchResultsName(this);
            }else{
                new MessageEmptySearch();
            }
            
            
        }
        else if(e.getActionCommand().equals("SearchByType")){
            // Search by Art type
            String type = searchView.artType.getText();
            System.out.println(type);
            if(!type.isEmpty()){
                model.searchByType(this);
                resultsType = new SearchResultsType(this);
            }else{
                new MessageEmptySearch();
            }
            
            
        }
        else if(e.getActionCommand().equals("SearchByArtistId")){
            // Search by Artist ID;
            String artistId = searchView.artistName.getText();
            System.out.println(artistId);
            if(!artistId.isEmpty()){
                model.searchByArtistId(this);
                resultsArtistId = new SearchByArtistId(this);
            }else{
                new MessageEmptySearch();
            }
            
        }
        else if(e.getActionCommand().equals("like")){
            // like 
            model.likes(this);
        }
        
        else if(e.getActionCommand().equals("editArt")){
            // Edit piece of art - Opening new window to update it
            String artID = arts.idArtUp.getText();
            if(artID.isEmpty()){
                new MessageEmpty();
            }else{
                editArt = new EditArt(this, artID);
            }
            
        }
        else if(e.getActionCommand().equals("updateArt")){
            // Edit piece of art - Opening new window to update it
            String artID = arts.idArtUp.getText();
            String newNameArt = editArt.name.getText();
            String newDescription = editArt.description.getText();
            String newType = editArt.type.getText();
            String newArtist = editArt.artist.getText();
            model.updateArt(artID, newNameArt, newDescription, newType, newArtist);
        }
        
        else if(e.getActionCommand().equals("editArtist")){
            // Edit piece of art - Opening new window to update it
            String artistID = artists.idArtistUp.getText();
            if(artistID.isEmpty()){
                new MessageEmptyArtistID();
            }else{
                editArtist = new EditArtist(this, artistID);
            }
        }
        
        else if(e.getActionCommand().equals("updateArtist")){
            // Edit piece of art - Opening new window to update it
            String artistID = artists.idArtistUp.getText();
            String newArtistName = editArtist.name.getText();
            String newArtistAddress = editArtist.address.getText();
            String newArtistWebsite = editArtist.website.getText();
            model.updateArtist(artistID, newArtistName, newArtistAddress, newArtistWebsite);
        }
        
        else if(e.getActionCommand().equals("backFromFav")){
            // go back to dashboard comming from favorites
            favorites.dispose();
            welcome_cus.setVisible(true);
        }
        
        else if(e.getActionCommand().equals("backFromSearch")){
            // go back to dashboard comming from favorites
            searchView.dispose();
            welcome_cus.setVisible(true);
        }
        
        else if(e.getActionCommand().equals("backFromCusInfo")){
            // go back to dashboard comming from favorites
            customerInfo.dispose();
            welcome_cus.setVisible(true);
        }
        
        else if(e.getActionCommand().equals("backFromAdmin")){
            // go back to dashboard comming from Admin List
            adm.dispose();
            welcome.setVisible(true);
        }
        
        else if(e.getActionCommand().equals("backFromArt")){
            // go back to dashboard comming from Art List
            arts.dispose();
            welcome.setVisible(true);
        }
        
        else if(e.getActionCommand().equals("backFromArtist")){
            // go back to dashboard comming from Artist List
            artists.dispose();
            welcome.setVisible(true);
        }
        
        else if(e.getActionCommand().equals("backFromAdminInfo")){
            // go back to dashboard comming from Admin's Info
            adminsInfo.dispose();
            welcome.setVisible(true);
        }
        
    }
    
}
