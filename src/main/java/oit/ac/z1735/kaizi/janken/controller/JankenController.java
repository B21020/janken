package oit.ac.z1735.kaizi.janken.controller;

//import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.ac.z1735.kaizi.janken.model.Entry;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class JankenController {

  private Entry entry;

  @Autowired
  public JankenController(Entry entry) {
    this.entry = entry;
  }

  @PostMapping("/janken")
  public String janken(@RequestParam String username, ModelMap model) {
    model.addAttribute("username", username);
    return "janken"; // janken.htmlを表示
  }

  @GetMapping("/janken")
  public String jankenPage(Model model) {
    // モデルにエントリの情報を設定
    model.addAttribute("loggedInUser", entry.getLoggedInUser());
    model.addAttribute("allUsers", entry.getAllUsers());
    return "janken";
  }

  @GetMapping("/play")
  public String playJanken(@RequestParam("choice") String userChoice, Model model) {
    // ユーザの選択を受け取り、CPUの選択と結果を計算
    String cpuChoice = "rock"; // CPUは常にグーを選択する例
    String result = calculateResult(userChoice, cpuChoice);

    // 結果をモデルに追加
    model.addAttribute("userChoice", userChoice);
    model.addAttribute("cpuChoice", cpuChoice);
    model.addAttribute("result", result);

    return "janken"; // janken.htmlを表示
  }

  // 結果を計算するビジネスロジックのメソッドを追加
  private String calculateResult(String userChoice, String cpuChoice) {
    if (userChoice.equals(cpuChoice)) {
      return "引き分け";
    } else if (userChoice.equals("rock")) {
      if (cpuChoice.equals("scissors")) {
        return "勝ち";
      } else {
        return "負け";
      }
    } else if (userChoice.equals("scissors")) {
      if (cpuChoice.equals("paper")) {
        return "勝ち";
      } else {
        return "負け";
      }
    } else if (userChoice.equals("paper")) {
      if (cpuChoice.equals("rock")) {
        return "勝ち";
      } else {
        return "負け";
      }
    }
    return "無効な選択"; // 予期せぬ選択がある場合
  }
}
