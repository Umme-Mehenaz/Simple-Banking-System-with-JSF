/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calculate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Calculation {

    int accNo;
    String accType;
    String accHolder;
    String nominee;
    String address;
    String phone;
    String nidNo;
    double balance;
    String password;
    String date;
    double deposit;
    double withdraw;
    double transfer;
    double currentBalance;
    double currentBalance2;
    
    public Calculation() {
    }

    public double getCurrentBalance2() {
        return currentBalance2;
    }

    public void setCurrentBalance2(double currentBalance2) {
        this.currentBalance2 = currentBalance2;
    }
    
    int accountFrom;
    int accountTo;

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }
    ArrayList<Calculation> list;

    public ArrayList<Calculation> getList() {
        return list;
    }

    public void setList(ArrayList<Calculation> list) {
        this.list = list;
    }

    public Calculation(int accNo, String accType, String accHolder, String nominee, String address, String phone, String nidNo, double balance, String password, String date, double deposit, double withdraw, double transfer) {
        this.accNo = accNo;
        this.accType = accType;
        this.accHolder = accHolder;
        this.nominee = nominee;
        this.address = address;
        this.phone = phone;
        this.nidNo = nidNo;
        this.balance = balance;
        this.password = password;
        this.date = date;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.transfer = transfer;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(String accHolder) {
        this.accHolder = accHolder;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNidNo() {
        return nidNo;
    }

    public void setNidNo(String nidNo) {
        this.nidNo = nidNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public double getTransfer() {
        return transfer;
    }

    public void setTransfer(double transfer) {
        this.transfer = transfer;
    }
    
    public String home(){
        return "HomePage.xhtml";
    }
    public String ca(){
      return "AccountForm.xhtml";
    }
    public String ckb(){
       return "CheckBalanceForm.xhtml"; 
    }
    public String dpb(){
        return "DepositForm.xhtml";
    }
    public String wthb(){
        return "WithdrawForm.xhtml";
    }
    public String trnsb(){
        return "TransferForm.xhtml";
    }
    
    
    public String insertCode() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_practice", "root", "nh123456");
            PreparedStatement pst = con.prepareStatement("INSERT INTO bank_account(acc_no, acc_type, acc_holder, nominee, address, phone, nid, balance, password, date) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, accNo);
            pst.setString(2, accType);
            pst.setString(3, accHolder);
            pst.setString(4, nominee);
            pst.setString(5, address);
            pst.setString(6, phone);
            pst.setString(7, nidNo);
            pst.setDouble(8, balance);
            pst.setString(9, password);
            pst.setString(10, date);
            int x = pst.executeUpdate();
            if(x!=-1){
                System.out.println("Success");
                return "AccountForm.xhtml?msg=Creation_Success&faces-redirect=true";
            }else{
              return "AccountForm.xhtml?msg=Creation_Fail&faces-redirect=true";  
            }
        } catch (Exception e) {
            System.out.println("Can't create Account");
            return "AccountForm.xhtml?msg=Submission_Fail&faces-redirect=true";
        }
    }

//    public String calc() {
//        insertCode();
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_practice", "root", "nh123456");
//            PreparedStatement pst = con.prepareStatement("SELECT * FROM bank_account WHERE acc_no = ?");
//            pst.setInt(1, accNo);
//            Calculation g;
//            ResultSet rs = pst.executeQuery();
//            list = new ArrayList<>();
//            while (rs.next()) {
//                g = new Calculation();
//                g.setAccNo(rs.getInt(1));
//                g.setAccType(rs.getString(2));
//                g.setAccHolder(rs.getString(3));
//                g.setNominee(rs.getString(4));
//                g.setAddress(rs.getString(5));
//                g.setPhone(rs.getString(6));
//                g.setNidNo(rs.getString(7));
//                g.setBalance(rs.getDouble(8));
//                g.setPassword(rs.getString(9));
//                g.setDate(rs.getString(10));
//                g.setDeposit(rs.getDouble(11));
//                g.setWithdraw(rs.getDouble(12));
//                g.setTransfer(rs.getDouble(13));
//                list.add(g);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return "CustomerInformation.xhtml";
//    }

    public String showAll() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_practice", "root", "nh123456");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM bank_account");
            Calculation g;
            ResultSet rs = pst.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                g = new Calculation();
                g.setAccNo(rs.getInt(1));
                g.setAccType(rs.getString(2));
                g.setAccHolder(rs.getString(3));
                g.setNominee(rs.getString(4));
                g.setAddress(rs.getString(5));
                g.setPhone(rs.getString(6));
                g.setNidNo(rs.getString(7));
                g.setBalance(rs.getDouble(8));
                g.setPassword(rs.getString(9));
                g.setDate(rs.getString(10));
                g.setDeposit(rs.getDouble(11));
                g.setWithdraw(rs.getDouble(12));
                g.setTransfer(rs.getDouble(13));
                list.add(g);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return "CustomerInformation.xhtml";
    }

    public String depositBalance() {

        PreparedStatement pst;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_practice", "root", "nh123456");
            pst = con.prepareStatement("SELECT * FROM bank_account WHERE acc_no = ?");
            pst.setInt(1, accNo);
            rs = pst.executeQuery();
            while (rs.next()) {
                currentBalance = rs.getDouble(8);
            }

            pst = con.prepareStatement("UPDATE bank_account SET balance = ?, last_diposit=? WHERE acc_no = ?");
            pst.setDouble(1, (currentBalance + deposit));
            pst.setDouble(2, deposit);
            pst.setInt(3, accNo);
            int x = pst.executeUpdate();
            if(x!=-1){
                System.out.println("Success");
                return "DepositForm.xhtml?msg=Deposit_Success&faces-redirect=true";
            }else{
              return "DepositForm.xhtml?msg=Deposit_Fail&faces-redirect=true";  
            }
        } catch (Exception e) {
            System.out.println("Can't create Account");
            return "DepositForm.xhtml?msg=Deposit_Fail&faces-redirect=true";
        }
        
    }
    
    public String withdrawBalance() {

        PreparedStatement pst;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_practice", "root", "nh123456");
            pst = con.prepareStatement("SELECT * FROM bank_account WHERE acc_no = ?");
            pst.setInt(1, accNo);
            rs = pst.executeQuery();
            while (rs.next()) {
                currentBalance = rs.getDouble(8);
            }

            pst = con.prepareStatement("UPDATE bank_account SET balance = ?, last_withdraw = ? WHERE acc_no = ?");
            pst.setDouble(1, (currentBalance - withdraw));
            pst.setDouble(2, withdraw);
            pst.setInt(3, accNo);
            int x = pst.executeUpdate();
            if(x!=-1){
                System.out.println("Success");
                return "WithdrawForm.xhtml?msg=Withdraw_Success&faces-redirect=true";
            }else{
              return "WithdrawForm.xhtml?msg=Withdraw_Fail&faces-redirect=true";  
            }
        } catch (Exception e) {
            System.out.println("Can't create Account");
            return "WithdrawForm.xhtml?msg=Submission_Fail&faces-redirect=true";
        }
        
    }
    
    public String transferBalance(){
       PreparedStatement pst;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_practice", "root", "nh123456");
            pst = con.prepareStatement("SELECT * FROM bank_account WHERE acc_no = ?");
            pst.setInt(1, accountFrom);
            rs = pst.executeQuery();
            while (rs.next()) {
                currentBalance = rs.getDouble(8);
            }
            
            pst = con.prepareStatement("SELECT * FROM bank_account WHERE acc_no = ?");
            pst.setInt(1, accountTo);
            rs = pst.executeQuery();
            while (rs.next()) {
                currentBalance2 = rs.getDouble(8);
            }
            
            pst = con.prepareStatement("UPDATE bank_account SET balance = ?, last_transfer = ? WHERE acc_no = ?");
            pst.setDouble(1, (currentBalance - transfer));
            pst.setDouble(2, transfer);
            pst.setInt(3, accountFrom);
            pst.executeUpdate();
            
            pst = con.prepareStatement("UPDATE bank_account SET balance = ?, last_transfer = ? WHERE acc_no = ?");
            pst.setDouble(1, (currentBalance2 + transfer));
            pst.setDouble(2, transfer);
            pst.setInt(3, accountTo);
            int x = pst.executeUpdate();
            if(x!=-1){
                System.out.println("Success");
                return "TransferForm.xhtml?msg=Transfer_Success&faces-redirect=true";
            }else{
              return "TransferForm.xhtml?msg=Transfer_Fail&faces-redirect=true";  
            }
        } catch (Exception e) {
            System.out.println("Can't create Account");
            return "TransferForm.xhtml?msg=Submission_Fail&faces-redirect=true";
        }
    }
    
    public String showForCustomer(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_practice", "root", "nh123456");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM bank_account WHERE acc_no = ? and password = ?");
            pst.setInt(1, accNo);
            pst.setString(2, password);
            Calculation g;
            ResultSet rs = pst.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                g = new Calculation();
                g.setAccNo(rs.getInt(1));
                g.setAccType(rs.getString(2));
                g.setAccHolder(rs.getString(3));
                g.setNominee(rs.getString(4));
                g.setAddress(rs.getString(5));
                g.setPhone(rs.getString(6));
                g.setNidNo(rs.getString(7));
                g.setPassword(rs.getString(9));
                g.setBalance(rs.getDouble(8));
                g.setDeposit(rs.getDouble(11));
                g.setWithdraw(rs.getDouble(12));
                g.setTransfer(rs.getDouble(13));
                list.add(g);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "InformationForUser.xhtml";
    }
    
    public String checkBlnc(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_practice", "root", "nh123456");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM bank_account WHERE acc_no = ?");
            pst.setInt(1, accNo);
            Calculation g;
            ResultSet rs = pst.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                g = new Calculation();
                g.setAccNo(rs.getInt(1));
                g.setAccType(rs.getString(2));
                g.setAccHolder(rs.getString(3));
                g.setPhone(rs.getString(6));
                g.setBalance(rs.getDouble(8));
                list.add(g);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "ShowBalance.xhtml";
    }
    
    public String back(){
        return "UserLogin.xhtml";
    }
            
}
