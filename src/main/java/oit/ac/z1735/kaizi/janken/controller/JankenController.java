package oit.ac.z1735.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class JankenController {

  @PostMapping("/janken")
  public String janken(@RequestParam String username, ModelMap model) {
    model.addAttribute("username", username);
    return "janken.html"; // janken.htmlを表示
  }

  @GetMapping("/janken")
  public String jankenPage() {
    return "janken.html"; // janken.htmlを表示
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
    return cpuChoice;
    // 結果を計算するロジックを実装
    // 例: グー vs グー は引き分け、グー vs チョキ は勝ち、など
  }
}
