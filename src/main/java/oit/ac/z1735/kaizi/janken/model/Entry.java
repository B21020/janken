package oit.ac.z1735.kaizi.janken.model;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Entry {

  private String loggedInUser;
  private Set<String> allUsers = new HashSet<>();

  public String getLoggedInUser() {
    return loggedInUser;
  }

  public Iterable<String> getAllUsers() {
    return allUsers;
  }

  public void loginUser(String username) {
    loggedInUser = username;
    allUsers.add(username);
  }

  public void logoutUser() {
    // ログアウト時の処理を追加する（セッションのクリアなど）
    loggedInUser = null;
  }
}
