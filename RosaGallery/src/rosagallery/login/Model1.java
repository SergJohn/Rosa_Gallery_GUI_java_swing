/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosagallery.login;

import rosagallery.messages.Message;
import rosagallery.messages.MessageUpdated;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import rosagallery.messages.Done;

/**
 *
 * @author mrosa
 */

public class Model {
    
    String dbServer = "jdbc:mysql://'address'/'dbname'";
    String user = "user";
    String password = "password";
    Connection conn = null;
    Statement stmt = null;
    
    public Model(){
        
        try{
            // Get a connection to the database
            conn = DriverManager.getConnection(dbServer, user, password) ;

            // Get a statement from the connection
            stmt = conn.createStatement() ;
        }
        catch( SQLException se){
            System.out.println("SQL Exception:");
            
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    //method to check the admin login
    public boolean login(User userLogged){
        
        boolean login = false;
        try{
            // Building the query
            String query = "SELECT * FROM admins WHERE adm_username = '" + userLogged.getUn() + "' AND adm_pwd = '" + userLogged.getPw() + "';";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query) ;
            
            // If there is an entry in the database that satisfies
            // the username and password, then the login is successful
            // otherwise it fails
            login = rs.next();

        }
        catch(SQLException se){
            System.out.println("SQL Exception:");
            
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
        
        return login;
    }
    
    //method to login a customer
    public boolean LoginCustomer(User userLogged){
        
        boolean loginCustomer = false;
        try{
            // Building the query
            String query = "SELECT * FROM customers WHERE cus_username = '" + userLogged.getUn() + "' AND cus_pwd = '" + userLogged.getPw() + "';";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query) ;
            
            // If there is an entry in the database that satisfies
            // the username and password, then the login is successful
            // otherwise it fails
            loginCustomer = rs.next();

        }
        catch(SQLException se){
            System.out.println("SQL Exception:");
            
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
        
        return loginCustomer;
    }
    
    //finding customer informations
    public String[][] customerInformations(String pass){
        
        String[][] info = null;
        try{
            String query = "SELECT * FROM customers WHERE cus_pwd = '" + pass + "';";
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            // Building the query
            String query2 = "SELECT * FROM customers WHERE cus_pwd = '" + pass + "';";

            ResultSet rs2 = stmt.executeQuery(query2);
            
            //info = rs2.next();
            info = new String[line][6];
            int row = 0;
            

            while(rs2.next()) {
		System.out.println(rs2.getString("idcustomers") + "\t" + rs2.getString("cus_name") + "\t" + rs2.getString("cus_username") + 
						"\t" + rs2.getString("cus_address") + "\t" + rs2.getString("cus_email") + "\t" + rs2.getString("cus_pwd")) ;
                // UP TO HERE EVERYTHING IS WORKING, I AM GETTING ALL THE VALUES AND PRINTING ON THE CONSOLE, NOW I NEED TO PUT IT INSIDE A TABLE
                info[row][0] = rs2.getString("idcustomers");
                info[row][1] = rs2.getString("cus_name");
                info[row][2] = rs2.getString("cus_username");
                info[row][3] = rs2.getString("cus_address");
                info[row][4] = rs2.getString("cus_email");
                info[row][5] = rs2.getString("cus_pwd");
                row++;
                                
            }
	

        }
        catch(SQLException se){
            System.out.println("SQL Exception:");
            
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
        
        return info;
    }
    
    //finding admin informations
    public String[][] adminInformations(String pass){
        
        String[][] info = null;
        try{
            String query = "SELECT * FROM admins WHERE adm_pwd = '" + pass + "';";
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            // Building the query
            String query2 = "SELECT * FROM admins WHERE adm_pwd = '" + pass + "';";

            ResultSet rs2 = stmt.executeQuery(query2);
            
            //info = rs2.next();
            info = new String[line][5];
            int row = 0;
            

            while(rs2.next()) {
		System.out.println(rs2.getString("idadmins") + "\t" + rs2.getString("adm_name") + "\t" + rs2.getString("adm_email") + 
						"\t" + rs2.getString("adm_username") + "\t" + rs2.getString("adm_pwd")) ;
                // UP TO HERE EVERYTHING IS WORKING, I AM GETTING ALL THE VALUES AND PRINTING ON THE CONSOLE, NOW I NEED TO PUT IT INSIDE A TABLE
                info[row][0] = rs2.getString("idadmins");
                info[row][1] = rs2.getString("adm_name");
                info[row][2] = rs2.getString("adm_email");
                info[row][3] = rs2.getString("adm_username");
                info[row][4] = rs2.getString("adm_pwd");
                row++;
                                
            }
	

        }
        catch(SQLException se){
            System.out.println("SQL Exception:");
            
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
                System.out.println( e ) ;
        }
        
        return info;
    }
    
    //Filling an array with all items inside database whenever it is called
    public String[][] connection() {
        
        String[][] data = null;
        
        try{
            // Building the query
            String query = "SELECT * FROM items;";
            String query2 = "SELECT * FROM items;";
            
            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            
            ResultSet rs2 = stmt.executeQuery(query2);
            
            data = new String[line][5];
                        int row = 0;
                        
			// Loop through the result set
			while(rs2.next()) {
				System.out.println(rs2.getString("iditems") + "\t" + rs2.getString("i_name") + "\t" + rs2.getString("i_desc") + 
						"\t" + rs2.getString("i_type") + "\t" + rs2.getString("artists_idartists")) ;
                                
                                data[row][0] = rs2.getString("iditems");
                                data[row][1] = rs2.getString("i_name");
                                data[row][2] = rs2.getString("i_desc");
                                data[row][3] = rs2.getString("i_type");
                                data[row][4] = rs2.getString("artists_idartists");
                                row++;
                                
			}
                        

            
                }
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
        
        
        return data;
    }
    
    //Checking favorites
    public String[][] Favorites(String pass) {
        
        String[][] cus = null;
        String[][] data = null;
        
        try{
            // Building the query
            //First queries are necessary to find out the customer ID - Favorites entity just accept customer ID to be insert
            String query = "SELECT * FROM customers WHERE cus_pwd ='" + pass +"';";
            String query2 = "SELECT * FROM customers WHERE cus_pwd = '" + pass +"';";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            
            ResultSet rs2 = stmt.executeQuery(query2);
            
            cus = new String[line][6];
                        int row = 0;
                        
			// Loop through the result set
			while(rs2.next()) {
				System.out.println(rs2.getString("idcustomers") + "\t" + rs2.getString("cus_name") + "\t" + rs2.getString("cus_username") + 
						"\t" + rs2.getString("cus_address") + "\t" + rs2.getString("cus_email") + "\t" + rs2.getString("cus_pwd")) ;
                                
                                cus[row][0] = rs2.getString("idcustomers");
                                cus[row][1] = rs2.getString("cus_name");
                                cus[row][2] = rs2.getString("cus_username");
                                cus[row][3] = rs2.getString("cus_address");
                                cus[row][4] = rs2.getString("cus_email");
                                cus[row][5] = rs2.getString("cus_pwd");
                                row++;
                                
			}
            //Saving the information required inside an variable
            String id = cus[0][0];
            System.out.println(id);
            
            //"SELECT * FROM mario_2018358.likes_favorites inner join mario_2018358.items on items_iditems = iditems inner join mario_2018358.artists on artists_idartists = idartists WHERE customers_idcustomers = '$login'";
            String query3 = "SELECT * FROM likes_favorites INNER JOIN items on items_iditems = iditems INNER JOIN artists on artists_idartists = idartists WHERE customers_idcustomers = '" + id + "';";
            String query4 = "SELECT * FROM likes_favorites INNER JOIN items on items_iditems = iditems INNER JOIN artists on artists_idartists = idartists WHERE customers_idcustomers = '" + id + "';";
            
            // Sending the query to the database
            ResultSet rs3 = stmt.executeQuery(query3);
            
            
            int line2 = 0;
            while(rs3.next()){
                line2++;
                
            }
            
            ResultSet rs4 = stmt.executeQuery(query4);
            
            data = new String[line2][5];
                        int row2 = 0;
                        
			// Loop through the result set
			while(rs4.next()) {
				System.out.println(rs4.getString("iditems") + "\t" + rs4.getString("i_name") + "\t" + rs4.getString("i_desc") + 
						"\t" + rs4.getString("i_type") + "\t" + rs4.getString("artists_idartists")) ;
                                
                                data[row2][0] = rs4.getString("iditems");
                                data[row2][1] = rs4.getString("i_name");
                                data[row2][2] = rs4.getString("i_desc");
                                data[row2][3] = rs4.getString("i_type");
                                data[row2][4] = rs4.getString("artists_idartists");
                                row2++;
                                
			}

            
                }
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
        
        
        return data;
    }
    
    /*
        SEARCHES
    */
    
    //search by name
    public String[][] searchByName(Controller controller) {
        
        String[][] data = null;
        
        try{
            // Building the query
            String query = "SELECT * FROM items WHERE i_name = '" + controller.searchView.artName.getText() + "';";
            String query2 = "SELECT * FROM items WHERE i_name = '" + controller.searchView.artName.getText() + "';";
            
            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            
            ResultSet rs2 = stmt.executeQuery(query2);
            
            data = new String[line][5];
                        int row = 0;
                        
			// Loop through the result set
			while(rs2.next()) {
				System.out.println(rs2.getString("iditems") + "\t" + rs2.getString("i_name") + "\t" + rs2.getString("i_desc") + 
						"\t" + rs2.getString("i_type") + "\t" + rs2.getString("artists_idartists")) ;
                                
                                data[row][0] = rs2.getString("iditems");
                                data[row][1] = rs2.getString("i_name");
                                data[row][2] = rs2.getString("i_desc");
                                data[row][3] = rs2.getString("i_type");
                                data[row][4] = rs2.getString("artists_idartists");
                                row++;
                                
			}
                        
                }
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
        
        
        return data;
    }
    
    //search by type
    public String[][] searchByType(Controller controller) {
        
        String[][] data = null;
        
        try{
            // Building the query
            String query = "SELECT * FROM items WHERE i_type = '" + controller.searchView.artType.getText() + "';";
            String query2 = "SELECT * FROM items WHERE i_type = '" + controller.searchView.artType.getText() + "';";
            
            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            
            ResultSet rs2 = stmt.executeQuery(query2);
            
            data = new String[line][5];
                        int row = 0;
                        
			// Loop through the result set
			while(rs2.next()) {
				System.out.println(rs2.getString("iditems") + "\t" + rs2.getString("i_name") + "\t" + rs2.getString("i_desc") + 
						"\t" + rs2.getString("i_type") + "\t" + rs2.getString("artists_idartists")) ;
                                
                                data[row][0] = rs2.getString("iditems");
                                data[row][1] = rs2.getString("i_name");
                                data[row][2] = rs2.getString("i_desc");
                                data[row][3] = rs2.getString("i_type");
                                data[row][4] = rs2.getString("artists_idartists");
                                row++;
                                
			}

            
                }
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
        
        
        return data;
    }
    
    //search by artist ID    
    public String[][] searchByArtistId(Controller controller) {
        
        String[][] data = null;
        
        try{
            // Building the query
            String query = "SELECT * FROM items WHERE artists_idartists = '" + controller.searchView.artistName.getText() + "';";
            String query2 = "SELECT * FROM items WHERE artists_idartists = '" + controller.searchView.artistName.getText() + "';";
            
            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            
            ResultSet rs2 = stmt.executeQuery(query2);
            
            data = new String[line][5];
                        int row = 0;
                        
			// Loop through the result set
			while(rs2.next()) {
				System.out.println(rs2.getString("iditems") + "\t" + rs2.getString("i_name") + "\t" + rs2.getString("i_desc") + 
						"\t" + rs2.getString("i_type") + "\t" + rs2.getString("artists_idartists")) ;
                                
                                data[row][0] = rs2.getString("iditems");
                                data[row][1] = rs2.getString("i_name");
                                data[row][2] = rs2.getString("i_desc");
                                data[row][3] = rs2.getString("i_type");
                                data[row][4] = rs2.getString("artists_idartists");
                                row++;
                                
			}

            
                }
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
        
        
        return data;
    }
    
    //Artists List
    public String[][] artistsList() {
        
        String[][] data = null;
        
        try{
            // Building the query
            String query = "SELECT * FROM artists;";
            String query2 = "SELECT * FROM artists;";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            
            ResultSet rs2 = stmt.executeQuery(query2);
            
            data = new String[line][4];
                        int row = 0;
                        
			// Loop through the result set
			while(rs2.next()) {
				System.out.println(rs2.getString("idartists") + "\t" + rs2.getString("art_name") + "\t" + rs2.getString("art_address") + 
						"\t" + rs2.getString("art_website")) ;
                                
                                data[row][0] = rs2.getString("idartists");
                                data[row][1] = rs2.getString("art_name");
                                data[row][2] = rs2.getString("art_address");
                                data[row][3] = rs2.getString("art_website");
                                row++;
                                
			}

            
                }
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
        
        
        return data;
    }
    
    //Admins List
    public String[][] adminsList() {
        
        String[][] data = null;
        
        try{
            // Building the query
            String query = "SELECT * FROM admins;";
            String query2 = "SELECT * FROM admins;";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            
            ResultSet rs2 = stmt.executeQuery(query2);
            
            data = new String[line][5];
                        int row = 0;
                        
			// Loop through the result set
			while(rs2.next()) {
				System.out.println(rs2.getString("idadmins") + "\t" + rs2.getString("adm_name") + "\t" + rs2.getString("adm_email") + 
						"\t" + rs2.getString("adm_username") + "\t" + rs2.getString("adm_pwd")) ;
                                
                                data[row][0] = rs2.getString("idadmins");
                                data[row][1] = rs2.getString("adm_name");
                                data[row][2] = rs2.getString("adm_email");
                                data[row][3] = rs2.getString("adm_username");
                                data[row][4] = rs2.getString("adm_pwd");
                                row++;
                                
			}

            
                }
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
        
        
        return data;
    }

    //Registration
    public void register(User userRegistered){
        
        try{
            // Building the query 
            String query = "INSERT INTO customers (cus_name, cus_username, cus_address, cus_email, cus_pwd) VALUES ('"+userRegistered.getName2()+"', '"+userRegistered.getUsername()+"', '"+userRegistered.getAddress()+"', '"+userRegistered.getEmail()+"', '"+userRegistered.getPassword()+"');";

            // Execute the query
            stmt.execute(query) ;
            

            
        }catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
        
    }
    
    //Like - Favorites
    public void likes(Controller controller){
        
        try{
            // Building the query
            //Getting customer ID
            String query = "SELECT * FROM customers;";
            String query2 = "SELECT * FROM customers WHERE cus_username = '" + controller.userLogged.getUn() +"';";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            
            ResultSet rs2 = stmt.executeQuery(query2);
            
            String[][]data;
            
            data = new String[line][4];
                        int row = 0;
                        
			// Loop through the result set
			while(rs2.next()) {
				System.out.println(rs2.getString("idcustomers") + "\t" + rs2.getString("cus_name") + "\t" + rs2.getString("cus_username") + 
						"\t" + rs2.getString("cus_address") + "\t" + rs2.getString("cus_email") + "\t" + rs2.getString("cus_pwd")) ;
                                
                                data[row][0] = rs2.getString("idcustomers");
                                data[row][1] = rs2.getString("cus_name");
                                data[row][2] = rs2.getString("cus_username");
                                data[row][3] = rs2.getString("cus_address");
                                data[row][3] = rs2.getString("cus_email");
                                data[row][3] = rs2.getString("cus_pwd");
                                row++;
                                
			}
            //saving user ID to a variable           
            String id = data[0][0];
            System.out.println(id);
            
            // Building the query 
            String query3 = "INSERT INTO likes_favorites (items_iditems, customers_idcustomers) VALUES ('"+ controller.welcome_cus.artID.getText() +"', '"+ id +"');";

            System.out.println(controller.welcome_cus.artID.getText() + id);
            // Execute the query
            stmt.execute(query3) ;
            
            new Done();

          
            
        }catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    //Update customer info
    public void updateCusInfo(User userRegistered, String pass, String newName, String newUsername, String newAddress, String newEmail, String newPassword){
        
        try{
            // Building the query
            //each query for specific changes, in this way it is not necessary to update all informations, just the ones you want
            String query = "UPDATE customers SET cus_name = '"+ newName +"' WHERE cus_pwd = '" + pass +"';";
            String query2 = "UPDATE customers SET cus_username = '"+ newUsername +"' WHERE cus_pwd = '" + pass +"';";
            String query3 = "UPDATE customers SET cus_email = '"+ newEmail +"' WHERE cus_pwd = '" + pass +"';";
            String query4 = "UPDATE customers SET cus_pwd = '"+ newPassword +"' WHERE cus_pwd = '" + pass +"';";
            String query5 = "UPDATE customers SET cus_address = '"+ newAddress +"' WHERE cus_pwd = '" + pass +"';";

            //checking which informations will be updated
            if(!newName.isEmpty()){
                stmt.execute(query);
                System.out.println("Name updated");
            }
            if(!newUsername.isEmpty()){
                stmt.execute(query2);
                System.out.println("Username updated");
            }
            if(!newEmail.isEmpty()){
                stmt.execute(query3);
                System.out.println("Email updated");
            }
            if(!newPassword.isEmpty()){
                stmt.execute(query4);
                System.out.println("Password updated");
            }
            if(!newAddress.isEmpty()){
                stmt.execute(query5);
                System.out.println("Address updated");
            }
            
            //In case none of the textfield were filled with information
            if(newName.isEmpty() && newUsername.isEmpty() && newEmail.isEmpty() && newPassword.isEmpty() && newAddress.isEmpty()){
                System.out.println("Nothing to update.");
                //send an alert in case there is nothing to be updated
                new Message();
            }else{
                //sending message in case the update got success
                new MessageUpdated();
            }
            
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    //Update Admin info - same logic of previous one
    public void updateAdminsInfo(User userRegistered, String pass, String newName, String newUsername, String newAddress, String newEmail, String newPassword){
        
        try{
            // Building the query
            String query = "UPDATE admins SET adm_name = '"+ newName +"' WHERE adm_pwd = '" + pass +"';";
            String query2 = "UPDATE admins SET adm_username = '"+ newUsername +"' WHERE adm_pwd = '" + pass +"';";
            String query3 = "UPDATE admins SET adm_email = '"+ newEmail +"' WHERE adm_pwd = '" + pass +"';";
            String query4 = "UPDATE admins SET adm_pwd = '"+ newPassword +"' WHERE adm_pwd = '" + pass +"';";

            if(!newName.isEmpty()){
                stmt.execute(query);
                System.out.println("Name updated");
            }
            if(!newUsername.isEmpty()){
                stmt.execute(query2);
                System.out.println("Username updated");
            }
            if(!newEmail.isEmpty()){
                stmt.execute(query3);
                System.out.println("Email updated");
            }
            if(!newPassword.isEmpty()){
                stmt.execute(query4);
                System.out.println("Password updated");
            }
            
            if(newName.isEmpty() && newUsername.isEmpty() && newEmail.isEmpty() && newPassword.isEmpty()){
                System.out.println("Nothing to update.");
                //send an alert
                new Message();
            }else{
                new MessageUpdated();
            }
            
       
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    //Update art - Editing Art's informations - Same logic as customer and admin's updates
    public void updateArt(String artID, String newNameArt, String newDescription, String newType, String newArtist){
        
        try{
            // Building the query
            String query = "UPDATE items SET i_name = '"+ newNameArt +"' WHERE iditems = '" + artID +"';";
            String query2 = "UPDATE items SET i_desc = '"+ newDescription +"' WHERE iditems = '" + artID +"';";
            String query3 = "UPDATE items SET i_type = '"+ newType +"' WHERE iditems = '" + artID +"';";
            String query4 = "UPDATE items SET artists_idartists = '"+ newArtist +"' WHERE iditems = '" + artID +"';";

            if(!newNameArt.isEmpty()){
                stmt.execute(query);
                System.out.println("Name updated");
            }
            if(!newDescription.isEmpty()){
                stmt.execute(query2);
                System.out.println("Description updated");
            }
            if(!newType.isEmpty()){
                stmt.execute(query3);
                System.out.println("Type updated");
            }
            if(!newArtist.isEmpty()){
                stmt.execute(query4);
                System.out.println("Artist updated");
            }
            
            if(newNameArt.isEmpty() && newDescription.isEmpty() && newType.isEmpty() && newArtist.isEmpty()){
                System.out.println("Nothing to update.");
                //send an alert
                new Message();
            }else{
                new MessageUpdated();
            }
            
           
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    //update artist details
    public void updateArtist(String artistID, String newArtistName, String newArtistAddress, String newArtistWebsite){
        
        try{
            // Building the query
            String query = "UPDATE artists SET art_name = '"+ newArtistName +"' WHERE idartists = '" + artistID +"';";
            String query2 = "UPDATE artists SET art_address = '"+ newArtistAddress +"' WHERE idartists = '" + artistID +"';";
            String query3 = "UPDATE artists SET art_website = '"+ newArtistWebsite +"' WHERE idartists = '" + artistID +"';";

            if(!newArtistName.isEmpty()){
                stmt.execute(query);
                System.out.println("Artist Name updated");
            }
            if(!newArtistAddress.isEmpty()){
                stmt.execute(query2);
                System.out.println("Address updated");
            }
            if(!newArtistWebsite.isEmpty()){
                stmt.execute(query3);
                System.out.println("Website updated");
            }
            
            if(newArtistName.isEmpty() && newArtistAddress.isEmpty() && newArtistWebsite.isEmpty()){
                System.out.println("Nothing to update.");
                //send an alert
                new Message();
            }else{
                new MessageUpdated();
            }
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    //Creating new Admin
    public void CreateNewAdmin(String newName, String newUsername, String newEmail, String newPassword){
        
        try{
            // Building the query
            String query = "INSERT INTO admins (adm_name, adm_email, adm_username, adm_pwd) VALUES ('"+newName+"', '"+newEmail+"', '"+newUsername+"', '"+newPassword+"');";
            
            stmt.execute(query);
            new MessageUpdated();
                        
           
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    //Creating new Artist
    public void CreateNewArtist(String name, String address, String website){
        
        try{
            // Building the query
            String query = "INSERT INTO artists (art_name, art_address, art_website) VALUES ('"+name+"', '"+address+"', '"+website+"');";
            
            stmt.execute(query);
            new MessageUpdated();
                        
          
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    //Creating new Art
    public void CreateNewArt(String name, String description, String type, String artist){
        
        try{
            // Building the query
            String query = "INSERT INTO items (i_name, i_desc, i_type, artists_idartists) VALUES ('"+name+"', '"+description+"', '"+type+"', '"+artist+"');";
            
            stmt.execute(query);
            new MessageUpdated();
                        
          
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    //Delete Admin
    public void DeleteAdmin(String username){
        
        //DELETE FROM table_name WHERE condition;
        
        try{
            // Building the query
            String query = "DELETE FROM admins WHERE adm_username = '" + username +"';";
            
            stmt.execute(query);
            new MessageUpdated();
                        
          
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    //Delete artist
    public void DeleteArtist(String name){
        
        //DELETE FROM table_name WHERE condition;
        
        String[][] data = null;
        
        try{
            // Building the query
            // Getting artists ID
            String query = "SELECT * FROM artists;";
            String query2 = "SELECT * FROM artists WHERE art_name = '" + name +"';";

            // Sending the query to the database
            ResultSet rs = stmt.executeQuery(query);
            
            
            int line = 0;
            while(rs.next()){
                line++;
                
            }
            
            ResultSet rs2 = stmt.executeQuery(query2);
            
            data = new String[line][4];
                        int row = 0;
                        
			// Loop through the result set
			while(rs2.next()) {
				System.out.println(rs2.getString("idartists") + "\t" + rs2.getString("art_name") + "\t" + rs2.getString("art_address") + 
						"\t" + rs2.getString("art_website")) ;
                                
                                data[row][0] = rs2.getString("idartists");
                                data[row][1] = rs2.getString("art_name");
                                data[row][2] = rs2.getString("art_address");
                                data[row][3] = rs2.getString("art_website");
                                row++;
                                
			}
            //insert ID into String
            String id = data[0][0];
            System.out.println(id);
            
            //before delete artists it is necessary to delete all its arts, because the its fk on that entity
            String query4 = "DELETE FROM items WHERE artists_idartists = '" + id +"';";
            String query5 = "DELETE FROM artists WHERE idartists = '" + id +"';";
                
            stmt.execute(query4);
            stmt.execute(query5);
            new MessageUpdated();
                        
                        
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
    //Delete art
    public void DeleteArt(String name){
        
        //DELETE FROM table_name WHERE condition;
        
        try{
            // Building the query
            String query = "DELETE FROM items WHERE i_name = '" + name +"';";
            
            stmt.execute(query);
            new MessageUpdated();
           
            
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;
        
            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }catch( Exception e ){
                System.out.println( e ) ;
        }
    }
    
        //Closings
        private void closings(){
            try {
                stmt.close();
                conn.close();
            }
            catch(SQLException ex){
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
}
