package model;

import entity.Member;

import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;

public class MemberModel {
    public boolean save(Member member) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/member-manager?user=root&password=");
            Statement statement = connection.createStatement();
            String sqlCommal = "insert into member (username, password, email, fullname, address, role)" +
                    "values ('" + member.getUsername() + "', '" + member.getPassword() + "', '" + member.getEmail() + "', '" + member.getFullName() + "', '" + member.getAddress() + "', '" + member.getRole() + "')";
            statement.execute(sqlCommal);
            System.out.println("Oki");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean save2(Member member) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sqlCommal = "insert into member (username, password, email, fullname, address, role) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommal);
            preparedStatement.setString(1, member.getUsername());
            preparedStatement.setString(2, md5(member.getPassword()));
            preparedStatement.setString(3, member.getEmail());
            preparedStatement.setString(4, member.getFullName());
            preparedStatement.setString(5, member.getAddress());
            preparedStatement.setString(6, member.getRole());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            /*JOptionPane.showMessageDialog(this, ex.toString(), "Error raise", JOptionPane.ERROR_MESSAGE);*/
        }
        return false;
    }

    public static String md5(String msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(msg.getBytes());
            byte byteData[] = md.digest();
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return  sb.toString();
        } catch (Exception ex) {
            return "";
        }
    }
    public ArrayList<Member> getList() {
        ArrayList<Member> results = new ArrayList<>();
        try {
            String sqlCommand = "select * from member";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String role = resultSet.getString("role");
                Member member = new Member();
                member.setUsername(username);
                member.setPassword(password);
                member.setFullName(fullName);
                member.setEmail(email);
                member.setAddress(address);
                member.setRole(role);
                results.add(member);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public Member findByUsernameAndStatus(String username, Member.Status status) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sqlCommad = "select * from member where username = ? and status = ?";
            PreparedStatement pePreparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommad);
            pePreparedStatement.setString(1, username);
            pePreparedStatement.setInt(2, status.getValue());
            ResultSet resultSet = pePreparedStatement.executeQuery();
            if (resultSet.next()){
                String rsUsername = resultSet.getString(1);
                String rsPassword = resultSet.getString(2);
                String rsEmail = resultSet.getString(3);
                String rsFullName = resultSet.getString(4);
                String rsAddress = resultSet.getString(5);
                int rsStatus = resultSet.getInt(6);
                String rsRole = resultSet.getString(7);
                Member member = new Member();
                member.setUsername(rsUsername);
                member.setPassword(rsPassword);
                member.setEmail(rsEmail);
                member.setFullName(rsFullName);
                member.setAddress(rsAddress);
                member.setStatus(Member.Status.findByValue(rsStatus));
                member.setRole(rsRole);
                return member;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
