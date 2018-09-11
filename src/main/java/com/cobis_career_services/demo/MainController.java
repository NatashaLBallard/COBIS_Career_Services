package com.cobis_career_services.demo;

//import com.cobis_career_services.demo.forms.Account;
import com.cobis_career_services.demo.forms.Account;
import com.cobis_career_services.demo.forms.Resume;
import com.cobis_career_services.demo.model.AppUser;
//import com.cobis_career_services.demo.repositories.AccountRepository;
import com.cobis_career_services.demo.repositories.AccountRepository;
import com.cobis_career_services.demo.repositories.AppRoleRepository;
import com.cobis_career_services.demo.repositories.AppUserRepository;
import com.cobis_career_services.demo.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    AppRoleRepository roleRepository;

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    AccountRepository accountRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping("/")
    public String showIndex()
    {
        return "index";
    }

    @RequestMapping("/login")
    public String showLogin()
    {
        return "/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model)
    {
        model.addAttribute("newuser",new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("newuser") AppUser user, BindingResult result)
    {
        String thePassword = user.getPassword();
        if(result.hasErrors())
        {
            return "register";
        }
        user.addRole(roleRepository.findByRole("USER"));
        user.setPassword(passwordEncoder.encode(thePassword));
        userRepository.save(user);
        return "redirect:/login";
    }

    @RequestMapping("/granteduser")
    public String showUser()
    {
        return "userpage";
    }

    @RequestMapping("/grantedadmin")
    public String showAdmin()
    {
        //You can call methods instead of redirecting
        System.out.println("Admin...");
        return showUser();
    }

    @RequestMapping("/logout")
    public String logOut()
    {
        return "logout";
    }












//
//    @RequestMapping("/display")
//    public String display(Model model) {
//        model.addAttribute("accounts", accountRepository.findAll());
//        return "display";
//    }
//
//
//    //Account Information
//
//    @Autowired
//    AccountRepository accountRepository;
//
//    @RequestMapping("/viewAccount")
//    public String listAccount(Model model) {
//        model.addAttribute("accounts", accountRepository.findAll());
//        return "viewAccount";
//    }
//
//    @GetMapping("/createAccount")
//    public String accountForm(Model model) {
//        model.addAttribute("account", new Account());
//        return "createAccount";
//    }
//
//    @PostMapping("/processAccount")
//    public String processAccountForm(@Valid Account account, BindingResult result) {
//        if (result.hasErrors()) {
//            System.out.println("errorrr");
//            return "viewAccount";
//
//        }
//        accountRepository.save(account);
//        System.out.println("save");
//        return "redirect:/viewAccount";
//
//    }




    // RESUME
    @RequestMapping("/display")
    public String listResumes(Model model) {
        model.addAttribute("resumes", resumeRepository.findAll());
        return "display";
    }

    @GetMapping("/add")
    public String resumeForm(Model model) {
        model.addAttribute("resume", new Resume());
        return "resumeform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Resume resume, BindingResult result) {
        if (result.hasErrors()) {
            return "resumeform";
        }
        resumeRepository.save(resume);
        return "redirect:/";
    }


    @RequestMapping("/detail/{id}")
    public String showResume(@PathVariable("id") long id, Model model) {
        model.addAttribute("resume", resumeRepository.findById(id));
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateResume(@PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepository.findById(id));
        return "resumeform";
    }

    @RequestMapping("/delete/{id}")
    public String delResume(@PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepository.findById(id));
        resumeRepository.deleteById(id);
        return "redirect:/display";
    }




// --------------------------- ACCOUNT ---------------------------

    @RequestMapping("/view-account")
    public String listAccounts(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        return "view-account";
    }

    @GetMapping("/add-account")
    public String accountForm(Model model) {
        model.addAttribute("account", new Account());
        return "account-form";
    }

    @PostMapping("/process-account")
    public String processAccountForm(@Valid Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "account-form";
        }
        accountRepository.save(account);
        return "redirect:/view-account";
    }

//    @RequestMapping("/update/{id}")
//    public String updateAccount(@PathVariable("id") long id, Model model){
//        model.addAttribute("account", accountRepository.findById(id));
//        return "accountForm";
//    }






}